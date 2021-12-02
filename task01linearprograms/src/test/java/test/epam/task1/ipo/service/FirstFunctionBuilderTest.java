package test.epam.task1.ipo.service;

import by.epam.task1.ipo.service.FirstFunctionBuilder;

import org.testng.Assert;
import org.testng.annotations.*;

public class FirstFunctionBuilderTest {
	
	private FirstFunctionBuilder bff = FirstFunctionBuilder.getInstance();
	
	@DataProvider(name = "buildingData")
	public Object[][] setData() {
		return new Object[][] { {1, 3, 1, "x    y\n1.0    -1.0\n2.0    -2.0\n"
										  + "3.0    3.0\n"},
								{-6, 2.4, 2, "x    y\n-6.0    6.0\n-4.0    "
											 + "4.0\n-2.0    2.0\n0.0    "
											 + "-0.0\n2.0    -2.0\n"},
							  };	
	}
	
	@Test(description = "Проверка построения функции 1", 
		  dataProvider = "buildingData")
	public void getCoordinatesTest(double lowLimit, double highLimit, 
								   double step, String expectedAnswer) {
		Assert.assertEquals(bff.getCoordinates(lowLimit, highLimit, step), 
											   expectedAnswer);
	}

}
