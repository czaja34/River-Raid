package kuba.riverraid.game.artifact.shot;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import kuba.riverraid.Constants;
import kuba.riverraid.Game;
import kuba.riverraid.game.artifact.MovingElement;
import kuba.riverraid.game.artifact.enemy.ArtifactsOnBackground;
import kuba.riverraid.game.artifact.plane.Plane;
import kuba.riverraid.game.manager.OccurrenceCollision;

/**
 * @author jakub klasa jest odpowiedzialna za utworzenie pocisku o odpowiednich
 *         wspolrzednych, dodanie tego obiektu do listy i odpalenie odpowiednich
 *         metod dla odpowiedniego obiektu
 */
public class BulletManager {

	/**
	 * lista zawierajaca liste wystrzelonych pocisków
	 */
	List<Bullet> bulletOnScrean = new ArrayList<Bullet>();

	private Plane plane;
	private Game game;
	private OccurrenceCollision occurrenceCollision;
	int indexBullet = 0;
	int index = 0;
	private int pauseRacket = Constants.TICKS_BETWEEN_ROCKETS;
	ArtifactsOnBackground artifactsOnBackGround;

	public BulletManager(Plane plane, Game game, ArtifactsOnBackground artifactsOnBackGround) {
		occurrenceCollision = new OccurrenceCollision(null, game.getDisplay(), game);
		this.plane = plane;
		this.game = game;
		this.artifactsOnBackGround = artifactsOnBackGround;
	}

	/**
	 * @param g
	 *            metoda sprawdzajaca czy wystrzelic pocisk
	 */
	public void oneshot(Graphics g) {
		inOneShot();
		shot(g);
	}

	/**
	 * metoda sprawdzajaca czy moze juz wystrzelic pocisk jezeli tak tworzy
	 * obiekt pocisku o odpowiednich wspólrzednych i dodaje do listy
	 * wystrzelonych pociskow
	 */
	public void inOneShot() {

		if (pauseRacket < Constants.TICKS_BETWEEN_ROCKETS)
			pauseRacket++;

		if (game.getKeyControl().bullet && pauseRacket == Constants.TICKS_BETWEEN_ROCKETS) {

			Bullet bullet = new Bullet(plane.getX() + 20, plane.getY());
			bulletOnScrean.add(bullet);
			pauseRacket = 0;
		}

	}

	/**
	 * @param g
	 *            metoda przelicza wsplrzedne dla kolejnych pociskow z listy i
	 *            je rysuje
	 */
	private void shot(Graphics g) {
		for (Bullet bullet : bulletOnScrean) {

			boolean remove = false;
			indexBullet = bulletOnScrean.indexOf(bullet);
			bullet.tick();
			bullet.render(g);
			if (bullet.getX() > 0 && bullet.getY() > 0) {
				try {
					remove = occurrenceCollision.bulletColision(bullet.getX(), bullet.getY());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (remove) {
				bulletOnScrean.remove(indexBullet);
				for (MovingElement movingElement : artifactsOnBackGround.getArtifactList()) {

					if (movingElement.getY() < bullet.getY() - 10) {
						artifactsOnBackGround.getArtifactList().remove(movingElement);
						break;
					}
				}
				break;

			}
			remove = false;

		}
		index = 0;
	}
}
