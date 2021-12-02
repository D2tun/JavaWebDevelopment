package test.epam.task1.ipo.service;

import by.epam.task1.ipo.service.ExpressionCalculation;

import org.testng.Assert;
import org.testng.annotations.*;

public class ExpressionCalculationTest {

	private ExpressionCalculation ec = ExpressionCalculation.getInstance();
	
	@DataProvider(name = "expressionData")
	public Object[][] setData(){
		return new Object[][] {
			{ 2, 2, 2, 2, "2.0 / 2.0 * 2.0 / 2.0 - ((2.0 * 2.0 - 2.0) / "
						  + "(2.0 * 2.0)) = 0.5",
			  "|2.0 * 2.0 * 2.0 + 2.0 * 2.0 + 2.0| = 14.0"},
			{ -2, 2, -2, 2, "-2.0 / -2.0 * 2.0 / 2.0 - ((-2.0 * 2.0 - -2.0) / "
							+ "(-2.0 * 2.0)) = 0.5",
			  "|-2.0 * 2.0 * 2.0 + 2.0 * 2.0 + -2.0| = 6.0"},
			{ -4.5, 2.2, -1.3, 8.8, "-4.5 / -1.3 * 2.2 / 8.8 - "
									+ "((-4.5 * 2.2 - -1.3) / (-1.3 * 8.8)) "
									+ "= 0.11363636363636365",
			  "|-4.5 * 8.8 * 8.8 + 2.2 * 8.8 + -1.3| = 330.42"} };
	}
	
	@Test(description = "Проверка вычисления формулы", 
		  dataProvider = "expressionData")
	public void calculateFirstExpressionTest(double a, double b, double c, 
											 double d, String expectedAnswer,
											 String expectedAnswer2) {
		Assert.assertEquals(ec.calculateFirstExpression(a, b, c, d), 
							expectedAnswer);
	}
	
	@Test(description = "Проверка вычисления квадратичной формулы", 
						dataProvider = "expressionData")
	public void calculateSquareExpressionAbsTest(double a, double b, double c, 
			 									 double d, 
			 									 String expectedAnswer,
			 									 String expectedAnswer2) {
		Assert.assertEquals(ec.calculateSquareExpressionAbs(a, b, c, d), 
							expectedAnswer2);
	}
}
