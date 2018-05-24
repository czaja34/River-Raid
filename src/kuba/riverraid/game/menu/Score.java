package kuba.riverraid.game.menu;

/**
 * @author jakub klasa odpowiedzialna za zliczanie punktow
 */
public class Score {

	private static int score = 0;

	public static void addHunderdPoints() {
		Score.score += 100;
	}

	public static void addOnePoints() {
		Score.score += 1;
	}

	public static void clear() {
		score = 0;
	}

	public static String getPoints() {
		return "Score: " + score;
	}

	public static int getPointsInt() {
		return score;
	}
}
