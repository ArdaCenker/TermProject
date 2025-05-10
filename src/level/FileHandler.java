package level;

import javafx.geometry.Point2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
	// data fields
	private String filePath = "src/level/datas/";
	private String fileName;
	private int width;
	private int height;
	private ArrayList<Point2D> pathGrids = new ArrayList<Point2D>();
	private ArrayList<WaveData> waveData = new ArrayList<WaveData>();

	// Constructor for FileHandler object
	public FileHandler() {
		
	}
	
	public FileHandler(String fileName) {
		this.setFileName(fileName);
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	// getter methods for data
	public int getWidth() {return this.width;}
	public int getHeight() {return this.height;}
	public ArrayList<Point2D> getPathGrids() {return this.pathGrids;}
	public ArrayList<WaveData> getWaveData() {return this.waveData;}

	// will be called only when new level is initialized
	public void handleFile(String fileName){
		// Instantiates file for given path
		File file = new File(filePath + fileName);
		// tries to scan the file if it exists
		try {
			Scanner input = new Scanner(file);

			// while loop continues until no more line is left
			while (input.hasNextLine()) {
				String line = input.nextLine().strip();

				// if line is empty skips to the next line
				if (line.isEmpty()) continue;
				// if line keeps width
				if (line.startsWith("WIDTH:"))
				{
					this.width = Integer.parseInt(line.substring(6).strip());
				}
				// if line keeps height
				else if (line.startsWith("HEIGHT:"))
				{
					this.height = Integer.parseInt(line.substring(7));
				}
				// if line is aşağıdaki, collects each line's data to waveData arraylist
				else if (line.startsWith("WAVE_DATA:"))
				{
					while (input.hasNextLine()) {
						line = input.nextLine().strip();

						String[] tokens = line.split(",");

						if (tokens.length != 3) {
							throw new RuntimeException("Malformed wave data: " + line);
						}

						int enemyCount = Integer.parseInt(tokens[0].strip());
						double spawnInterval = Double.parseDouble(tokens[1].strip());
						int delay = Integer.parseInt(tokens[2].strip());

						WaveData wave = new WaveData(enemyCount, spawnInterval, delay);
						this.waveData.add(wave);
					}
				}
				// else, line holds locations of path's grids, appends to pathGrids list
				else
				{
					String[] parts = line.split(",");
					if (parts.length != 2) {
						throw new RuntimeException("Invalid path line: " + line);
					}

					int row = Integer.parseInt(parts[0].strip());
					int col = Integer.parseInt(parts[1].strip());

					Point2D gridLocation = new Point2D(col, row);  // x = col, y = row
					this.pathGrids.add(gridLocation);
				}
			}
			input.close();
		}
		catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
	}
}
