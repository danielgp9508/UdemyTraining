package JavaCore.Interfaces;

import org.testng.annotations.Test;

public class ExecuteInterface {

	@Test
	public void executeMethod() {
		Soccer soccer = new Soccer();
		Tennis tennis = new Tennis();
		soccer.practiceSport();
		soccer.playVideoGame();
		soccer.developVideoGame();
		System.out.println("");
		tennis.practiceSport();
		tennis.playVideoGame();
		tennis.developVideoGame();
		VideoGames.sellVideoGame();
	}
}
