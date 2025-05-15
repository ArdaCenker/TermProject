package designs;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//150123012 Arda Cenker Karagöz - 150123002 Ali Faik Aksoy(sadece tasarım)
//this class for start page
public class StartPage {
	
	//this method shows start page
    public Scene showStartPage() {
        StackPane centerPane = new StackPane();
        Button startButton = new Button("START GAME");
        startButton.setPrefSize(300, 150);
        centerPane.getChildren().add(startButton);
        
        //we assign an action the the button if we press to the button, we see game screen for level 1.
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
