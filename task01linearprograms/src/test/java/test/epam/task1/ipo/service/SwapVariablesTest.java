package test.ipo.task1.service;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.ipo.task1.service.SwapVariables;

public class SwapVariablesTest {
	
	private SwapVariables sv = SwapVariables.getInstance();
	
	@DataProvider(name = "variables")
	public Object[][] setData() {
		return new Object[][] { 
								{2, 11, new int[] {11, 2}},
								{3, -5, new int[] {-5, 3}},
								{-2, -5, new int[] {-5, -2}},
								{-6, 10, new int[] {10, -6}},
							  };	
	}
	
	@Test(description = "Проверка смены переменных через дополнительную "
					    + "переменную", dataProvider = "variables")
	public void swapFirstWay(int first, int second, int[] expectedAnswer) {
		Assert.assertEquals(sv.swapFirstWay(first, second), expectedAnswer);
	}
	
	@Test(description = "Проверка смены переменных через арифметичесие "
		    + "операции", dataProvider = "variables")
	public void swapSecondWay(int first, int second, int[] expectedAnswer) {
	Assert.assertEquals(sv.swapSecondWay(first, second), expectedAnswer);
	}
	
	@Test(description = "Проверка смены переменных через исключающее "
		    + "ИЛИ", dataProvider = "variables")
	public void swapSecoThirdWay(int first, int second, int[] expectedAnswer) {
	Assert.assertEquals(sv.swapThirdWay(first, second), expectedAnswer);
	}
}
