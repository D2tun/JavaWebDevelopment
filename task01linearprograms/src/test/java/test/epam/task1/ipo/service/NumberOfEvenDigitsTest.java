package test.ipo.task1.service;

import org.testng.Assert;
import org.testng.annotations.*;

import by.ipo.task1.service.NumberOfEvenDigits;

public class NumberOfEvenDigitsTest {

	private NumberOfEvenDigits noed = NumberOfEvenDigits.getInstance();
	
	@DataProvider(name = "numberOfEvenDigitsData")
	public Object[][] setData() {
		return new Object[][] {
								{24, 2},
								{2485, 3}
							  };
	}
	
	@DataProvider(name = "numberOfEvenDigitsWrongData")
	public Object[][] setWrongData() {
		return new Object[][] {
								{-24, new NumberFormatException()},
								{0, new NumberFormatException()},
							  };
	}
	
	@Test(description = "Проверка нахождения чётных цифр числа", 
		  dataProvider = "numberOfEvenDigitsData")
	public void getQuantityTest(int num, int expectedAnswer) {
		Assert.assertEquals(noed.getQuantity(num), expectedAnswer);
	}
	
	@Test(description = "Проверка нахождения чётных цифр числа", 
			  dataProvider = "numberOfEvenDigitsWrongData",
			  expectedExceptions = NumberFormatException.class)
	public void getQuantityTestWrong(int num, 
									NumberFormatException expectedAnswer) {
		Assert.assertEquals(noed.getQuantity(num), expectedAnswer);
	}
}
