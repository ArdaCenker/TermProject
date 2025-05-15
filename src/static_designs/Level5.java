package static_designs;

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

public class Level5 extends Application {
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
                tile.setOpacity(0.1); // Başlangıçta görünmez
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
            {0, 3}, {1, 3}, {2, 3}, {3, 3}, {3, 2}, {3, 1}, {4, 1}, {5, 1}, {6, 1}, {6, 2},
            {6, 3}, {6, 4}, {6, 5}, {6, 6}, {7, 6}, {8, 6}, {8, 5}, {8, 4}, {9, 4}, {10, 4},
            {10, 5}, {10, 6}, {10, 7}, {10, 8}, {10, 9}, {9, 9}, {8, 9}, {7, 9}, {6, 9}, {5, 9},
            {4, 9}, {3, 9}, {3, 10}, {3, 11}, {3, 12}, {4, 12}, {5, 12}, {6, 12}, {7, 12},
            {8, 12}, {9, 12}, {10, 12}, {11, 12}, {12, 12}, {12, 13}, {12, 14}
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
        primaryStage.setTitle("Level 5 - Animasyonlu Oyun Haritası");
        primaryStage.setScene(scene);
        primaryStage.show();
        timeline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}