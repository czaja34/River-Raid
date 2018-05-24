package kuba.riverraid.game.manager;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

import kuba.riverraid.Constants;
import kuba.riverraid.Game;
import kuba.riverraid.display.Display;
import kuba.riverraid.game.menu.FuelPlane;
import kuba.riverraid.game.menu.Score;

/**
 * @author jakub klasa sprawdzajaca kolizje miedzy obiektami
 */
public class OccurrenceCollision {

	private Display display;
	private Game game;
	private FuelPlane fuelPlane;

	public OccurrenceCollision(FuelPlane fuelPlane, Display display, Game game) {
		this.fuelPlane = fuelPlane;
		this.display = display;
		this.game = game;

	}

	/**
	 * @param planeX
	 * @param planeY
	 * @throws Exception
	 *             metoda wywo³ywana dla samolotu, sprawdza czy samolot wlecia³
	 *             na zielone t³o lub na jakis artefakt
	 */
	public void collision(int planeX, int planeY) throws Exception {

		Robot robot = new Robot();
		display.frameLocation();
		BufferedImage screanShot = robot
				.createScreenCapture(new Rectangle(display.getxLocation(), display.getyLocation(), 1000, 900));
		int planeLeftPixel = screanShot.getRGB(planeX + 15, planeY + 35);
		// System.out.println(planeLeftPixel);
		int planeRightPixel = screanShot.getRGB(planeX + Constants.PLANE_WIDTH - 15, planeY + 35);

		if (planeLeftPixel == Constants.COLOR_GREEN || planeRightPixel == Constants.COLOR_GREEN) {
			resumeGame();
		}
		if (planeLeftPixel == Constants.COLOR_PURPLE || planeRightPixel == Constants.COLOR_PURPLE) {
			resumeGame();
		}
		if (planeLeftPixel == Constants.COLOR_RED || planeRightPixel == Constants.COLOR_RED) {
			fuelPlane.setLowFuel(0);
			Score.addHunderdPoints();
		}
		if (planeLeftPixel == Constants.COLOR_GRASS || planeRightPixel == Constants.COLOR_GRASS) {
			resumeGame();
		}

	}

	/**
	 * @param bulletX
	 * @param bulletY
	 * @return
	 * @throws Exception
	 *             metoda sprawdzajaca kolizje pocisku, czyli czy pocisk
	 *             setrzeli³ jakis artefakt
	 */
	public boolean bulletColision(int bulletX, int bulletY) throws Exception {

		Robot robot = new Robot();
		display.frameLocation();
		BufferedImage screanShot = robot
				.createScreenCapture(new Rectangle(display.getxLocation(), display.getyLocation(), 1000, 900));
		int bulletLeftPixel = screanShot.getRGB(bulletX + 5, bulletY + 5);
		int bulletRightPixel = screanShot.getRGB(bulletX + 15, bulletY + 5);
		// System.out.println("bullet" + bulletX);

		if (bulletLeftPixel == Constants.COLOR_GREEN || bulletRightPixel == Constants.COLOR_GREEN
				|| bulletLeftPixel == Constants.COLOR_PURPLE || bulletRightPixel == Constants.COLOR_PURPLE
				|| bulletLeftPixel == Constants.COLOR_RED || bulletRightPixel == Constants.COLOR_RED) {
			Score.addHunderdPoints();
			return true;
		}
		return false;
	}

	/**
	 * metoda wywo³ujaca okno dialogowe z zapytaniem i wykonujaca odpowiednie
	 * zadania w zaleznosci od wybranej opcji
	 */
	private void resumeGame() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null, "Wznowic GRE?", "River Raid", dialogButton);
		if (dialogResult == JOptionPane.NO_OPTION)
			System.exit(0);
		if (dialogResult == JOptionPane.YES_OPTION)
			game.reset();
	}

}
