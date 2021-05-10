package Server;

import java.nio.ByteBuffer;

public class BufferToString {
    public static String ToString(ByteBuffer buffer) {

        byte[] bytesTab = new byte[buffer.position()];

        buffer.rewind();
        buffer.get(bytesTab, 0, bytesTab.length);

        return new String(bytesTab);
    }
}
