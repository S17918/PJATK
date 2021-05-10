package zad1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Futil {
    public static void processDir(String dir, String resFile){

        Path inputDir = Paths.get(dir);
        Path outFile = Paths.get(resFile);

        FileVisitorTPO FileVisitorTPO = new FileVisitorTPO(outFile);

        try{
            Files.walkFileTree(inputDir, FileVisitorTPO);
        }catch (IOException e){
            e.printStackTrace();
        }
        

    }
}