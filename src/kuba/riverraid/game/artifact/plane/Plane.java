package kuba.riverraid.game.artifact.plane;

import java.awt.image.BufferedImage;

import kuba.riverraid.Constants;
import kuba.riverraid.Game;
import kuba.riverraid.background.Background;
import kuba.riverraid.game.artifact.MovingElement;
import kuba.riverraid.gfx.LoadGFX;

/**
 * @author jakub klasa odpowiedzialna za obiekt samolotu podczas gry
 */
public class Plane extends MovingElement {

	private static final int INITIAL_X = 470, INITIAL_Y = 800;
	private final Game game;
	private final Background backGround;

	public Plane(Game game, Background backGround) {
		super(INITIAL_X, INITIAL_Y);

		if (game == null) {
			throw new IllegalArgumentException("Game cannot be null");
		}

		this.game = game;
		this.backGround = backGround;

	}

	@Override
	public void tick() {

		if (game.getKeyControl().up) {
			backGround.setBackgroundSpeed(5);
		} else {
			backGround.setBackgroundSpeed(3);
		}
		if (game.getKeyControl().down) {
			backGround.setBackgroundSpeed(1);
		}
		if (game.getKeyControl().left)
			x += -Constants.BASIC_SPEED;
		if (game.getKeyControl().right)
			x += Constants.BASIC_SPEED;

	}

	@Override
	protected BufferedImage getElementImage() {
		return LoadGFX.plane;
	}
}
