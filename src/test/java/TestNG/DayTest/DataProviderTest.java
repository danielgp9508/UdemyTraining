package TestNG.DayTest;

import java.util.ArrayList;
import java.util.List;

import javax.xml.crypto.Data;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	@Test
	public void dataProviderTest1() {
		System.out.println("Test without DP");
	}
	
	@Test(dataProvider = "data")
	public void dataProviderTest2(String dp, int num) {
		System.out.println("Test witht DP");
		System.out.println(dp + " " + num);
	}
	
	@DataProvider
	public Object[][] data() {
		
		Object[][] dataprovider = new Object[4][2];
		dataprovider[0][0] = "test1";
		dataprovider[0][1] = 1;
		dataprovider[1][0] = "test2";
		dataprovider[1][1] = 2;
		dataprovider[2][0] = "test3";
		dataprovider[2][1] = 3;
		dataprovider[3][0] = "test4";
		dataprovider[3][1] = 4;
		return dataprovider;
		
	}


}
