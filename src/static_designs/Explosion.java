package static_designs;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

//150123002 Ali Faik Aksoy
public class Explosion extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane(); // Changed Group to Pane
        Scene scene = new Scene(root, 1920, 1080);

        // Create the initial red circle
        Circle circle = new Circle(scene.getWidth() / 2, scene.getHeight() / 2, 10, Color.RED);
        root.getChildren().add(circle);

        // Create the explosion animation
        Timeline explosionTimeline = createExplosionAnimation(circle, root);

        primaryStage.setTitle("Exploding Circle Animation");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Start the animation
        explosionTimeline.play();
    }

    private Timeline createExplosionAnimation(Circle circle, Pane root) { // Changed Group to Pane
        Timeline timeline = new Timeline();
        Random random = new Random();
        int numParticles = 30; // Number of explosion particles

        for (int i = 0; i < numParticles; i++) {
            Circle particle = new Circle(circle.getCenterX(), circle.getCenterY(), 5, Color.RED); // Smaller particles
            root.getChildren().add(particle);

            // Random direction and distance for the particle
            double angle = 2 * Math.PI * random.nextDouble();
            double distance = 80 + 50 * random.nextDouble(); // Random distance from center

            // Create animation keyframes for each particle
            KeyValue kvX = new KeyValue(particle.centerXProperty(), circle.getCenterX() + distance * Math.cos(angle));
            KeyValue kvY = new KeyValue(particle.centerYProperty(), circle.getCenterY() + distance * Math.sin(angle));
            KeyValue kvOpacity = new KeyValue(particle.opacityProperty(), 0); // Fade out

            KeyFrame kf = new KeyFrame(Duration.millis(1000), kvX, kvY, kvOpacity); // Shorter duration
            timeline.getKeyFrames().add(kf);
        }

        // Fade out the original circle
        FadeTransition fadeOut = new FadeTransition(Duration.millis(500), circle);
        fadeOut.setToValue(0);
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(500), new KeyValue(circle.opacityProperty(), 0)));

        return timeline;
    }

    public static void main(String[] args) {
        launch(args);
    }
}