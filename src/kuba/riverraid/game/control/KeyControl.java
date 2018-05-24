package kuba.riverraid.game.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author jakub klasa odpwoiedzialna za sprawdzanie czy odpowiednie klawisze na
 *         klawiaturze zosta³y wcisniete
 */
public class KeyControl implements KeyListener {

	private boolean[] keys;

	public boolean left, right, up, down;
	public boolean bullet;
	public boolean newGame;

	public KeyControl() {
		keys = new boolean[200];
	}

	public void tick() {
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		bullet = keys[KeyEvent.VK_SPACE];
		newGame = keys[KeyEvent.VK_N];
	}

	public void resetAllKeysState() {
		for (int i = 0; i < keys.length; i++) {
			keys[i] = false;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		// System.out.println("wcisnieto");

	}

	@Override
	public void keyReleased(KeyEvent e) {

		keys[e.getKeyCode()] = false;

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}
