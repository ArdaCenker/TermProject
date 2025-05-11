package application;
	
import enemy.Enemy;
import javafx.application.Application;
import javafx.stage.Stage;
import level.Level;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();

			Scene scene = new Scene(root,800,800);
			Level level1 = new Level("level1.txt");
			// TODO: ARDA buraya BOX_SIZE ı parametre olarak da ekledim kuzen!!
			Enemy enemy = new Enemy(level1.getPath().get(0), 100, 10, level1.getBOX_SIZE() ,level1.getPath());
			enemy.moveEnemy();
			StackPane pane = new StackPane();
			pane.getChildren().addAll(level1.drawLevel(),enemy.drawEnemy(enemy.getPosition()));
			root.setCenter(pane);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

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
