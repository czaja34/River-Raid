package kuba.riverraid.game.manager;

import java.awt.Graphics;

import kuba.riverraid.Game;
import kuba.riverraid.background.Background;
import kuba.riverraid.game.artifact.enemy.ArtifactsOnBackground;
import kuba.riverraid.game.artifact.plane.Plane;
import kuba.riverraid.game.artifact.shot.BulletManager;
import kuba.riverraid.game.menu.FuelPlane;
import kuba.riverraid.game.menu.Score;

/**
 * @author jakub klasa odpowiedzilana za wywo³anie odpwoiednich metod i
 *         utworzenie obiektów wystepujacych w grze
 */
public class GameManager {

	private Plane plane;
	private BulletManager bulletShot;
	private OccurrenceCollision occurrenceCollision;
	private Background background = new Background();
	private FuelPlane fuelPlane;
	private ArtifactsOnBackground artifactsOnBackGround = new ArtifactsOnBackground(background, 0, 0);

	public GameManager(Game game) {

		fuelPlane = new FuelPlane(game, background);
		plane = new Plane(game, background);
		bulletShot = new BulletManager(plane, game, artifactsOnBackGround);
		occurrenceCollision = new OccurrenceCollision(fuelPlane, game.getDisplay(), game);
		Score.clear();

	}

	/**
	 * metoda wywolujaca metody tick dla poszczegolnych obiektow
	 */
	public void tick() {
		background.tick();
		plane.tick();
		fuelPlane.tick();
		Score.addOnePoints();

		try {

			occurrenceCollision.collision(plane.getX(), plane.getY());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * metoda wywo³ujaca metody rysowane w oknie
	 */
	public void render(Graphics g) {
		background.render(g);
		plane.render(g);
		bulletShot.oneshot(g);
		artifactsOnBackGround.render(g);
		fuelPlane.render(g);

	}

}
