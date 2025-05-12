package application;
	
import enemy.Enemy;
import javafx.application.Application;
import javafx.stage.Stage;
import level.Level;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.animation.AnimationTimer;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 800, 800);

			// Load level
			Level level1 = new Level("level1.txt");

			// Create enemy
			Enemy enemy = new Enemy(level1.getPath().get(0), 100, 60, level1.getBOX_SIZE(), level1.getPath());

			// Draw level and enemy visuals
			Pane levelPane = level1.drawLevel();
			Pane enemyVisual = enemy.drawEnemy(enemy.getPosition());

			StackPane pane = new StackPane();
			pane.getChildren().addAll(levelPane, enemyVisual);
			root.setCenter(pane);

			// CSS (leave unchanged)
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.show();

			// === Animation Loop (ADDED) ===
			AnimationTimer timer = new AnimationTimer() {
				private long lastUpdate = 0;

				@Override
				public void handle(long now) {
					if (lastUpdate > 0) {
						double dt = (now - lastUpdate) / 1_000_000_000.0; // seconds

						// TODO: I might need to handle different pc performances later on in this.
						enemy.moveEnemy(dt);
						Point2D pos = enemy.getPosition(); // updated position
						enemyVisual.setTranslateX(pos.getX()); // update visuals
						enemyVisual.setTranslateY(pos.getY());
					}
					lastUpdate = now;
				}
			};
			timer.start(); // Start game loop
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
