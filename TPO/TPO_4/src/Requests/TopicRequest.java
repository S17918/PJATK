package Requests;

import Server.Server;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

public class TopicRequest extends Request{
    private final String topic;

    public TopicRequest(SocketChannel socketChannel, String topic) {
        super(socketChannel);
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void serviceRequest() {
        if (!Server.Topics.containsKey(topic)) {
            Server.Topics.put(topic, new ArrayList<>());

            String topic = "Topic::" + this.topic;
            for (SocketChannel channel : Server.socketsConnected) {
                try {
                    channel.write(ByteBuffer.wrap(topic.getBytes()));
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}
