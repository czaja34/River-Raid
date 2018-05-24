package kuba.riverraid;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JOptionPane;

import kuba.riverraid.display.Display;
import kuba.riverraid.game.control.KeyControl;
import kuba.riverraid.game.manager.GameManager;
import kuba.riverraid.game.menu.Score;

/**
 * @author jakub glowna klasa gry,
 */
public class Game implements Runnable {

	private Display display;

	/** wysokosc szerokosc ekranu */
	public int width, height;

	/** tytul okna */
	public String title;

	/** zmienna potrzebna do tworzenia watkow */
	private Thread thread;

	/** zmienna logiczna pozwalajaca uruchomic i zatrzymac program */
	private boolean running = false;

	private BufferStrategy bs;

	private Graphics g;

	private GameManager gameManager;

	private KeyControl keyControl;

	/**
	 * @param title
	 *            zmienna opisujaca tytul okna
	 * @param width
	 *            zmienna opisujaca szrokosc okna
	 * @param height
	 *            zmienna opisujaca wysokosc okna
	 */
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyControl = new KeyControl();
	}

	/** metoda tworzaca ramke okna oraz klase funkcjonalana GameMenager */
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyControl);
		gameManager = new GameManager(this);
	}

	/**
	 * g³owna metoda o nazwie tick, metoda ta uruchamia metode o takiej samej
	 * nazwie w klasie KeyControl i GmaeMenager
	 */
	private void tick() {
		keyControl.tick();
		gameManager.tick();
		if (getKeyControl().newGame) {
			reset();
		}

	}

	/**
	 * glowna metoda render, metoda zajkmoje sie rysowaniem w oknie, uruchami
	 * medoty render w danych klasach oraz tworzy obiekt graficzny g dzieki
	 * ktoremu mozna rysowac w oknie
	 */
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		// drowning
		gameManager.render(g);
		g.drawString(Score.getPoints(), 900, 800);
		bs.show();
		g.dispose();
	}

	/**
	 * metoda slozy do rozpoczecia gry, tworzy okno dialogowe zapytujace o
	 * uruchomienie gry
	 */
	private void stargGame() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(null, "Rozpoczac GRE?", "River Raid", dialogButton);
		if (dialogResult == JOptionPane.NO_OPTION)
			System.exit(0);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		init();
		stargGame();

		while (running) {
			tick();
			render();
		}
		stop();
	}

	public KeyControl getKeyControl() {
		return keyControl;
	}

	/**
	 * metoda uruchamiajaca petle w metodzie run, oraz tworzaca nowy watek
	 */
	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	/**
	 * metoda przerywajaca petle w run
	 */
	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * metoda resetujaca gre oraz uruchamiajaca metode resetujaca keyControl
	 */
	public synchronized void reset() {
		keyControl.resetAllKeysState();
		gameManager = new GameManager(this);
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public Display getDisplay() {
		return display;
	}

	public Graphics getG() {
		return g;
	}
}
