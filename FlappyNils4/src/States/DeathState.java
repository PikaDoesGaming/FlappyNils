package States;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.RepaintManager;

import Entities.Bird;
import game1.Handler;

public class DeathState extends State {

	Font Serif = new Font("Serif", Font.BOLD, 60);
	Font Serif2 = new Font("Serif", Font.BOLD, 40);

	public DeathState(Handler handler) {
		super(handler);

		if (true) {

		}

	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawString("Game Over", 190, 185);
		g.setColor(Color.CYAN);
		g.fillRect(190, 250, 430, 400);

		g.setFont(Serif);
		g.setColor(Color.black);
		g.drawString("Your Score: " + Entities.Bird.score, 220, 320);

		g.setFont(Serif2);
		g.setColor(Color.ORANGE);
		g.fillRect(300, 520, 205, 60);
		g.setColor(Color.black);
		g.drawString("Try Again?", 305, 560);

	}
}
