package kuba.riverraid.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;

/**
 * @author jakub klasa tworzy okno (frame)
 */
public class Display {

	private JFrame frame;

	private final Canvas canvas = new Canvas();

	private final String title;

	private final int width, heigh;

	private Point Location;

	private int yLocation, xLocation;

	/**
	 * @param title
	 * @param width
	 * @param heigh
	 *            konstruktor przypisujacy dane do pol
	 */
	public Display(String title, int width, int heigh) {
		this.title = title;
		this.width = width;
		this.heigh = heigh;

		createDisplay();
	}

	/**
	 * metoda tworzy okno o odpowiednik wymiarach i tytule i okreslonych
	 * wlasciwosciach okna
	 */
	private void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(width, heigh);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		canvas.setPreferredSize(new Dimension(width, heigh));
		canvas.setMaximumSize(new Dimension(width, heigh));
		canvas.setMinimumSize(new Dimension(width, heigh));
		canvas.setFocusable(false);

		frame.add(canvas);
		frame.pack();
	}

	/**
	 * metoda przypisuje do zmiennych lokalizacje okna na pulpicie
	 */
	public void frameLocation() {
		Location = frame.getLocationOnScreen();
		yLocation = (int) Location.getY();
		xLocation = (int) Location.getX();
	}

	public int getyLocation() {
		return yLocation;
	}

	public void setyLocation(int yLocation) {
		this.yLocation = yLocation;
	}

	public int getxLocation() {
		return xLocation;
	}

	public void setxLocation(int xLocation) {
		this.xLocation = xLocation;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public JFrame getFrame() {
		return frame;
	}

	public int getWidth() {
		return width;
	}

	public int getHeigh() {
		return heigh;
	}

}
