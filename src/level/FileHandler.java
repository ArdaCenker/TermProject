package level;

import java.io.BufferedReader;
import java.io.File;
import java.util.Scanner;

public class FileHandler {
	
	private String filePath = "\\datas\\";
	
	public FileHandler(String filePath) {
		this.filePath = filePath;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public void handleFile(String fileName){
		
		File file = new File(filePath + fileName);
		
	}
}
