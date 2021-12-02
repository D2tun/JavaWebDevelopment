package test.epam.task1.ipo.service;

import by.epam.task1.ipo.service.DecimalNumTurner;

import org.testng.Assert;
import org.testng.annotations.*;

public class DecimalNumTurnerTest {

	private DecimalNumTurner dmt = DecimalNumTurner.getInstance();
	
	@DataProvider(name = "numberTurnData")
	public Object[][] setData() {
		return new Object[][] {
				{ 111.222, "Число 111.222 стало 222.111" },
				{ 333.888, "Число 333.888 стало 888.333" } };
	}
	
	@Test(description = "Проверка переворота чисел", 
		  dataProvider = "numberTurnData")
	public void turnTest(double num, String expectedAnswer) {
		Assert.assertEquals(dmt.turn(num), expectedAnswer);
	}
}
