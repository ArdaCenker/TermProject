package static_designs;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LaserTowerUntext extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Kale figürünü oluştur
        Group castleGroup = createCastle();

        castleGroup.setScaleX(0.5);
        castleGroup.setScaleY(0.5);

        // Kale figürünü bir sahneye ekle
        Pane pane = new Pane();
        pane.getChildren().add(castleGroup);

        Scene scene = new Scene(pane, 1920, 1080);
        primaryStage.setTitle("Laser Tower Design");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Kale figürünü oluşturan metot
    public Group createCastle() {
        Group castleGroup = new Group();

        // Kale gövdesi
        Rectangle secBody = new Rectangle(670, 230, 170, 170);
        secBody.setFill(Color.GRAY);
        secBody.setStroke(Color.BLACK);

        // Kale üst kısmı
        Rectangle secUp1 = new Rectangle(670, 200, 30, 30);
        secUp1.setFill(Color.GRAY);
        secUp1.setStroke(Color.BLACK);
        Rectangle secUp2 = new Rectangle(735, 200, 30, 30);
        secUp2.setFill(Color.GRAY);
        secUp2.setStroke(Color.BLACK);
        Rectangle secUp3 = new Rectangle(800, 200, 30, 30);
        secUp3.setFill(Color.GRAY);
        secUp3.setStroke(Color.BLACK);
        Rectangle secUp4 = new Rectangle(850, 200, 30, 30);
        secUp4.setFill(Color.GRAY);
        secUp4.setStroke(Color.BLACK);

        // Gölge kısımları
        Rectangle secShadow1 = new Rectangle(700, 200, 15, 30);
        secShadow1.setFill(Color.BLACK);
        Rectangle secShadow2 = new Rectangle(765, 200, 15, 30);
        secShadow2.setFill(Color.BLACK);
        Rectangle secShadow3 = new Rectangle(830, 200, 15, 30);
        secShadow3.setFill(Color.BLACK);
        Rectangle secShadow4 = new Rectangle(880, 200, 15, 30);
        secShadow4.setFill(Color.BLACK);

        Rectangle secShadow = new Rectangle(830, 230, 65, 170);
        secShadow.setFill(Color.BLACK);

        // Ana gövde
        Rectangle body = new Rectangle(650, 400, 200, 200);
        body.setFill(Color.GRAY);
        body.setStroke(Color.BLACK);
        Rectangle shadow = new Rectangle(850, 400, 100, 200);
        shadow.setFill(Color.BLACK);

        // Kale üst kısmı
        Rectangle up1 = new Rectangle(650, 360, 40, 40);
        up1.setFill(Color.GRAY);
        up1.setStroke(Color.BLACK);
        Rectangle up2 = new Rectangle(730, 360, 40, 40);
        up2.setFill(Color.GRAY);
        up2.setStroke(Color.BLACK);
        Rectangle up3 = new Rectangle(810, 360, 40, 40);
        up3.setFill(Color.GRAY);
        up3.setStroke(Color.BLACK);
        Rectangle up4 = new Rectangle(890, 360, 40, 40);
        up4.setFill(Color.GRAY);
        up4.setStroke(Color.BLACK);

        // Gölge kısımları
        Rectangle shadow1 = new Rectangle(690, 360, 20, 40);
        shadow1.setFill(Color.BLACK);
        Rectangle shadow2 = new Rectangle(770, 360, 20, 40);
        shadow2.setFill(Color.BLACK);
        Rectangle shadow3 = new Rectangle(850, 360, 20, 40);
        shadow3.setFill(Color.BLACK);
        Rectangle shadow4 = new Rectangle(930, 360, 20, 40);
        shadow4.setFill(Color.BLACK);

        // Kale kapısı
        Rectangle door = new Rectangle(715, 500, 70, 100);
        door.setFill(Color.BLACK);

        // Tüm parçaları gruba ekle
        Group castleFigureGroup = new Group(
            secBody, secUp1, secUp2, secUp3, secUp4,
            secShadow1, secShadow2, secShadow3, secShadow4, secShadow,
            body, up1, up2, up3, up4, shadow, shadow1, shadow2, shadow3, shadow4, door
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