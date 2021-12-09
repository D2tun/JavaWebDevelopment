package test.ipo.task1.service;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import by.ipo.task1.service.NaturalNumDiv;

public class NaturalNumDivTest {

	private NaturalNumDiv nnd = NaturalNumDiv.getInstance();
	
	@DataProvider(name = "divideData")
	public Object[][] setData() {
		return new Object[][] {
								{9000, 7, new int[] {5, 7}},
								{800, 70, new int[] {1, 4}},
								{66, 8, new int[] {8, 2}},
							  };
	}
	
	@DataProvider(name = "divideWrongData")
	public Object[][] setWrongData() {
		return new Object[][] {
								{0, 1, new IOException()},
								{-60, 8, new IOException()},
								{6, 0, new IOException()},
								{0, 0, new IOException()},
								{-8, -25, new IOException()}
							  };
	}
	
	@Test(description = "Проверка нахождения разрядов", 
		  dataProvider = "divideData")
	public void divideTest(int m, int n, int[] expectedAnswer) 
			throws IOException {
		Assert.assertEquals(nnd.divide(m, n), expectedAnswer);
	}
	
	@Test(description = "Проверка нахождения разрядов", 
		  dataProvider = "divideWrongData",
		  expectedExceptions = IOException.class)
	public void divideWrongTest(int m, int n, IOException expectedAnswer) 
			throws IOException {
		Assert.assertEquals(nnd.divide(m, n), expectedAnswer);
	}
}
