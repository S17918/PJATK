package Admin;

import Server.ServerService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;



public class AdminController {

    @FXML
    private TextField TopicField;
    @FXML
    private TextField NewsField;
    @FXML
    private TextArea NewsArea;
    @FXML
    private Label TopicLabel;
    @FXML
    private Label NewsLabel;

    @FXML
    public void initialize(){
        TopicLabel.setVisible(false);
        NewsLabel.setVisible(false);
    }



    private final ServerService serverService;
    private final List<String> Topics_List = new ArrayList<>();
    private final ObservableList<String> Topics = FXCollections.observableList(Topics_List);



    public AdminController() throws IOException {
        SocketChannel serverSocketChannel = SocketChannel.open(
                new InetSocketAddress("localhost", Server.ServerSettings.PORT)
        );
        serverService = new ServerService(serverSocketChannel);
    }

    public void newTopic(){
        if (!TopicField.getText().isEmpty()) {
            try {
                serverService.newTopic(TopicField.getText());
            } catch (IOException exception) {
                exception.printStackTrace();
                TopicLabel.setText("Błąd podczas dodawania tematu");
            }
            TopicLabel.setVisible(true);
            TopicField.setText("");
        }
    }

    public void newNews(){
        if (!NewsField.getText().isEmpty() && !NewsArea.getText().isEmpty()) {
            try {
                serverService.newNews(NewsField.getText(), NewsArea.getText());
            } catch (IOException exception) {
                exception.printStackTrace();
                NewsLabel.setText("Błąd podczas wysyłania news");
            }
            NewsLabel.setVisible(true);
            NewsField.setText("");
            NewsArea.setText("");
        }
    }

}
