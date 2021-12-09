package test.ipo.task1.service;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import by.ipo.task1.service.AreaCalculation;

public class AreaCalculationTest {

	private AreaCalculation ac = AreaCalculation.getInstance();

	@DataProvider(name = "dataForRectangleCalc")
	public Object[][] setData() {
		return new Object[][] {
				{ 4, 8 }, { 2.2, 2.42 }, { 9.2, 42.32 },
					  };
	}
	
	@DataProvider(name = "wrongDataForRectangleCalc")
	public Object[][] setWrongData() {
		return new Object[][] {
				{ 0, new IOException()}, { -8, new IOException() }
					  };
	}

	@Test(description = "Проверка вычисления площади прямоугольника", 
		  dataProvider = "dataForRectangleCalc")
	public void getAnswerTest(double length, double expectedAnswer) 
			throws IOException {
		Assert.assertEquals(ac.getAnswer(length), expectedAnswer);
	}
	
	@Test(description = "Проверка вычисления площади прямоугольника", 
		  dataProvider = "wrongDataForRectangleCalc",
		  expectedExceptions = IOException.class)
	public void getAnswerWrongTest(int length, IOException expectedAnswer) 
			throws IOException {
		Assert.assertEquals(ac.getAnswer(length), expectedAnswer);
	}
}
