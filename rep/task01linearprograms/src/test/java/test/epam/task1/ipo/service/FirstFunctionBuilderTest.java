package test.epam.task1.ipo.service;

import by.epam.task1.ipo.service.FirstFunctionBuilder;

import org.testng.Assert;
import org.testng.annotations.*;

public class FirstFunctionBuilderTest {
	
	private FirstFunctionBuilder bff = FirstFunctionBuilder.getInstance();
	
	@Test(description = "Проверка построения функции 1")
	public void getCoordinatesTest() {
		String expectedAnswer = "x    y\n1.0    -1.0\n2.0    -2.0\n3.0    3.0\n";
		Assert.assertEquals(bff.getCoordinates(1, 3, 1), expectedAnswer);
	}

}
