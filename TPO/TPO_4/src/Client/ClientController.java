package Client;

import Events.CreateEvent;
import Events.Event;
import Events.NewsEvent;
import Events.TopicEvent;
import Server.BufferToString;
import Server.ServerService;
import Server.ServerSettings;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ClientController {
    @FXML
    private ComboBox<String> TopicBox;
    @FXML
    private ListView<String> NewsView;
    @FXML
    private Label SubscribeLabel;

    @FXML
    public void initialize(){
        TopicBox.setItems(Topics);
        NewsView.setItems(News);
        SubscribeLabel.setVisible(false);
    }

    private final ServerService serverService;
    private final List<String> initTopics = new ArrayList<>();
    private final ObservableList<String> Topics = FXCollections.observableList(initTopics);
    private final ObservableList<String> News = FXCollections.observableList(new ArrayList<>());

    public ClientController() throws IOException {
        SocketChannel serverSocketChannel = SocketChannel.open(
                new InetSocketAddress(ServerSettings.SERVER_ADDRES, ServerSettings.PORT)
        );
        serverSocketChannel.write(ByteBuffer.wrap("client".getBytes()));
        ByteBuffer buffer = ByteBuffer.allocate(ServerSettings.BUFFER_SIZE);
        serverSocketChannel.read(buffer);

        String topicsString = BufferToString.ToString(buffer);
        System.out.println(topicsString);
        if (!topicsString.equals("[]")) {
            String[] topics = topicsString.split("::");
            initTopics.addAll(Arrays.asList(topics));
        }

        serverService = new ServerService(serverSocketChannel);

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                while (true) {
                    try {
                        ByteBuffer buffer = ByteBuffer.allocate(ServerSettings.BUFFER_SIZE);
                        System.out.println("Read");
                        serverSocketChannel.read(buffer);
                        String message = BufferToString.ToString(buffer);
                        System.out.println(message);

                        Event event = CreateEvent.createEvent(message);
                        NewEvent(event);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                        return null;
                    }
                }
            }
        };
        new Thread(task).start();
    }

    public void subscribeTopic(){
        String selectedTopic = TopicBox.getValue();
        if (selectedTopic != null) {
            try {
                serverService.subscribeTopic(selectedTopic);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        SubscribeLabel.setVisible(true);
    }

    public void NewEvent(Event event){
        if (event instanceof TopicEvent) {
            Platform.runLater(() -> {
                Topics.add(event.getContent());
            });
        } else if (event instanceof NewsEvent) {
            Platform.runLater(() -> {
                News.add(event.getContent() + " (" + ((NewsEvent) event).getTopic() + ")");
            });
        } else {
            throw new IllegalArgumentException();
        }
    }
}
