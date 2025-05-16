package static_designs;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

//150123002 Ali Faik Aksoy
public class LostPage extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Game Over!");
        label.setStyle("-fx-font-size: 30px; -fx-text-fill: black;"); 
       
        Button contButton = new Button("Back to Main Menu");
        contButton.setPrefSize(300, 150); 
        contButton.setStyle("-fx-background-color:rgb(125, 119, 179);-fx-font-size: 25px;-fx-border-color: black;-fx-text-fill: white;"); 
        
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER); 
        layout.setSpacing(20); 
        layout.getChildren().addAll(label, contButton); 
        layout.setStyle("-fx-background-color: lightblue;"); 
        
        Scene scene = new Scene(layout, 400, 400);
        primaryStage.setTitle("WIN PAGE");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}