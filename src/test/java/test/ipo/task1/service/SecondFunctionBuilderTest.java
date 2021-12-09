package test.ipo.task1.service;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import by.ipo.task1.service.SecondFunctionBuilder;

public class SecondFunctionBuilderTest {
	
	private SecondFunctionBuilder sfb = SecondFunctionBuilder.getInstance();

	@DataProvider(name = "buildingData")
	public Object[][] setData() {
		return new Object[][] { {1, 3, 1, new double[][] {{1, 2, 3},
														  {0.1585290151921035, 
														   1.0907025731743183, 
														   2.8588799919401326}}},
								{-9.8, 1.4, 3.1, new double[][] {{-9.8, 
															 -6.700000000000001, 
															 -3.600000000000001, 
															 -0.5000000000000009},
															{-10.166479129251929, 
															 -6.295150079383402, 
															 -4.042520443294854,
															 -0.020574461395797106}}}
							  };	
	}
	
	@DataProvider(name = "buildingWrongData")
	public Object[][] setWrongData() {
		return new Object[][] { {1, 3, 0, new IOException()},
								{-9.8, 1.4, -5, new IOException()},
							  };	
	}
	
	@Test(description = "Проверка построения F(x) = x - sin(x)", 
						dataProvider = "buildingData")
	public void getCoordinates(double lowLimit, double highLimit, double step, 
							   double[][] expectedAnswer) throws IOException {
		Assert.assertEquals(sfb.getCoordinates(lowLimit, highLimit, step),
											   expectedAnswer);
	}
	
	@Test(description = "Проверка построения F(x) = x - sin(x)", 
			dataProvider = "buildingWrongData",
			expectedExceptions = IOException.class)
	public void getCoordinatesWrong(double lowLimit, double highLimit, double step, 
			IOException expectedAnswer) throws IOException {
		Assert.assertEquals(sfb.getCoordinates(lowLimit, highLimit, step), expectedAnswer);
	}
}
