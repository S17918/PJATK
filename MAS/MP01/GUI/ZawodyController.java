package MP01.GUI;

import MP01.Program;
import MP01.Zawodnik;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ZawodyController {
    @FXML
    public Button closeButton;
    @FXML
    public Button chooseButton;
    @FXML
    public Button sendButton;
    @FXML
    public TextField nameField;
    @FXML
    public TextField surnameField;
    @FXML
    public TextField sexField;
    @FXML
    public TextField peselField;
    @FXML
    public TextField zawodyField;
    @FXML
    public TextArea commentArea;
    @FXML
    public ListView<String> zawodyListView;



    public void generateNumber() throws FileNotFoundException {
        int random = (int) (Math.random() *10000);
        PrintWriter writer = new PrintWriter("random_number.txt");
        System.out.println(random);
        writer.print(random);
        writer.close();
    }

    public ZawodyController(){

    }

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
    ArrayList<String> output = new ArrayList<>();

    @FXML
    private void handleClick(){
        zawodyField.setText(zawodyListView.getSelectionModel().getSelectedItem());
    }

    @FXML
    public void initialize() throws FileNotFoundException {
        nameField.setText(zawodnik.Name);
        surnameField.setText(zawodnik.Surname);
        sexField.setText(zawodnik.Sex);
        peselField.setText(zawodnik.Pesel);
        commentArea.setText("");
        check();
        generateNumber();

        sendButton.setOnAction(e ->{


            output.add(zawodyListView.getSelectionModel().getSelectedItem());
            output.add(nameField.getText());
            output.add(surnameField.getText());
            output.add(sexField.getText());
            output.add(peselField.getText());
            output.add(commentArea.getText());

            try {
                outputArray(output);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }


            FXMLLoader loader3 = new FXMLLoader(getClass().getResource("send.fxml"));
            Parent root3 = null;
            try {
                root3 = (Parent) loader3.load();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            Stage stage = new Stage();
                stage.setTitle("Potwierdzenie");
                stage.setScene(new Scene(root3));
                stage.show();

            Window stage_close = sendButton.getScene().getWindow();
            stage_close.hide();

        });

    }

    public void outputArray(ArrayList<String> array) throws IOException {
        DateFormat df = new SimpleDateFormat("dd_MM_yyyy");
        String data = df.format(new Date());

        String random = new String(Files.readAllBytes(Paths.get("random_number.txt")));

        PrintWriter writer = new PrintWriter(new File("C:/Users/Piotrek/IdeaProjects/MAS/MP01/Zgłoszenia","Zgłoszenie_"+random+"_"+data+"_"+zawodnik.Name+"_"+zawodnik.Surname+"_"+zawodnik.Pesel+".txt"));
        for(int i = 0; i < array.size(); i++){
            System.out.println(array.get(i));
            writer.print(array.get(i)+";");
        }
        writer.close();
    }




    public ArrayList<String> nazwy = program.zawodyList();

    public void check(){
        if(nazwy.isEmpty()){
            zawodyField.setText("Brak dostępnych zawodów");
            sendButton.setVisible(false);
        }else zawodyListView.getItems().addAll(program.zawodyList());
    }


    public void send(){
        try{
            FXMLLoader loader3 = new FXMLLoader(getClass().getResource("send.fxml"));
            Parent root3 = (Parent) loader3.load();
            Stage stage = new Stage();
            stage.setTitle("Potwierdzenie");
            stage.setScene(new Scene(root3));
            stage.show();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
