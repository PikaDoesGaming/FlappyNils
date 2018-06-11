package States;

import java.awt.Graphics;

import Entities.Bird;
import game1.Handler;

public abstract class State {

	protected Handler handler;
	private static State currentState;

	public State(Handler handler) {
		this.handler = handler;
	}

	public static State getCurrentState() {
		return currentState;
	}

	public static void setState(State state) {
		currentState = state;
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public Bird getBird() {
		return null;
	}

}
