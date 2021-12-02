package test.epam.task1.ipo.service;

import by.epam.task1.ipo.service.GreaterDigitSearch;

import org.testng.Assert;
import org.testng.annotations.*;

public class GreaterDigitSearchTest {
	
	GreaterDigitSearch gds = GreaterDigitSearch.getInstance();
	
	@DataProvider(name = "digitsData")
	public Object[][] setData() {
		char[] digits = {1, 2, 3};
		char[] digits2 = {1, 2, 3, 9 ,7, 6, 3, 7, 8};
		return new Object[][] {
								{digits, "Наибольшая цифра числа: 3"},
								{digits2, "Наибольшая цифра числа: 9"}
							  };
	}
	
	@Test(description = "Проверка поиска наибольшей цифры в числе",
		  dataProvider = "digitsData")
	public void getGreaterDigit(char[] ch, String expectedAnswer) {
		Assert.assertEquals(gds.getGreaterDigit(ch), expectedAnswer);
	}

}
