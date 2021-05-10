package Requests;

import java.nio.channels.SocketChannel;

public abstract class Request {
    protected final SocketChannel socketChannel;

    public Request(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    public SocketChannel getChannel() {
        return socketChannel;
    }

    public abstract void serviceRequest();
}
