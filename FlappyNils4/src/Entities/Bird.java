package Entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import Graphics.ImageLoader;
import Util.CollisionDetection;
import game1.Game;
import game1.Handler;
import input.KeyManager;

public class Bird {

	private Handler handler;
	
	private float x, y;
	private int width = 40, height = 30;
	private float vy;
	private float ay;
	public static int score = 0;
	static Font pixelfont;
	
	private BufferedImage bird = ImageLoader.loadImage("/RedtardBird.png");
	private BufferedImage birdD = ImageLoader.loadImage("/RedtardBirdDEAD.png");

	public static boolean dead = false;

	public Bird(Handler handler) {
		this.handler = handler;
		x = 100;
		y = 600;
		vy = -15;
		ay = 0.35f;
	}

	public void tick() {
		vy += ay;
		if(y + width > handler.getGame().getDisplay().getCanvas().getHeight()) {
			y = handler.getGame().getDisplay().getCanvas().getHeight() - height;
			vy = 0;
		}
		y += vy;
		
		if (!dead) {
			if (KeyManager.pressed) {
				vy = -10;
			}
		}

	}

	public void render(Graphics g) {

		// Graphics2D g2d = (Graphics2D) g;
		// g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		// RenderingHints.VALUE_ANTIALIAS_ON);
		//g.setColor(Color.yellow);
		//g.fillRect((int) x, (int) y, width, height);
		
		
		if(dead == false) {
			g.drawImage(bird,(int) x,(int) y, width, height, null);
		} else {
			g.drawImage(birdD,(int) x,(int) y, width, height, null);
		}

		try {
			pixelfont = Font.createFont(Font.TRUETYPE_FONT, new File("coders_crux.ttf")).deriveFont(125f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("coders_crux.ttf")));
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();

		}

		g.setColor(Color.BLACK);
		g.setFont(pixelfont);
		
		if(dead == false) {
			g.drawString("" + score, Game.width / 2 - 20, 60);
		}
		

	};
	
	public void kill() {
		dead = true;
	}

	public void increaseScore(int amount) {
		score += amount;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean isDead() {
		return dead;
	}

}
