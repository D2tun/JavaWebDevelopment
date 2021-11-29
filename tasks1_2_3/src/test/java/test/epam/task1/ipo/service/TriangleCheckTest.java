package test.epam.task1.ipo.service;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.epam.task1.ipo.service.TriangleCheck;

public class TriangleCheckTest {
	
	private TriangleCheck tc = TriangleCheck.getInstance();
	
	@Test(description = "Проверка обнаружения равностороннего треугольника")
	public void checkEquilateralityTest() {
		String expectedAnswer = "Это равносторонний треугольник";
		Assert.assertEquals(tc.checkEquilaterality(2, 2, 2), expectedAnswer);
	}
	
}
