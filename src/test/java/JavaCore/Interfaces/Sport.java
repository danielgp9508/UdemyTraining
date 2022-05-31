package JavaCore.Interfaces;

public interface Sport {

	public void practiceSport();
	
	public default void sportHistory() {
		System.out.println("interface method");
	}
}
