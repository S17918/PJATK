package MP01.GUI;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MenuController {

    @FXML
    public void exit(){
        Platform.exit();
    }

    @FXML
    public void myProfile(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("myProfile.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Mój Profil");
            stage.setScene(new Scene(root));
            stage.show();

        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
