package test.epam.task1.ipo.service;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.epam.task1.ipo.service.SwapVariables;

public class SwapVariablesTest {
	
	private SwapVariables sv = SwapVariables.getInstance();
	
	@DataProvider(name = "variables")
	public Object[][] setData() {
		return new Object[][] { 
								{"2 2 2", "2 2 => 2 2"},
								{"3 3 5", "3 5 => 5 3"},
								{"2 3 ", "Неверные данные"},
								{"2 5 4 7", "Неверные данные"},
								{"2 -2 7", "-2 7 => 7 -2"},
								{"цыиика", "Неверные данные"},
								{"1 1.3 1.1", "Неверные данные"},	
							  };	
	}
	
	@Test(description = "Проверка смены переменных через дополнительную "
					    + "переменную", dataProvider = "variables")
	public void swapFirstWay(String data, String expectedAnswer) {
		Assert.assertEquals(sv.swapFirstWay(data), expectedAnswer);
	}
	
	@Test(description = "Проверка смены переменных через арифметичесие "
		    + "операции", dataProvider = "variables")
	public void swapSecondWay(String data, String expectedAnswer) {
	Assert.assertEquals(sv.swapSecondWay(data), expectedAnswer);
	}
	
	@Test(description = "Проверка смены переменных через исключающее "
		    + "ИЛИ", dataProvider = "variables")
	public void swapSecoThirdWay(String data, String expectedAnswer) {
	Assert.assertEquals(sv.swapThirdWay(data), expectedAnswer);
	}
}
