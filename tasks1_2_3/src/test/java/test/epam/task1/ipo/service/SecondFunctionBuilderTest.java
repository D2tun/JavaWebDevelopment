package test.epam.task1.ipo.service;

import by.epam.task1.ipo.service.SecondFunctionBuilder;

import org.testng.Assert;
import org.testng.annotations.*;

public class SecondFunctionBuilderTest {
	
	private SecondFunctionBuilder sfb = SecondFunctionBuilder.getInstance();

	@Test(description = "Проверка построения F(x) = x - sin(x)")
	public void getCoordinates() {
		String expectedAnswer = "x    y\n1.0    0.1585290151921035\n2.0    "
								+ "1.0907025731743183\n3.0    "
								+ "2.8588799919401326\n";
		Assert.assertEquals(sfb.getCoordinates(1, 3, 1), expectedAnswer);
	}
	
}
