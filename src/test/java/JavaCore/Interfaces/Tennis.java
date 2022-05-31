package JavaCore.Interfaces;

public class Tennis implements  Sport, VideoGames {

	@Override
	public void practiceSport() {
		System.out.println("practice Tennis");
	}

	@Override
	public void playVideoGame() {
		System.out.println("play Tennis video Game");
		
	}
	
	@Override
	public void developVideoGame() {
		System.out.println("develop Tennis VideoGame override");
	}

}
