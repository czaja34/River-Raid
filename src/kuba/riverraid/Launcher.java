package kuba.riverraid;

/**
 * @author jakub klasa uruchamiajaca gre, tworzy obiekt klasy Game
 */
public class Launcher {

	public static void main(String[] args) {
		Game game = new Game("River Raid", 1000, 900);

		game.start();

	}

}