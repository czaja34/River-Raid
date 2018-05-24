package kuba.riverraid.game.menu;

import java.awt.Graphics;

import kuba.riverraid.Constants;
import kuba.riverraid.Game;
import kuba.riverraid.background.Background;
import kuba.riverraid.gfx.LoadGFX;

public class FuelPlane {
	private Background background;
	private Game game;
	private int lowFuel = 0;

	private final int x = 950, y = 300;

	public FuelPlane(Game game, Background background) {
		this.game = game;
		this.background = background;
	}

	public void tick() {
		lowFuel += background.getBackgroundSpeed();

	}

	/**
	 * @param g
	 *            metoda rysuje odpowiednie zdjecie pokazujace stan paliwa w
	 *            baku
	 */
	public void render(Graphics g) {
		if (0 <= lowFuel && lowFuel < Constants.INAF_FUEL)
			g.drawImage(LoadGFX.fuel1, x, y, null);
		if (Constants.INAF_FUEL <= lowFuel && lowFuel < 2 * Constants.INAF_FUEL)
			g.drawImage(LoadGFX.fuel2, x, y, null);
		if (2 * Constants.INAF_FUEL <= lowFuel && lowFuel < 3 * Constants.INAF_FUEL)
			g.drawImage(LoadGFX.fuel3, x, y, null);
		if (3 * Constants.INAF_FUEL <= lowFuel && lowFuel < 4 * Constants.INAF_FUEL)
			g.drawImage(LoadGFX.fuel4, x, y, null);
		if (4 * Constants.INAF_FUEL <= lowFuel && lowFuel < 5 * Constants.INAF_FUEL)
			g.drawImage(LoadGFX.fuel5, x, y, null);
		if (5 * Constants.INAF_FUEL <= lowFuel && lowFuel < 6 * Constants.INAF_FUEL)
			g.drawImage(LoadGFX.fuel6, x, y, null);
		if (6 * Constants.INAF_FUEL <= lowFuel && lowFuel < 7 * Constants.INAF_FUEL)
			g.drawImage(LoadGFX.fuel7, x, y, null);
		if (lowFuel >= 7 * Constants.INAF_FUEL) {
			g.drawImage(LoadGFX.fuel8, x, y, null);
			game.setRunning(false);
		}

	}

	public int getLowFuel() {
		return lowFuel;
	}

	public void setLowFuel(int lowFuel) {
		this.lowFuel = lowFuel;
	}
}
