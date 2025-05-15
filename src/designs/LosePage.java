package designs;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class LosePage {
	
	protected StartPage page;
	
	public LosePage() {
		this.page = new StartPage();
	}

    public Scene showLosePage() {
		Label label = new Label("You lose!");
	    label.setStyle("-fx-font-size: 30px; -fx-text-fill: black;"); 
	   
	    Button contButton = new Button("Back to Main Menu");
	    contButton.setPrefSize(300, 150); 
	    
	    contButton.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override 
	    	public void handle(ActionEvent e) {
	    	 	page.showStartPage();
	    	 }
	    });
	  
	    contButton.setStyle("-fx-background-color:rgb(125, 119, 179);-fx-font-size: 25px;-fx-border-color: black;-fx-text-fill: white;"); 
	    
	    VBox layout = new VBox();
	    layout.setAlignment(Pos.CENTER); 
	    layout.setSpacing(20); 
	    layout.getChildren().addAll(label, contButton); 
	    layout.setStyle("-fx-background-color: lightblue;"); 
	    
	    Scene scene = new Scene(layout, 400, 400);
		return scene;
    }
}