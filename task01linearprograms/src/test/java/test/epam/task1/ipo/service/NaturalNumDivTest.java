package test.epam.task1.ipo.service;

import by.epam.task1.ipo.service.NaturalNumDiv;

import org.testng.Assert;
import org.testng.annotations.*;

public class NaturalNumDivTest {

	private NaturalNumDiv nnd = NaturalNumDiv.getInstance();
	
	@DataProvider(name = "divideData")
	public Object[][] setData() {
		return new Object[][] {
								{"9000 7", "9000 / 7 = 1285.7142857142858\n"
										  + "Старшая цифра дробной части 7\n"
										  + "Младшая цифра целой части 5"},
								{"800 70", "800 / 70 = 11.428571428571429\n"
										  + "Старшая цифра дробной части 4\n"
										  + "Младшая цифра целой части 1"},
								{"66 8", "66 / 8 = 8.25\n"
										+ "Старшая цифра дробной части 2\n"
										+ "Младшая цифра целой части 8"},
								{"6.6 0.8", "Неверные данные"},
								{"-60 8", "Неверные данные"},
								{"21", "Неверные данные"},
								{"4 6 3", "Неверные данные"},
								{"эжтжтб", "Неверные данные"}
							  };
	}
	
	@Test(description = "Проверка нахождения разрядов", 
		  dataProvider = "divideData")
	public void divideTest(String data, String expectedAnswer) {
		Assert.assertEquals(nnd.divide(data), expectedAnswer);
	}
}
