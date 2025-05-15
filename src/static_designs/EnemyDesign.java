package static_designs;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class EnemyDesign extends Application {

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        // Üçgen oluştur
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(
                100.0, 50.0,
                80.0, 150.0,
                130.0, 150.0
        );
        triangle.setFill(Color.RED);
        triangle.setStroke(Color.BLACK);

        // Yuvarlak oluştur
        Circle circle = new Circle(102, 70, 20);
        circle.setFill(Color.RED);
        circle.setStroke(Color.BLACK);

        // Progress Bar oluştur
        ProgressBar progressBar = new ProgressBar(0.5); // Başlangıç değeri 0.5 (yani %50 dolu)
        progressBar.setLayoutX(77.5); // X konumunu ayarla
        progressBar.setLayoutY(27); // Y konumunu ayarla
        progressBar.setPrefWidth(50); // Genişliği ayarla
        progressBar.setStyle("-fx-accent: red;-fx-box-border: transparent; -fx-background: black"); // Progress bar rengini yeşil yap

        // Tasarlanan cisimleri grupla
        Group enemyGroup = new Group(triangle, circle, progressBar);

        root.getChildren().add(enemyGroup);

        Scene scene = new Scene(root, 1920, 1080);
        primaryStage.setTitle("Enemy Designs");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}