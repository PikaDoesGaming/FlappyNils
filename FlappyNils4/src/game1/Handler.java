package game1;

import States.State;
import input.KeyManager;

public class Handler {

	private Game game;
	private KeyManager keyManager;
	private State gameState;

	public Handler(Game game) {
		this.game = game;
	}
	
	public void setKeyManager(KeyManager km) {
		keyManager = km;
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public Game getGame() {
		return game;
	}

	public void setGameState(State gameState) {
		this.gameState = gameState;
	}

	public State getGameState() {
		return gameState;
	}

}
