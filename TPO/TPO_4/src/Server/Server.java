package Server;

import Requests.CreateRequest;
import Requests.Request;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.*;

public class Server {
    public static Map<String, List<SocketChannel>> Topics = new HashMap<>();
    public static List<SocketChannel> socketsConnected = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        Selector selector = Selector.open();
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.bind(new InetSocketAddress(ServerSettings.SERVER_ADDRES, ServerSettings.PORT));
        serverSocket.configureBlocking(false);
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {

            try {
                selector.select();
                Set<SelectionKey> selectedKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectedKeys.iterator();

                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();

                    if (key.isAcceptable()) {
                        SocketChannel clientSocketChannel = serverSocket.accept();
                        clientSocketChannel.configureBlocking(false);
                        clientSocketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                        socketsConnected.add(clientSocketChannel);
                    }

                    if (key.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) key.channel();

                        ByteBuffer buffer = ByteBuffer.allocate(ServerSettings.BUFFER_SIZE);
                        try {
                            socketChannel.read(buffer);
                        } catch (IOException exception) {
                            closeChannel(socketChannel);
                            continue;
                        }
                        if (buffer.position() == 0) {
                            closeChannel(socketChannel);
                            continue;
                        }

                        String message = BufferToString.ToString(buffer);
                        System.out.println(message);

                        if (message.equals("client")) {

                            try { StringBuilder stringBuilder = new StringBuilder(); for (String topic :
                                    Topics.keySet()) { if (stringBuilder.length() == 0) {
                                stringBuilder.append(topic); } else {
                                stringBuilder.append("::").append(topic); } }

                                String topicsString = stringBuilder.toString(); if (topicsString.isEmpty()) {
                                    topicsString = "[]"; }
                                socketChannel.write(ByteBuffer.wrap(topicsString.getBytes())); } catch
                            (IOException ex) { System.out.println(ex.toString());
                                System.out.println("Could not send topic !"); }


                        } else {
                            Request request = CreateRequest.createRequest(message, socketChannel);
                            request.serviceRequest();
                        }
                    }

                    iterator.remove();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

    }


    private static void closeChannel(SocketChannel socketChannel) throws IOException {
        socketChannel.close();
        for (List<SocketChannel> socketChannels : Topics.values()) {
            socketChannels.remove(socketChannel);
        }
        socketsConnected.remove(socketChannel);
    }
}



