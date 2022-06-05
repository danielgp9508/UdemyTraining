package JavaCore.Interfaces;

public interface VideoGames {
	
	public void playVideoGame();
	
	public default void developVideoGame() {
		System.out.println("develop VideoGame Interface default");
	}
	
	public static void sellVideoGame() {
		System.out.println("sell VideoGame Interface static");
	}
}
