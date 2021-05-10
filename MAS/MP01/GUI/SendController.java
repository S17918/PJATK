package MP01.GUI;

import MP01.Program;
import MP01.Zawodnik;
import javafx.fxml.FXML;
import javafx.stage.Window;
import javafx.scene.control.Button;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SendController {
    @FXML
    private Button closeButton;

    public void close(){
        Window stage = closeButton.getScene().getWindow();
        stage.hide();
    }

    ZawodyController controller = new ZawodyController();
    DateFormat df = new SimpleDateFormat("dd_MM_yyyy");
    String data = df.format(new Date());
    Program program = new Program();
    Zawodnik zawodnik = program.returnZawodnik();


    public void doNotSend() throws IOException {

        String random = new String(Files.readAllBytes(Paths.get("random_number.txt")));


        File f = new File("C:/Users/Piotrek/IdeaProjects/MAS/MP01/Zgłoszenia/Zgłoszenie_"+random+"_"+data+"_"+zawodnik.Name+"_"+zawodnik.Surname+"_"+zawodnik.Pesel+".txt");

            f.delete();
            Window stage = closeButton.getScene().getWindow();
            stage.hide();


    }

}
