package States;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import Entities.Bird;
import Entities.Pipe;
import Util.CollisionDetection;
import game1.Handler;

public class GameState extends State {

	private int tick_counter = 0;
	private final static int generation_speed = 100;

	private Bird bird;
	private ArrayList<Pipe> pipes;

	private Random random = new Random();

	public GameState(Handler handler) {
		super(handler);
		bird = new Bird(handler);
		pipes = new ArrayList<Pipe>();
	}

	@Override
	public void tick() {
		if (!bird.isDead()) {
			for (int i = 0; i < pipes.size(); i++) {
				pipes.get(i).tick();
				if (pipes.get(i).getX() + pipes.get(i).getWidth() < 0) {
					pipes.remove(i);
				}
			}

			for (int i = 0; i < pipes.size(); i++) {
				if (CollisionDetection.testBirdPipeCollision(bird, pipes.get(i))) {
					bird.kill();
					System.out.println("You are dead");
				}
			}

			if (tick_counter % generation_speed == 0) {
				generatePipe();
			}

			tick_counter++;
		}

		bird.tick();
		handler.getKeyManager().tick();
	}

	@Override
	public void render(Graphics g) {
		for (int i = 0; i < pipes.size(); i++) {
			pipes.get(i).render(g);
		}
		bird.render(g);

		if (bird.isDead()) {

			handler.getGame().getDeathState().render(g);

		}

	}

	private void restart() {
		for (int i = 0; i < pipes.size(); i++) {
			pipes.remove(i);
			tick_counter = 0;
		}
		bird = new Bird(handler);
	}

	private void generatePipe() {
		int rand_y = 100 + random.nextInt(600 - Pipe.holeHeight);
		pipes.add(new Pipe(rand_y, handler));
	}

	@Override
	public Bird getBird() {
		return bird;
	}

	public ArrayList<Pipe> getPipes() {
		return pipes;
	}

}
