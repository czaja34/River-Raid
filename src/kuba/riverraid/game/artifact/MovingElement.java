package kuba.riverraid.game.artifact;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * @author jakub klasa obstrakcyjna z polami opisujacymi po³orzenie na ekranie i
 *         metodami tick i render
 */
public abstract class MovingElement {

	protected int x, y;

	public MovingElement(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * metoda przeliczajaca parametry x i y
	 */
	public abstract void tick();

	/**
	 * @param g
	 *            metoda rysujaca dany opiekt w damym miejscu x i y w oknie
	 */
	public void render(Graphics g) {
		g.drawImage(getElementImage(), x, y, null);

	}

	protected abstract BufferedImage getElementImage();

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
