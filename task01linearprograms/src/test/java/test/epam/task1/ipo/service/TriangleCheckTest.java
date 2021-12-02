package test.epam.task1.ipo.service;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.epam.task1.ipo.service.TriangleCheck;

public class TriangleCheckTest {
	
	private TriangleCheck tc = TriangleCheck.getInstance();
	
	@DataProvider(name = "triangleData")
	public Object[][] setData() {
		return new Object[][] { {2, 2, 2, "Это равносторонний треугольник"},
								{1.5, 1.8, 9.9, "Это не равносторонний "
												+ "треугольник"},
							  };	
	}
	
	@Test(description = "Проверка обнаружения равностороннего треугольника",
		  dataProvider = "triangleData")
	public void checkEquilateralityTest(double side1, double side2, 
										double side3, String expectedAnswer) {
		Assert.assertEquals(tc.checkEquilaterality(side1, side2, side3), 
							expectedAnswer);
	}
	
}
