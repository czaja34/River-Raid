package kuba.riverraid.game.artifact.shot;

import java.awt.image.BufferedImage;

import kuba.riverraid.game.artifact.MovingElement;
import kuba.riverraid.gfx.LoadGFX;

/**
 * @author jakub klasa odpowiedzialna za obiekt pocisku w grze
 */
public class Bullet extends MovingElement {

	public Bullet(int x, int y) {
		super(x, y);
	}

	public void tick() {
		y -= 40;
	}

	@Override
	protected BufferedImage getElementImage() {
		return LoadGFX.bullet;
	}
}
