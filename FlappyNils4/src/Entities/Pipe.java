package Entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Graphics.ImageLoader;

import game1.Handler;

public class Pipe {

	private Handler handler;

	private int x, y;
	private int vx = -2;

	private boolean scored = false;

	public final static int width = 50;
	public final static int holeHeight = 200;

	private BufferedImage texture_top = ImageLoader.loadImage("/pipe_top.png");
	private BufferedImage texture_bottom = ImageLoader.loadImage("/pipe_bottom.png");

	public Pipe(int y, Handler handler) {
		this.handler = handler;
		this.y = y;
		x = 800;
	}

	public void tick() {
		x += vx;

		if (x < handler.getGameState().getBird().getX() && scored == false) {
			handler.getGameState().getBird().increaseScore(1);
			scored = true;
		}
	}

	public void render(Graphics g) {
		g.drawImage(texture_top, x - 5, y - 800, null);
		g.drawImage(texture_bottom, x - 5, y + holeHeight, null);
		
		/*
		 * g.setColor(Color.green); g.fillRect(x, 0, width, y); g.fillRect(x, y +
		 * holeHeight, width, Game.height - (y + holeHeight));
		 */
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHoleHeight() {
		return holeHeight;
	}
}
