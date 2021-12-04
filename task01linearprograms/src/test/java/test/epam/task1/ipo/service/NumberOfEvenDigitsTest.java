package test.epam.task1.ipo.service;

import by.epam.task1.ipo.service.NumberOfEvenDigits;

import org.testng.Assert;
import org.testng.annotations.*;

public class NumberOfEvenDigitsTest {

	private NumberOfEvenDigits noed = NumberOfEvenDigits.getInstance();
	
	@DataProvider(name = "divideData")
	public Object[][] setData() {
		return new Object[][] {
								{"24", "Чётные цифры числа: 2, 4"},
								{"2485", "Чётные цифры числа: 2, 4, 8"},
								{"24 45", "Неверные данные"},
								{"-24", "Неверные данные"},
								{"цтл", "Неверные данные"},
								{"23.44", "Неверные данные"}
							  };
	}
	
	@Test(description = "Проверка нахождения чётных цифр числа", 
		  dataProvider = "divideData")
	public void getQuantityTest(String data, String expectedAnswer) {
		Assert.assertEquals(noed.getQuantity(data), expectedAnswer);
	}
}
