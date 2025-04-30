package level;

import javafx.scene.layout.GridPane;

public class Level {
	private int width;
	private int height;
	private int[][] path;
	
	public Level(int width, int height, int[][] path) {
		this.width = width;
		this.height = height;
		this.path = path;
	}

	public int[][] getPath() {
		return path;
	}

	public void setPath(int[][] path) {
		this.path = path;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public void drawLevel() {
		
	}
	
}
