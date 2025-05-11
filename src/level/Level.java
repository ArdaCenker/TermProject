package level;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Level{
	private static final int BOX_SIZE = 50;
	private int width;
	private int height;
	private ArrayList<Point2D> path;
	private FileHandler handler;
	
	public Level(String fileName) {
		this.handler = new FileHandler();
		handler.handleFile(fileName);
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public ArrayList<Point2D> getPath() {
		return path;
	}
	public void setPath(ArrayList<Point2D> path) {
		this.path = path;
	}
	
	public GridPane drawLevel() {
		GridPane grid = new GridPane();
        grid.setGridLinesVisible(false);
        grid.setHgap(0);
        grid.setVgap(0);
        grid.setPrefSize(handler.getWidth() * BOX_SIZE, handler.getHeight() * BOX_SIZE);
        
        Timeline timeline = new Timeline();
        Duration baseDelay = Duration.millis(350);
        
        //Ground cells
        for (int row = 0; row < handler.getHeight(); row++) {
            for (int col = 0; col < handler.getWidth(); col++) {
                Rectangle cell = new Rectangle(BOX_SIZE, BOX_SIZE);
                cell.setFill(Color.LIGHTBLUE);
                cell.setStroke(Color.WHITE);
                cell.setScaleX(0);
                cell.setScaleY(0);
                
                grid.add(cell, col, row);
                
                KeyValue kvX = new KeyValue(cell.scaleXProperty(), 1);
                KeyValue kvY = new KeyValue(cell.scaleYProperty(), 1);
                //row 0 olunca 0 ile çarpıldğı için scale sıfırda kalıyodu o yüzden 1 ekledim
                Duration delay = baseDelay.multiply(row + 1);

                KeyFrame kf = new KeyFrame(delay, kvX, kvY);
                timeline.getKeyFrames().add(kf);
            }
        }
        
        
        //Path cells
        for (Point2D p : handler.getPathGrids()) {
            int col = (int) p.getX();
            int row = (int) p.getY();
            Rectangle pathCell = new Rectangle(BOX_SIZE, BOX_SIZE);
            pathCell.setFill(Color.DARKGRAY);
            pathCell.setScaleX(0);
            pathCell.setScaleY(0);
            
            grid.add(pathCell, col, row);
            
            KeyValue kvX = new KeyValue(pathCell.scaleXProperty(), 1);
            KeyValue kvY = new KeyValue(pathCell.scaleYProperty(), 1);
            //row 0 olunca 0 ile çarpıldğı için scale sıfırda kalıyodu o yüzden 1 ekledim
            Duration delay = baseDelay.multiply(row + 1);
            
            KeyFrame kf = new KeyFrame(delay, kvX, kvY);
            timeline.getKeyFrames().add(kf);
        }
        
       

        //OYUN SAYFASI DÜZENİNDE KULLANILACAK 
//        grid.layoutXProperty().bind();
//        grid.layoutYProperty().bind();
        
        timeline.play();
        grid.setAlignment(Pos.CENTER);
        return grid;
	}
	
}