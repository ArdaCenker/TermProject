package static_designs;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SingleShotTower extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Kale figürünü oluştur
        Group castleGroup = createCastle();

        castleGroup.setScaleX(0.5);
        castleGroup.setScaleY(0.5);

        // Kale figürünü bir sahneye ekle
        Pane pane = new Pane();
        pane.getChildren().add(castleGroup);

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("Castle Design");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Kale figürünü oluşturan metot
    public Group createCastle() {
        Group castleGroup = new Group();

        // Kale gövdesi
        Rectangle body = new Rectangle(650, 400, 200, 200);
        body.setFill(Color.GRAY);

        // Kale üst kısmı
        Rectangle up1 = new Rectangle(650, 360, 40, 40);
        up1.setFill(Color.GRAY);
        Rectangle up2 = new Rectangle(730, 360, 40, 40);
        up2.setFill(Color.GRAY);
        Rectangle up3 = new Rectangle(810, 360, 40, 40);
        up3.setFill(Color.GRAY);
        Rectangle up4 = new Rectangle(890, 360, 40, 40);
        up4.setFill(Color.GRAY);

        // Gölge kısımları
        Rectangle shadow1 = new Rectangle(690, 360, 20, 40);
        shadow1.setFill(Color.BLACK);
        Rectangle shadow2 = new Rectangle(770, 360, 20, 40);
        shadow2.setFill(Color.BLACK);
        Rectangle shadow3 = new Rectangle(850, 360, 20, 40);
        shadow3.setFill(Color.BLACK);
        Rectangle shadow4 = new Rectangle(930, 360, 20, 40);
        shadow4.setFill(Color.BLACK);

        Rectangle shadow = new Rectangle(850, 400, 100, 200);
        shadow.setFill(Color.BLACK);

        // Kale kapısı
        Rectangle door = new Rectangle(715, 500, 70, 100);
        door.setFill(Color.BLACK);

        // Kale parçalarını bir gruba ekle
        Group castleFigureGroup = new Group(body, up1, up2, up3, up4, shadow, shadow1, shadow2, shadow3, shadow4, door);

        // Yazıyı oluştur
        Label castleLabel = new Label("Single Shot Tower - 50$");
        castleLabel.setAlignment(Pos.CENTER);
        castleLabel.setStyle("-fx-font-size: 80px;"); // Yazı boyutunu ayarla

        // VBox oluştur ve kale figürü ile yazıyı ekle
        VBox castleVBox = new VBox(20, castleFigureGroup, castleLabel);
        castleVBox.setAlignment(Pos.CENTER);

        // VBox'ı ana gruba ekle
        castleGroup.getChildren().add(castleVBox);

        return castleGroup;
    }

    public static void main(String[] args) {
        launch(args);
    }
}