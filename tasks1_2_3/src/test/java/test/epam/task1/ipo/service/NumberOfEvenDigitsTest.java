package test.epam.task1.ipo.service;

import by.epam.task1.ipo.service.NumberOfEvenDigits;

import org.testng.Assert;
import org.testng.annotations.*;

public class NumberOfEvenDigitsTest {

	private NumberOfEvenDigits nofed = NumberOfEvenDigits.getInstance();
	
	@Test(description = "Проверка нахождения чётных цифр числа")
	public void getQuantityTest() {
		char[] digits = {1, 2, 3, 4};
		String expectedAnswer = "Чётные цифры числа: 2, 4";
		Assert.assertEquals(nofed.getQuantity(digits), expectedAnswer);
	}
}
