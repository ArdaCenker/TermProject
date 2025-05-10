package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import level.Level;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			Level level1 = new Level("level1.txt");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			root.getChildren().addAll(level1.drawLevel());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
