package kuba.riverraid.game.artifact.enemy;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kuba.riverraid.background.Background;
import kuba.riverraid.game.artifact.MovingElement;
import kuba.riverraid.game.artifact.bonus.Fuel;

/**
 * @author jakub klasa odpowiedzialna za losowanie artefaktów (czyli paliwo
 *         helikopter i statek) jakie beda rysowane podczas gry
 */
public class ArtifactsOnBackground {

	public int x, y;
	private int pauseBetwenArtifactOnBackgroud;

	/**
	 * lista rysowanych artefaktów
	 */
	private List<MovingElement> artifactList = new ArrayList<MovingElement>();

	private Random generator = new Random();
	public Background backGround;

	public ArtifactsOnBackground(Background backGround, int x, int y) {

		this.backGround = backGround;
		this.x = x;
		this.y = y;
	}

	/**
	 * @param g
	 *            metoda odpowiedzialna za wylosowanie artefaktu, utworzenia
	 *            jego obiektu o odpowiednich wspólrzednych , umieszczenia go w
	 *            liscie i odpalenie odpowiedniej metody dla odpowiedniego
	 *            obiektu
	 */
	private void inRender(Graphics g) {

		if (pauseBetwenArtifactOnBackgroud == 30) {
			int i = generator.nextInt(3);
			x = generator.nextInt(540);
			int y = (generator.nextInt(20) - 10);

			if (i == 0) {
				Fuel fuel = new Fuel(backGround, x + 200, y);
				fuel.tick();
				fuel.render(g);
				artifactList.add(fuel);
			}
			if (i == 1) {
				Helicopter helicopter = new Helicopter(backGround, x + 200, y);
				helicopter.tick();
				helicopter.render(g);
				artifactList.add(helicopter);
			}
			if (i == 2) {
				Ship ship = new Ship(backGround, x + 200, y);
				ship.tick();
				ship.render(g);
				artifactList.add(ship);
			}
			pauseBetwenArtifactOnBackgroud = 0;
		}
		pauseBetwenArtifactOnBackgroud++;
	}

	public void render(Graphics g) {
		inRender(g);
		for (MovingElement a : artifactList) {

			a.tick();
			a.render(g);
		}

	}

	public List<MovingElement> getArtifactList() {
		return artifactList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artifactList == null) ? 0 : artifactList.hashCode());
		result = prime * result + ((backGround == null) ? 0 : backGround.hashCode());
		result = prime * result + ((generator == null) ? 0 : generator.hashCode());
		result = prime * result + pauseBetwenArtifactOnBackgroud;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArtifactsOnBackground other = (ArtifactsOnBackground) obj;
		if (artifactList == null) {
			if (other.artifactList != null)
				return false;
		} else if (!artifactList.equals(other.artifactList))
			return false;
		if (backGround == null) {
			if (other.backGround != null)
				return false;
		} else if (!backGround.equals(other.backGround))
			return false;
		if (generator == null) {
			if (other.generator != null)
				return false;
		} else if (!generator.equals(other.generator))
			return false;
		if (pauseBetwenArtifactOnBackgroud != other.pauseBetwenArtifactOnBackgroud)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
