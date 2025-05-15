import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TripleShotTowerUntext extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Kule tasarımını oluştur
        Group castleGroup = createCastle();

        // Kuleyi bir sahneye ekle
        Pane pane = new Pane();
        pane.getChildren().add(castleGroup);

        Scene scene = new Scene(pane, 1920, 1080);
        primaryStage.setTitle("Castle Design");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Kule tasarımını oluşturan metot
    public Group createCastle() {
        Group castleGroup = new Group();

        // Kule gövdesi
        Rectangle secBody = new Rectangle(650, 230, 200, 200);
        secBody.setFill(Color.GRAY);

        Rectangle secShadow = new Rectangle(850, 230, 100, 200);
        secShadow.setFill(Color.BLACK);

        Rectangle body = new Rectangle(650, 400, 200, 200);
        body.setFill(Color.GRAY);

        Rectangle shadow = new Rectangle(850, 400, 100, 200);
        shadow.setFill(Color.BLACK);

        // Kule üst kısmı
        Rectangle up1 = new Rectangle(650, 190, 40, 40);
        up1.setFill(Color.GRAY);
        Rectangle up2 = new Rectangle(730, 190, 40, 40);
        up2.setFill(Color.GRAY);
        Rectangle up3 = new Rectangle(810, 190, 40, 40);
        up3.setFill(Color.GRAY);
        Rectangle up4 = new Rectangle(890, 190, 40, 40);
        up4.setFill(Color.GRAY);

        // Gölge kısımları
        Rectangle shadow1 = new Rectangle(690, 190, 20, 40);
        shadow1.setFill(Color.BLACK);
        Rectangle shadow2 = new Rectangle(770, 190, 20, 40);
        shadow2.setFill(Color.BLACK);
        Rectangle shadow3 = new Rectangle(850, 190, 20, 40);
        shadow3.setFill(Color.BLACK);
        Rectangle shadow4 = new Rectangle(930, 190, 20, 40);
        shadow4.setFill(Color.BLACK);

        // Kapılar
        Rectangle door = new Rectangle(715, 500, 70, 100);
        door.setFill(Color.BLACK);
        Rectangle secDoor = new Rectangle(715, 300, 70, 100);
        secDoor.setFill(Color.BLACK);

        // Tüm parçaları gruba ekle
        Group castleFigureGroup = new Group(
            secBody, secShadow, body, up1, up2, up3, up4,
            shadow, shadow1, shadow2, shadow3, shadow4, door, secDoor
        );

        // VBox oluştur ve kale figürü ile yazıyı ekle
        VBox castleVBox = new VBox(5, castleFigureGroup);
        castleVBox.setAlignment(Pos.CENTER);

        // VBox'ı ana gruba ekle
        castleGroup.getChildren().add(castleVBox);

        return castleGroup;
    }

    public static void main(String[] args) {
        launch(args);
    }
}