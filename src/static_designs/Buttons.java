package static_designs;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Group;

public class Buttons extends Application {
    @Override
    public void start(Stage primaryStage) {
        // SingleShotTower sınıfından kale figürünü al
        SingleShotTower singleShotTower = new SingleShotTower();
        Group singleShotCastleGroup = singleShotTower.createCastle(); // Single Shot Tower figürünü oluştur

        // Kale figürünü bir StackPane içine sar ve boyutlarını sabitle
        StackPane singleShotPane = new StackPane(singleShotCastleGroup);
        singleShotPane.setMinSize(150, 100); // Minimum boyut
        singleShotPane.setMaxSize(150, 100); // Maksimum boyut
        singleShotPane.setAlignment(Pos.CENTER); // İçeriği ortala
        singleShotCastleGroup.setScaleX(0.15); // Genişliği %20'ye düşür
        singleShotCastleGroup.setScaleY(0.15); // Yüksekliği %20'ye düşür

        // tower1 butonunu oluştur ve sarılmış figürü ekle
        Button tower1 = new Button();
        tower1.setGraphic(singleShotPane); // Pane'i butona ekle
        tower1.setPrefSize(150, 100); // Buton boyutunu ayarla
        tower1.setStyle("-fx-background-color:rgb(89, 195, 207);"); // Buton arka plan rengi

        // LaserTower sınıfından kale figürünü al
        LaserTower laserTower = new LaserTower();
        Group laserCastleGroup = laserTower.createCastle(); // Laser Tower figürünü oluştur

        // Kale figürünü bir StackPane içine sar ve boyutlarını sabitle
        StackPane laserPane = new StackPane(laserCastleGroup);
        laserPane.setMinSize(150, 100); // Minimum boyut
        laserPane.setMaxSize(150, 100); // Maksimum boyut
        laserPane.setAlignment(Pos.CENTER); // İçeriği ortala
        laserCastleGroup.setScaleX(0.15); // Genişliği %20'ye düşür
        laserCastleGroup.setScaleY(0.15); // Yüksekliği %20'ye düşür

        // tower2 butonunu oluştur ve sarılmış figürü ekle
        Button tower2 = new Button();
        tower2.setGraphic(laserPane); // Pane'i butona ekle
        tower2.setPrefSize(150, 100); // Buton boyutunu ayarla
        tower2.setStyle("-fx-background-color:rgb(89, 195, 207);"); // Buton arka plan rengi

        // TripleShotTower sınıfından kale figürünü al
        TripleShotTower tripleShotTower = new TripleShotTower();
        Group tripleShotCastleGroup = tripleShotTower.createCastle(); // Triple Shot Tower figürünü oluştur

        // Kale figürünü bir StackPane içine sar ve boyutlarını sabitle
        StackPane tripleShotPane = new StackPane(tripleShotCastleGroup);
        tripleShotPane.setMinSize(150, 100); // Minimum boyut
        tripleShotPane.setMaxSize(150, 100); // Maksimum boyut
        tripleShotPane.setAlignment(Pos.CENTER); // İçeriği ortala
        tripleShotCastleGroup.setScaleX(0.15); // Genişliği %20'ye düşür
        tripleShotCastleGroup.setScaleY(0.15); // Yüksekliği %20'ye düşür

        // tower3 butonunu oluştur ve sarılmış figürü ekle
        Button tower3 = new Button();
        tower3.setGraphic(tripleShotPane); // Pane'i butona ekle
        tower3.setPrefSize(150, 100); // Buton boyutunu ayarla
        tower3.setStyle("-fx-background-color:rgb(89, 195, 207);"); // Buton arka plan rengi

        // MisilleLauncherTower sınıfından kale figürünü al
        MissileLauncherTower misilleLauncherTower = new MissileLauncherTower();
        Group misilleLauncherCastleGroup = misilleLauncherTower.createCastle(); // Missile Launcher Tower figürünü oluştur

        // Kale figürünü bir StackPane içine sar ve boyutlarını sabitle
        StackPane misilleLauncherPane = new StackPane(misilleLauncherCastleGroup);
        misilleLauncherPane.setMinSize(150, 100); // Minimum boyut
        misilleLauncherPane.setMaxSize(150, 100); // Maksimum boyut
        misilleLauncherPane.setAlignment(Pos.CENTER); // İçeriği ortala
        misilleLauncherCastleGroup.setScaleX(0.15); // Genişliği %20'ye düşür
        misilleLauncherCastleGroup.setScaleY(0.15); // Yüksekliği %20'ye düşür

        // tower4 butonunu oluştur ve sarılmış figürü ekle
        Button tower4 = new Button();
        tower4.setGraphic(misilleLauncherPane); // Pane'i butona ekle
        tower4.setPrefSize(150, 100); // Buton boyutunu ayarla
        tower4.setStyle("-fx-background-color:rgb(89, 195, 207);"); // Buton arka plan rengi

        // VBox düzeni
        VBox towers = new VBox(10); // 10 piksel aralık
        towers.setAlignment(Pos.CENTER_RIGHT); // Butonları sağ tarafa hizala
        towers.getChildren().addAll(tower1, tower2, tower3, tower4);
        towers.setStyle("-fx-background-color: lightblue;");

        // Sahneyi oluştur ve göster
        Scene scene = new Scene(towers, 1920, 1080);
        primaryStage.setTitle("GAME");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}