package Requests;

import java.nio.channels.SocketChannel;

public class CreateRequest {
    public static Request createRequest(String request, SocketChannel socketChannel) {

        String[] requestSplitByType = request.split("::");
        if (requestSplitByType.length != 2) {
            throw new IllegalArgumentException();
        }

        String type = requestSplitByType[0];
        String content = requestSplitByType[1];

        switch (TypeOfRequest.valueOf(type)) {

            case AddTopic:
                return new TopicRequest(socketChannel, content);

            case AddNews:
                String[] contentParts = content.split("__");
                if (contentParts.length != 2) {
                    throw new IllegalArgumentException();
                }
                String topic = contentParts[0];
                String news = contentParts[1];
                return new NewsRequest(socketChannel, topic, news);

            case SubscribeTopic:
                return new FollowRequest(socketChannel, content);

            default:
                throw new IllegalArgumentException();
        }
    }

    private enum TypeOfRequest {
        AddTopic,
        AddNews,
        SubscribeTopic,
    }

}
