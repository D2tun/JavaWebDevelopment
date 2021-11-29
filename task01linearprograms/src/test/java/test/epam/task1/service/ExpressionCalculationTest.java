package test.epam.task1.service;

import by.epam.task1.ipo.service.ExpressionCalculation;

import org.testng.Assert;
import org.testng.annotations.*;

public class ExpressionCalculationTest {

	private ExpressionCalculation ec = ExpressionCalculation.getInstance();
	
	@Test
	public void calculateFirstExpressionTest() {
		String expectedAnswer = "2.0 / 2.0 * 2.0 / 2.0 - ((2.0 * 2.0 - 2.0) / "
				+ "(2.0 * 2.0)) = 0.5";
		Assert.assertEquals(ec.calculateFirstExpression(2, 2, 2, 2), 
							expectedAnswer);
	}
}
