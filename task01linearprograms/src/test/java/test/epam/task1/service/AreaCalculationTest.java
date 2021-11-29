package test.epam.task1.service;

import by.epam.task1.ipo.service.AreaCalculation;

import org.testng.Assert;
import org.testng.annotations.*;

public class AreaCalculationTest {

	private AreaCalculation ac = AreaCalculation.getInstance();
	
	@Test
	public void getAnswerTest() {
		String expectedAnswer = "Прямоугольник длиной 4.0 мм, "
								+ "шириной 2.0 мм, площадью 8.0 кв. мм.";	
		Assert.assertEquals(ac.getAnswer(4), expectedAnswer, "Ответ неверен");	
	}
}
