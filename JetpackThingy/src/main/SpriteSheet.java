package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import engine.math.Vector2;

public class SpriteSheet {
	
	private BufferedImage base;
	private BufferedImage[][] sprites;
	private int spritesX, spritesY;
	private int spriteSizeX, spriteSizeY;
	
	public SpriteSheet(BufferedImage base, int spritesX, int spritesY) {
		this.base = base;
		this.generateInfos(spritesX, spritesY);
	}
	
	public SpriteSheet(String path, int spritesX, int spriteY) {
		try {
			 this.base = ImageIO.read(getClass().getResourceAsStream(path));
		} catch (IOException e) {
			System.err.println("Could not load the sprite with Path: " + path);
		}
		
		this.generateInfos(spritesX, spritesX);
	}
	
	private void generateInfos(int spritesX, int spritesY) {
		
		this.spritesX = spritesX;
		this.spritesY = spritesY;
		this.spriteSizeX = base.getWidth() 	/ this.spritesX;
		this.spriteSizeY = base.getHeight() / this.spritesY;
	
		sprites = new BufferedImage[this.spriteSizeX][this.spriteSizeY];
		
		pullSmallerSprites();		
	}
	
	private void pullSmallerSprites() {
		for (int y = 0; y < sprites.length; y++) {
			for (int x = 0; x < sprites[0].length; x++) {
				System.out.println(this.spriteSizeX * x + " " + this.spriteSizeY * y);
				sprites[y][x] = base.getSubimage(x * this.spriteSizeX, y * this.spriteSizeY, this.spriteSizeX, this.spriteSizeY);
			}
		}
	}
	
	public BufferedImage getSprite(int x, int y) {
		return this.sprites[x][y];
	}
}