import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class main{
    public static void main(String[] args){
        int l0123;
    }

    public boolean check(){
        try {
            FileInputStream fstream = new FileInputStream("1.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;

            while((line = br.readLine()) != null){
                Pattern p = Pattern.compile("\\+48\\s\\d{3}\\s\\d{3}\\s\\d{3}");
            }

        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}