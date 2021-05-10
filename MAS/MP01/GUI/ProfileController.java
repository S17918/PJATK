package MP01.GUI;

import MP01.Program;
import MP01.Zawodnik;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class ProfileController {
    @FXML
    private Button closeButton;
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField sexField;
    @FXML
    private TextField peselField;
    @FXML
    private TextField positionField;
    @FXML
    private TextField pointsField;
    @FXML
    private TextField recordField;

    @FXML
    public void close(){
        Window stage = closeButton.getScene().getWindow();
        stage.hide();
    }

    @FXML
    public void exit(){
        Platform.exit();
    }

    Program program = new Program();
    Zawodnik zawodnik = program.returnZawodnik();

    @FXML
    public void initialize(){
        nameField.setText(zawodnik.Name);
        surnameField.setText(zawodnik.Surname);
        sexField.setText(zawodnik.Sex);
        peselField.setText(zawodnik.Pesel);
        positionField.setText(String.valueOf(zawodnik.rankingPosition));
        pointsField.setText(String.valueOf(zawodnik.score));
        recordField.setText(String.valueOf(zawodnik.personalRecord +" m"));
    }

    @FXML
    public void zapiszNaZawody(){
        try{
            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("Zawody.fxml"));
            Parent root2 = (Parent) loader2.load();
            Stage stage = new Stage();
            stage.setTitle("Zapisz na zawody");
            stage.setScene(new Scene(root2));
            stage.show();

        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
