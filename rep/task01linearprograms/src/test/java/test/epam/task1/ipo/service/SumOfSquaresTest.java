package test.epam.task1.ipo.service;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.epam.task1.ipo.service.SumOfSquares;

public class SumOfSquaresTest {
	
	SumOfSquares sos = SumOfSquares.getInstance();
	
	@Test(description = "Проверка квадратов первых ста чисел")
	public void getSumTest() {
		String expectedAnswer = "Сумма квадратов первых ста чисел: 338350";
		Assert.assertEquals(sos.getSum(), expectedAnswer);
	}

}
