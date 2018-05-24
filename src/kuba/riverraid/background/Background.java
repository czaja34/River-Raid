package kuba.riverraid.background;

import java.awt.Graphics;

import kuba.riverraid.gfx.LoadGFX;

/**
 * @author jakub klasa zajmuje sie t³em, czyli rysowaniem i przeliczaniem
 *         wspolrzednych
 */
public class Background {

	/**
	 * predkosc przesuwanie sie tla w pikselach na tykniecie
	 */
	private int backgroundSpeed = 1;

	/**
	 * zmienne odpowiadajace za umiejscowienie tla w oknie, yFirst dla
	 * pierwszego przesuwanego kawa³ka tla, ySecond dla 2 kawa³ka
	 */
	private int x = 0, yFirst = -1600, ySecond = -1600;

	/**
	 * metoda przelicza umiejscowienie kolejnego tla w oknie
	 */
	public void tick() {
		yFirst += backgroundSpeed;
		ySecond += backgroundSpeed;
		if (-yFirst < backgroundSpeed && yFirst < 0)
			yFirst -= yFirst;
		if (-ySecond < backgroundSpeed && ySecond < 0)
			ySecond -= ySecond;
	}

	/**
	 * @param g
	 *            metoda rysuje w oknie t³a o wspólrzednych x i y;
	 */
	public void render(Graphics g) {
		g.drawImage(LoadGFX.backGroundSecond, x, ySecond, null);
		g.drawImage(LoadGFX.backGroundFirst, x, yFirst, null);

		if (yFirst == 0) {
			ySecond = -2500;
		}
		if (ySecond == 0) {
			yFirst = -2500;
		}

	}

	public int getBackgroundSpeed() {
		return backgroundSpeed;
	}

	public void setBackgroundSpeed(int backgroundSpeed) {
		this.backgroundSpeed = backgroundSpeed;
	}

}
