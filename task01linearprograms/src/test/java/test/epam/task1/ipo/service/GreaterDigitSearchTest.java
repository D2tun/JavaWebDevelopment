package test.epam.task1.ipo.service;

import by.epam.task1.ipo.service.GreaterDigitSearch;

import org.testng.Assert;
import org.testng.annotations.*;

public class GreaterDigitSearchTest {
	
	GreaterDigitSearch gds = GreaterDigitSearch.getInstance();
	
	@DataProvider(name = "digitsData")
	public Object[][] setData() {
		return new Object[][] {
								{"123", "Наибольшая цифра числа: 3"},
								{"9146", "Наибольшая цифра числа: 9"},
								{"91.46", "Неверные данные"},
								{"иыи47", "Неверные данные"},
							  };
	}
	
	@Test(description = "Проверка поиска наибольшей цифры в числе",
		  dataProvider = "digitsData")
	public void getGreaterDigit(String num, String expectedAnswer) {
		Assert.assertEquals(gds.getGreaterDigit(num), expectedAnswer);
	}
}
