package designs;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import level.Level;

//150123012 Arda Cenker Karagöz - 150123002 Ali Faik Aksoy(sadece tasarım)
//this class for win page
public class WinPage {
	
	private Level level;
	private int currentLevel;
	
	public WinPage() {
		currentLevel = level.getCurrentLevel();
	}
	
	//this method for showing win page
	public Scene showWinPage() {
		Label label = new Label("You won!");
	    label.setStyle("-fx-font-size: 30px; -fx-text-fill: black;"); 
	   
	    Button contButton = new Button("Continue to Next Level");
	    contButton.setPrefSize(300, 150); 
	    //we assign an action the the button if we press to the button, we see game screen for 
	    //next level with increasing currentLevel for 1.
	    if(currentLevel < 5) {
//	    	contButton.setOnAction();
	    }
	  
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
