package test.epam.task1.ipo.service;

import by.epam.task1.ipo.service.DateAndMonthReveal;

import org.testng.Assert;
import org.testng.annotations.*;

public class DateAndMonthRevealTest {

	private DateAndMonthReveal damr = DateAndMonthReveal.getInstance();
	
	@Test(description = "Проверка обнаружения числа и месяца")
	public void getDateAndMonthTest() {
		String expectedAnswer = "7 марта";
		Assert.assertEquals(damr.getDateAndMonth(66), expectedAnswer);
	}
}
