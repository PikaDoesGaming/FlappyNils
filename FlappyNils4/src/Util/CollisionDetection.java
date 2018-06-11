package Util;

import Entities.Bird;
import Entities.Pipe;

public class CollisionDetection {

	public static boolean testBirdPipeCollision(Bird b, Pipe p) {
		int xb = (int) b.getX();
		int yb = (int) b.getY();
		int wb = b.getWidth();
		int hb = b.getHeight();

		int xp = p.getX();
		int yp = p.getY();
		int wp = p.getWidth();
		int hp = p.getHoleHeight();

		if(yb < 0) {
			return true;
		}
		
		if (xb + wb < xp) {
			return false;
		}

		if (xb > xp + wp) {
			return false;
		}

		if (yb < yp) {
			return true;
		}

		if (yb + hb > yp + hp) {
			return true;
		}

		return false;

	}

}
