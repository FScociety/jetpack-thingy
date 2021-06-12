package world.coins;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import javax.imageio.ImageIO;

import engine.io.Logger;

public class CoinPattern {
	
	private int[][] pattern;
	private int posCount = 0;
	private int randomPosY = 0;
 	
	public CoinPattern(int number) {
		String filePath = "/coins/patterns/pattern-" + number + ".txt";
		
		InputStream fileStream = CoinPattern.class.getResourceAsStream(filePath);
		
		Scanner fileScanner = new Scanner(fileStream);
		
		ArrayList<int[]> elements = new ArrayList<>();
		
		while(fileScanner.hasNextLine()) {
			char[] data = fileScanner.nextLine().toCharArray();
			
			int[] lineConvert = new int[data.length];
			for (int charI = 0; charI < data.length; charI++) {
				lineConvert[charI] = data[charI] == '0' ? 0 : 1;
			}
			
			elements.add(lineConvert);
 		}
		
		
		
		//SAVING
		int width = elements.get(0).length;
		int height = elements.size();
	
		this.pattern = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				this.pattern[x][y] = elements.get(y)[x];
			}
		}
	}
	
	private void refresh() {
		this.posCount = 0;
	}
	
	public int[] getLine() {
		this.posCount++;
		if (this.posCount-1 < this.pattern.length) {
			int[] stripe = new int[CoinData.coinSize];
			
			for (int i = 0; i < this.pattern[0].length; i++) {
				stripe[i+randomPosY] = this.pattern[this.posCount-1][i];
			}
			
			return stripe;
			//return pattern[this.posCount-1];
		} else {
			this.refresh();
			CoinPattern newPattern = CoinController.cc.newPattern();
			if (newPattern != null) {
				return newPattern.getLine();
			} else {
				return null;
			}
		}
	}
	
	public void newYOffset() {
		randomPosY = (int) Math.round(Math.random()*(CoinData.coinSize-this.pattern[0].length));
	}
}