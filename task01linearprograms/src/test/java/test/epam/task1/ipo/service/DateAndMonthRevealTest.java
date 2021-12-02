package test.epam.task1.ipo.service;

import by.epam.task1.ipo.service.DateAndMonthReveal;

import org.testng.Assert;
import org.testng.annotations.*;

public class DateAndMonthRevealTest {

	private DateAndMonthReveal damr = DateAndMonthReveal.getInstance();
	
	@DataProvider(name = "dayOfYearData")
	public Object[][] setData() {
		return new Object[][] {
				{ 1, "1 января" },
				{ 33, "2 февраля"},
				{ 365, "31 декабря" },
				{ 888, "Неверные данные"} };
	}
	
	@Test(description = "Проверка обнаружения числа и месяца", 
		  dataProvider = "dayOfYearData")
	public void getDateAndMonthTest(int day, String expectedAnswer) {
		Assert.assertEquals(damr.getDateAndMonth(day), expectedAnswer);
	}
}
