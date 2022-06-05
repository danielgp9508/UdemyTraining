package TestNG.Listeners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ListenersTest {
	
	@Test
	public void test1() {
		Assert.assertTrue(true);
	}
	
	@Test
	public void test2() {
		Assert.assertTrue(false);
	}
	
	@Test
	public void test3() {
		Assert.assertTrue(true);
	}

}
