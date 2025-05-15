import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Level4 extends Application {
    private static final int TILE_SIZE = 50; 
    private static final int GRID_SIZE = 15; 

    @Override
    public void start(Stage primaryStage) {
        Group group = new Group(); 
        Rectangle[][] tiles = new Rectangle[GRID_SIZE][GRID_SIZE]; 

        // Haritayı oluştur ve başlangıçta küçültülmüş ve görünmez yap
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                Rectangle tile = new Rectangle(TILE_SIZE, TILE_SIZE);
                tile.setFill(Color.LIGHTBLUE); 
                tile.setStroke(Color.WHITE); 
                tile.setOpacity(0); // Başlangıçta görünmez
                tile.setScaleX(0.1); // Başlangıçta küçültülmüş
                tile.setScaleY(0.1); // Başlangıçta küçültülmüş
                tiles[row][col] = tile;

                tile.setX(col * TILE_SIZE); 
                tile.setY(row * TILE_SIZE); 
                group.getChildren().add(tile);
            }
        }

        // Özel koordinatları beyaz yap
        int[][] specialCoordinates = {
            {2, 0}, {2, 1}, {2, 2}, {2, 3}, {3, 3}, {4, 3}, {5, 3}, {6, 3}, {7, 3}, {8, 3},
            {8, 4}, {8, 5}, {8, 6}, {7, 6}, {6, 6}, {5, 6}, {4, 6}, {4, 7}, {4, 8}, {4, 9},
            {5, 9}, {6, 9}, {7, 9}, {8, 9}, {9, 9}, {10, 9}, {10, 8}, {10, 7}, {10, 6}, {11, 6},
            {12, 6}, {12, 7}, {12, 8}, {12, 9}, {12, 10}, {12, 11}, {12, 12}, {11, 12}, {10, 12},
            {9, 12}, {8, 12}, {8, 13}, {8, 14}
        };

        for (int[] coord : specialCoordinates) {
            int row = coord[0];
            int col = coord[1];
            tiles[row][col].setFill(Color.WHITESMOKE); 
        }

        StackPane root = new StackPane(group);
        Scene scene = new Scene(root, GRID_SIZE * TILE_SIZE, GRID_SIZE * TILE_SIZE);

        // Animasyonu oluştur
        Timeline timeline = new Timeline();
        Duration tileDelay = Duration.millis(50); // Her bir tile için gecikme
        Duration rowDelay = Duration.millis(200); // Her satır için ek gecikme

        // [0][0] konumunu görünür yap
        tiles[0][0].setOpacity(1); // Görünür yap
        tiles[0][0].setScaleX(1);  // Normal boyut
        tiles[0][0].setScaleY(1);  // Normal boyut
        tiles[0][0].setFill(Color.LIGHTBLUE); // Varsayılan renk

        for (int row = 0; row < GRID_SIZE; row++) {
            final int currentRow = row;
            for (int col = 0; col < GRID_SIZE; col++) {
                final int currentCol = col;

                // Opaklık animasyonu
                KeyFrame opacityKeyFrame = new KeyFrame(
                    rowDelay.multiply(currentRow).add(tileDelay.multiply(col)),
                    new KeyValue(tiles[currentRow][currentCol].opacityProperty(), 1)
                );

                // Ölçek animasyonu (küçükten büyüğe)
                KeyFrame scaleKeyFrame = new KeyFrame(
                    rowDelay.multiply(currentRow).add(tileDelay.multiply(col)),
                    new KeyValue(tiles[currentRow][currentCol].scaleXProperty(), 1),
                    new KeyValue(tiles[currentRow][currentCol].scaleYProperty(), 1)
                );

                timeline.getKeyFrames().addAll(opacityKeyFrame, scaleKeyFrame);
            }
        }

        // Animasyonu başlat
        primaryStage.setTitle("Level 4 - Animasyonlu Oyun Haritası");
        primaryStage.setScene(scene);
        primaryStage.show();
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}