package designs;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StartPage {

    public Scene showStartPage() {
        StackPane centerPane = new StackPane();
        Button startButton = new Button("START GAME");
        startButton.setPrefSize(300, 150);
        centerPane.getChildren().add(startButton);
        
        startButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e) {
				
			}
        });

        startButton.setStyle("-fx-background-color: #4C98AF; -fx-text-fill: white; -fx-font-size: 25px;");

        centerPane.setStyle("-fx-background-color: lightblue;"); 

        Scene scene = new Scene(centerPane, 400, 400);
        
        return scene;
        
    }
}
