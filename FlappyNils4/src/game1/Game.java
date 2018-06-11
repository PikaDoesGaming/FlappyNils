	package game1;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import Graphics.Display;
import States.DeathState;
import States.GameState;
import States.State;
import input.KeyManager;

public class Game implements Runnable {

	private boolean running = false;
	public static int width = 800, height = 800;

	private KeyManager keyManager;

	private State gameState;
	private State deathState;
	private Handler handler;

	private Thread thread;
	private Display display;
	private Graphics g;
	private BufferStrategy bs;

	public Game() {
		setup();
	}

	public void setup() {
		display = new Display(width, height, "Game");
		display.getCanvas().createBufferStrategy(3);

		keyManager = new KeyManager();

		display.getCanvas().addKeyListener(keyManager);
		display.getCanvas().addMouseListener(keyManager);
		display.getCanvas().requestFocus();

		handler = new Handler(this);
		handler.setKeyManager(keyManager);

		deathState = new DeathState(handler);
		gameState = new GameState(handler);
		handler.setGameState(gameState);
		State.setState(gameState);
	}

	public synchronized void start() {
		if (running)
			return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	private synchronized void stop() {
		if (!running)
			return;

		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}

	@Override
	public void run() {
		int fps = 20;
		float timePerTick = 1000000000 / fps;
		long timeLastTick = System.nanoTime();
		long timeNow;
		double deltaTime = 0;

		long timeTicks = System.currentTimeMillis();
		int ticks = 0;

		running = true;
		while (running) {
			timeNow = System.nanoTime();
			deltaTime += (timeNow - timeLastTick) / timePerTick;
			timeLastTick = timeNow;

			while (deltaTime >= 1) {
				tick();
				render();

				deltaTime--;
				ticks++;
			}

			if (System.currentTimeMillis() - timeTicks >= 1000) {
				System.out.println("FPS: " + ticks);
				ticks = 0;
				timeTicks = System.currentTimeMillis();

			}
		}
	}

	public void tick() {
		State.getCurrentState().tick();
	}

	public void render() {
		bs = display.getCanvas().getBufferStrategy();
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		State.getCurrentState().render(g);
		
		bs.show();
		g.dispose();
	}

	public State getDeathState() {
		return deathState;
	}

	public Display getDisplay() {
		return display;
	}

}
