package Graphics;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display {
	
	private JFrame frame;
	private Canvas canvas;
	
	public Display(int width, int height, String title) {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		canvas = new Canvas();
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		
		frame.add(canvas);
	}

	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return frame;
	}

}
