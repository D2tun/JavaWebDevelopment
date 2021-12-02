package test.epam.task1.ipo.service;

import by.epam.task1.ipo.service.NumberOfEvenDigits;

import org.testng.Assert;
import org.testng.annotations.*;

public class NumberOfEvenDigitsTest {

	private NumberOfEvenDigits noed = NumberOfEvenDigits.getInstance();
	
	@DataProvider(name = "divideData")
	public Object[][] setData() {
		char[] digits = {1, 2, 3, 4};
		char[] digits2 = {1, 2, 3, 4, 9, 8, 7};
		return new Object[][] {
								{digits, "Чётные цифры числа: 2, 4"},
								{digits2, "Чётные цифры числа: 2, 4, 8"}
							  };
	}
	
	@Test(description = "Проверка нахождения чётных цифр числа", 
		  dataProvider = "divideData")
	public void getQuantityTest(char[] ch, String expectedAnswer) {
		Assert.assertEquals(noed.getQuantity(ch), expectedAnswer);
	}
}
