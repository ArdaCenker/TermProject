package level;

import java.util.ArrayList;

import javafx.geometry.Point2D;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
        grid.setGridLinesVisible(true);
        grid.setHgap(0);
        grid.setVgap(0);
        grid.setPrefSize(handler.getWidth() * BOX_SIZE, handler.getHeight() * BOX_SIZE);

        //Ground cells
        for (int row = 0; row < handler.getHeight(); row++) {
            for (int col = 0; col < handler.getWidth(); col++) {
                Rectangle cell = new Rectangle(BOX_SIZE, BOX_SIZE);
                cell.setFill(Color.LIGHTBLUE);
                cell.setStroke(Color.WHITE);
                grid.add(cell, col, row);
            }
        }

        //Path cells
        for (Point2D p : handler.getPathGrids()) {
            int col = (int) p.getX();
            int row = (int) p.getY();
            Rectangle pathCell = new Rectangle(BOX_SIZE, BOX_SIZE);
            pathCell.setFill(Color.DARKGRAY);
            grid.add(pathCell, col, row);
        }

        return grid;
	}
	
}