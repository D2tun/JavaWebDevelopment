package test.epam.task1.ipo.service;

import by.epam.task1.ipo.service.GreaterDigitSearch;

import org.testng.Assert;
import org.testng.annotations.*;

public class GreaterDigitSearchTest {
	
	GreaterDigitSearch gds = GreaterDigitSearch.getInstance();
	
	@Test(description = "Проверка поиска наибольшей цифры в числе")
	public void getGreaterDigit() {
		char[] ar = {1, 2, 3};
		String expectedAnswer = "Наибольшая цифра числа: 3";
		Assert.assertEquals(gds.getGreaterDigit(ar), expectedAnswer);
	}

}
