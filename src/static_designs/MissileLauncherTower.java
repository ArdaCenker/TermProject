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

//150123002 Ali Faik Aksoy
public class MissileLauncherTower extends Application {
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
        Rectangle leftSecBody = new Rectangle(200, 230, 200, 200);
        leftSecBody.setFill(Color.GRAY);
        Rectangle rightSecBody = new Rectangle(650, 230, 200, 200);
        rightSecBody.setFill(Color.GRAY);

        Rectangle leftSecShadow = new Rectangle(400, 230, 100, 200);
        leftSecShadow.setFill(Color.BLACK);
        Rectangle rightSecShadow = new Rectangle(850, 230, 100, 200);
        rightSecShadow.setFill(Color.BLACK);

        Rectangle leftBody = new Rectangle(200, 400, 200, 200);
        leftBody.setFill(Color.GRAY);
        Rectangle rightBody = new Rectangle(650, 400, 200, 200);
        rightBody.setFill(Color.GRAY);

        Rectangle midBody = new Rectangle(400, 350, 250, 250);
        midBody.setFill(Color.GRAY);
        Rectangle rightShadow = new Rectangle(850, 400, 100, 200);
        rightShadow.setFill(Color.BLACK);

        // Kule üst kısmı
        Rectangle leftUp1 = new Rectangle(200, 190, 40, 40);
        leftUp1.setFill(Color.GRAY);
        Rectangle leftUp2 = new Rectangle(280, 190, 40, 40);
        leftUp2.setFill(Color.GRAY);
        Rectangle leftUp3 = new Rectangle(360, 190, 40, 40);
        leftUp3.setFill(Color.GRAY);
        Rectangle leftUp4 = new Rectangle(440, 190, 40, 40);
        leftUp4.setFill(Color.GRAY);
        Rectangle rightUp1 = new Rectangle(650, 190, 40, 40);
        rightUp1.setFill(Color.GRAY);
        Rectangle rightUp2 = new Rectangle(730, 190, 40, 40);
        rightUp2.setFill(Color.GRAY);
        Rectangle rightUp3 = new Rectangle(810, 190, 40, 40);
        rightUp3.setFill(Color.GRAY);
        Rectangle rightUp4 = new Rectangle(890, 190, 40, 40);
        rightUp4.setFill(Color.GRAY);

        // Gölge kısımları
        Rectangle leftShadow1 = new Rectangle(240, 190, 20, 40);
        leftShadow1.setFill(Color.BLACK);
        Rectangle leftShadow2 = new Rectangle(320, 190, 20, 40);
        leftShadow2.setFill(Color.BLACK);
        Rectangle leftShadow3 = new Rectangle(400, 190, 20, 40);
        leftShadow3.setFill(Color.BLACK);
        Rectangle leftShadow4 = new Rectangle(480, 190, 20, 40);
        leftShadow4.setFill(Color.BLACK);
        Rectangle rightShadow1 = new Rectangle(690, 190, 20, 40);
        rightShadow1.setFill(Color.BLACK);
        Rectangle rightShadow2 = new Rectangle(770, 190, 20, 40);
        rightShadow2.setFill(Color.BLACK);
        Rectangle rightShadow3 = new Rectangle(850, 190, 20, 40);
        rightShadow3.setFill(Color.BLACK);
        Rectangle rightShadow4 = new Rectangle(930, 190, 20, 40);
        rightShadow4.setFill(Color.BLACK);

        // Kapılar
        Rectangle leftDoor = new Rectangle(265, 500, 70, 100);
        leftDoor.setFill(Color.BLACK);
        Rectangle rightDoor = new Rectangle(715, 500, 70, 100);
        rightDoor.setFill(Color.BLACK);
        Rectangle leftSecDoor = new Rectangle(265, 300, 70, 100);
        leftSecDoor.setFill(Color.BLACK);
        Rectangle rightSecDoor = new Rectangle(715, 300, 70, 100);
        rightSecDoor.setFill(Color.BLACK);

        Rectangle midDoor = new Rectangle(490, 450, 100, 150);
        midDoor.setFill(Color.BLACK);

        // Tüm parçaları gruba ekle
        Group castleFigureGroup = new Group(
            leftBody, rightBody, leftSecBody, rightSecBody, leftSecShadow, rightSecShadow,
            leftUp1, leftUp2, leftUp3, leftUp4, rightUp1, rightUp2, rightUp3, rightUp4,
            midBody, rightShadow, rightShadow1, rightShadow2, rightShadow3, rightShadow4,
            leftShadow1, leftShadow2, leftShadow3, leftShadow4,
            leftDoor, rightDoor, leftSecDoor, rightSecDoor, midDoor
        );

        Label castleLabel = new Label("Missile Launcher Tower - 200$");
        castleLabel.setAlignment(Pos.CENTER);
        castleLabel.setStyle("-fx-font-size: 80px;"); // Yazı boyutunu ayarla

        // VBox oluştur ve kale figürü ile yazıyı ekle
        VBox castleVBox = new VBox(5, castleFigureGroup, castleLabel);
        castleVBox.setAlignment(Pos.CENTER);

        // VBox'ı ana gruba ekle
        castleGroup.getChildren().add(castleVBox);

        return castleGroup;

    }

    public static void main(String[] args) {
        launch(args);
    }
}