package static_designs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//150123002 Ali Faik Aksoy
public class StartPage extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane centerPane = new StackPane();
        Button startButton = new Button("START GAME");
        startButton.setPrefSize(300, 150);
        centerPane.getChildren().add(startButton);

        startButton.setStyle("-fx-background-color: #4C98AF; -fx-text-fill: white; -fx-font-size: 25px;");

        centerPane.setStyle("-fx-background-color: lightblue;"); 

        Scene scene = new Scene(centerPane, 400, 400);
        primaryStage.setTitle("GAME");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
