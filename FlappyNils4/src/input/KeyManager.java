package input;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class KeyManager implements KeyListener, MouseListener {

	public static boolean pressed = false;
	private boolean isPressed = false;
	public static int xMouse, yMouse;

	public KeyManager() {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (!isPressed) {
			pressed = true;
			isPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		isPressed = false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (!isPressed) {
			pressed = true;
			isPressed = true;
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		isPressed = false;
		
		PointerInfo a = MouseInfo.getPointerInfo();
		Point b = a.getLocation();

		xMouse = (int) b.getX();
		yMouse = (int) b.getY();
		System.out.println(xMouse + " " + yMouse);

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	public void tick() {
		pressed = false;
	}

}