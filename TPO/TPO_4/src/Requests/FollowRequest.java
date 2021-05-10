package Requests;

import Server.Server;

import java.nio.channels.SocketChannel;
import java.util.List;

public class FollowRequest extends Request{
    private final String topic;

    public FollowRequest(SocketChannel socketChannel, String topic) {
        super(socketChannel);
        this.topic = topic;
    }

    public String getTopic() {
        return topic;
    }

    public void serviceRequest() {
        if (!Server.Topics.containsKey(topic)) {
            throw new IllegalArgumentException("Wprowadzony temat nie istnieje!");
        }

        List<SocketChannel> socketChannels = Server.Topics.get(topic);
        if (!socketChannels.contains(socketChannel)) {
            socketChannels.add(socketChannel);
        }
    }
}
