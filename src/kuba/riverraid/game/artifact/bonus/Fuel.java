package kuba.riverraid.game.artifact.bonus;

import java.awt.image.BufferedImage;
import java.util.Random;

import kuba.riverraid.Constants;
import kuba.riverraid.background.Background;
import kuba.riverraid.game.artifact.MovingElement;
import kuba.riverraid.gfx.LoadGFX;

/**
 * @author jakub klasa tworzaca obraz paliwa (FUEL) podczas gry oraz losuje jego
 *         umiejscowienie i predkosc przesuwania
 */
public class Fuel extends MovingElement {

	private int SPEED = Constants.ARTIFACTION_SPEED;
	private final Random generator = new Random();
	private boolean direction = generator.nextBoolean();
	private final Background backGround;

	public Fuel(Background backGround, int x, int y) {
		super(x, y);
		this.backGround = backGround;
		SPEED += generator.nextInt(5) - 2;
	}

	@Override
	public void tick() {
		y += backGround.getBackgroundSpeed();
	}

	@Override
	protected BufferedImage getElementImage() {
		return LoadGFX.fuel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + SPEED;
		result = prime * result + ((backGround == null) ? 0 : backGround.hashCode());
		result = prime * result + (direction ? 1231 : 1237);
		result = prime * result + ((generator == null) ? 0 : generator.hashCode());
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
		Fuel other = (Fuel) obj;
		if (SPEED != other.SPEED)
			return false;
		if (backGround == null) {
			if (other.backGround != null)
				return false;
		} else if (!backGround.equals(other.backGround))
			return false;
		if (direction != other.direction)
			return false;
		if (generator == null) {
			if (other.generator != null)
				return false;
		} else if (!generator.equals(other.generator))
			return false;
		return true;
	}
}
