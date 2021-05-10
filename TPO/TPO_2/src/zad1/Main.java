/**
 *
 *  @author Wasilewski Piotr S17918
 *
 */

package zad1;

import org.json.JSONObject;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Main extends Application {

  private static String wikipedia;
  private static String weatherJson;
  private static Double rate1;
  private static Double rate2;
  private static String Country = "Poland";
  private static String City = "Warsaw";
  private static String Currency_Code ="USD";

  private Button Edit, Exit, Show, Edit_Exit, Edit_Commit; 
  private TextField Country_Field, City_Field, Currency_Field;
  private TextArea Wyszukiwarka, Kursy;
  private Scene Scena, Scena_Edit;
  private Pane kontener, kontener_edit;
  private WebView browser;
  private WebEngine engine;

  private void Scena (Stage primaryStage){

    Show = new Button("Pokaż dane");
    Show.setOnAction((event ->{
      if(weatherJson != null){
        show_weather(formatWeather(weatherJson));
      }
  
      if(rate1 != null && rate2 != null){
        show_kurs("Kurs Waluty:     " + rate1 +"\n" + "Kurs NBP:         " + rate2);
      }
  
    }));

    Edit = new Button("Zmień dane");
    Edit.setOnAction((event ->{
      edit();

    }));

    Exit = new Button("Wyjście");
    Exit.setOnAction((event ->{
      System.exit(0);
      System.out.println("Poprawnie zamknięto program");
    }));


    Wyszukiwarka = new TextArea();
    Kursy = new TextArea();
    
    kontener = new Pane();
    kontener.setPadding(new Insets(20, 20, 20, 20));

    Show.setLayoutX(340);
    Show.setLayoutY(20);
    Show.setMinSize(160, 50);

    Edit.setLayoutX(500);
    Edit.setLayoutY(20);
    Edit.setMinSize(160, 50);

    Exit.setLayoutX(660);
    Exit.setLayoutY(20);
    Exit.setMinSize(160, 50);

    Wyszukiwarka.setLayoutX(20);
    Wyszukiwarka.setLayoutY(90);
    Wyszukiwarka.setMinSize(800, 10);

    Kursy.setLayoutX(20);
    Kursy.setLayoutY(20);
    Kursy.setMaxSize(300, 50);

    kontener.getChildren().add(Edit);
    kontener.getChildren().add(Exit);
    kontener.getChildren().add(Wyszukiwarka);
    kontener.getChildren().add(Kursy);
    kontener.getChildren().add(Show);

    browser = new WebView();
    engine = browser.getEngine();

    kontener.getChildren().add(browser);
    browser.setLayoutX(20);
    browser.setLayoutY(290);

    engine.load(wikipedia);

    Scena = new Scene(kontener, 840, 910);

  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Scena(primaryStage);
    primaryStage.setTitle("TPO 2");
    primaryStage.setScene(Scena);
    primaryStage.show();
  }

  public void show_weather(String text){
    Wyszukiwarka.clear();
    Wyszukiwarka.appendText(text);
  }

  public void show_kurs(String text){
    Kursy.clear();
    Kursy.appendText(text);
  }

  public void edit(){
    kontener_edit = new Pane();
      kontener_edit.setPadding(new Insets(20, 20, 20, 20));

      Scena_Edit = new Scene(kontener_edit, 400, 200);
      Country_Field = new TextField("Podaj Kraj");
      City_Field = new TextField("Podaj Miasto");
      Currency_Field = new TextField("Podaj skrót waluty");

      Stage edit = new Stage();
      edit.setTitle("Zmień Dane");
      edit.setScene(Scena_Edit);
      edit.show();

      Edit_Exit = new Button("Zamknij");
      Edit_Exit.setOnAction((event -> {
        edit.hide();
      }));

      Edit_Commit = new Button("Zatwierdź");
      Edit_Commit.setOnAction((event ->{
        
        //Add threads to update GUI
      }));

      Country_Field.setMinSize(320, 20);
      Country_Field.setLayoutX(40);
      Country_Field.setLayoutY(20);

      City_Field.setMinSize(320, 20);
      City_Field.setLayoutX(40);
      City_Field.setLayoutY(60);

      Currency_Field.setMinSize(320, 20);
      Currency_Field.setLayoutX(40);
      Currency_Field.setLayoutY(100);

      Edit_Commit.setMinSize(170, 30);
      Edit_Commit.setLayoutX(20);
      Edit_Commit.setLayoutY(150);

      Edit_Exit.setMinSize(170, 30);
      Edit_Exit.setLayoutX(210);
      Edit_Exit.setLayoutY(150);

      kontener_edit.getChildren().add(Edit_Exit);
      kontener_edit.getChildren().add(Edit_Commit);
      kontener_edit.getChildren().add(Country_Field);
      kontener_edit.getChildren().add(City_Field);
      kontener_edit.getChildren().add(Currency_Field);

  }



  public String formatWeather(String raw_text){
    String formatted_text ="";

    try {
      JSONObject obj = new JSONObject(raw_text);

      if(!obj.isNull("main")){
        formatted_text += "Miasto: " + obj.getString("name") +"\n";
        formatted_text += "Kraj: " + obj.getJSONObject("sys").get("country") + "\n";
        formatted_text += "Temperatura: " + obj.getJSONObject("main").get("temp") + "\n";
        formatted_text += "Temperatura min: " + obj.getJSONObject("main").get("temp_min") + "\n";
        formatted_text += "Temperatura max: " + obj.getJSONObject("main").get("temp_max") + "\n";
        formatted_text += "Ciśnienie: " + obj.getJSONObject("main").get("pressure") + "\n";
        formatted_text += "Wilgotność: " + obj.getJSONObject("main").get("humidity") + "\n";
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return formatted_text;
  }
  
  public static void main(String[] args) {
      Service s = new Service(Country);
      weatherJson = s.getWeather(City);
      rate1 = s.getRateFor(Currency_Code);
      rate2 = s.getNBPRate();
      wikipedia = s.WikiDescription(City);
    
    launch(args);

  }

  
}