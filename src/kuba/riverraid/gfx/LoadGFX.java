package kuba.riverraid.gfx;

import java.awt.image.BufferedImage;

/**
 * @author jakub klasa ³adujaca odpowiednie grafiki do zmiennych (obiektow
 *         graficznych)
 */
public class LoadGFX {

	public final static BufferedImage backGroundFirst, backGroundSecond;
	public final static BufferedImage plane;
	public final static BufferedImage bullet;
	public final static BufferedImage helicopter;
	public final static BufferedImage ship;
	public final static BufferedImage fuel;
	public final static BufferedImage fuel1, fuel2, fuel3, fuel4, fuel5, fuel6, fuel7, fuel8;
	public final static BufferedImage firstPage;

	static {

		backGroundFirst = ImageLoader.loadImage("/texture/tlo1.png");
		backGroundSecond = ImageLoader.loadImage("/texture/tlo2.png");

		plane = ImageLoader.loadImage("/texture/plane.png");

		bullet = ImageLoader.loadImage("/texture/rakieta.png");

		helicopter = ImageLoader.loadImage("/texture/helikopter.png");

		ship = ImageLoader.loadImage("/texture/statek.png");

		fuel = ImageLoader.loadImage("/texture/fuel.png");

		fuel1 = ImageLoader.loadImage("/texture/fuel1.png");
		fuel2 = ImageLoader.loadImage("/texture/fuel2.png");
		fuel3 = ImageLoader.loadImage("/texture/fuel3.png");
		fuel4 = ImageLoader.loadImage("/texture/fuel4.png");
		fuel5 = ImageLoader.loadImage("/texture/fuel5.png");
		fuel6 = ImageLoader.loadImage("/texture/fuel6.png");
		fuel7 = ImageLoader.loadImage("/texture/fuel7.png");
		fuel8 = ImageLoader.loadImage("/texture/fuel8.png");

		firstPage = ImageLoader.loadImage("/texture/pierwsza_strona.png");
	}
}