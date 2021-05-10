package zad1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorTPO extends SimpleFileVisitor<Path> {
    
    private static FileChannel outFileChannel;
    private static ByteBuffer buff;
    private static Charset inputChar = Charset.forName("Cp1250");
    private static Charset outputChar = Charset.forName("UTF-8");


    public FileVisitorTPO(Path outFile){
        try {
            outFileChannel = FileChannel.open(outFile, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void toUTF (FileChannel inputChannel, long buffsize){
        buff = ByteBuffer.allocate((int)(buffsize));
        buff.clear();

        try {
            
            inputChannel.read(buff);
            buff.flip();

            CharBuffer charbuff = inputChar.decode(buff);
            ByteBuffer newbuff = outputChar.encode(charbuff);

            while(newbuff.hasRemaining()){
                outFileChannel.write(newbuff);
            }

        } catch (IOException e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }

    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attribute){
        if(attribute.isSymbolicLink()){
            System.out.format("Symbolic link: %s", file);
        }else if(attribute.isRegularFile()){
            System.out.format("Regular file: %s", file);
        }else{
            System.out.format("Other: %s", file);
        }

        try {
            toUTF(FileChannel.open(file), attribute.size());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return FileVisitResult.CONTINUE;
    }



}