package test.ipo.task1.service;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.ipo.task1.service.TriangleCheck;

public class TriangleCheckTest {
	
	private TriangleCheck tc = TriangleCheck.getInstance();
	
	@DataProvider(name = "triangleData")
	public Object[][] setData() {
		return new Object[][] { 
								{2, 2, 2, true},
								{1.5, 1.8, 9.9, false}
							  };	
	}
	
	@DataProvider(name = "triangleWrongData")
	public Object[][] setWrongData() {
		return new Object[][] { 
								{2, 2, -2, new IOException()},
								{2, 2, 0, new IOException()},
							  };	
	}
	
	@Test(description = "Проверка обнаружения равностороннего треугольника",
		  dataProvider = "triangleData")
	public void checkEquilateralityTest(double side1, double side2, 
										double side3, boolean expectedAnswer) 
												throws IOException {
		Assert.assertEquals(tc.checkEquilaterality(side1, side2, side3), 
												   expectedAnswer);
	}
	
	@Test(description = "Проверка обнаружения равностороннего треугольника",
		  dataProvider = "triangleWrongData",
		  expectedExceptions = IOException.class)
	public void checkEquilateralityWrongTest(double side1, double side2, 
											 double side3, 
											 IOException expectedAnswer) 
													 throws IOException {
		Assert.assertEquals(tc.checkEquilaterality(side1, side2, side3), 
				   								   expectedAnswer);
	}
}
