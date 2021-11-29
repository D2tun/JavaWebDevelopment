package test.epam.task1.ipo.service;

import by.epam.task1.ipo.service.NaturalNumDiv;

import org.testng.Assert;
import org.testng.annotations.*;

public class NaturalNumDivTest {

	private NaturalNumDiv nnd = NaturalNumDiv.getInstance();
	
	@Test
	public void divideTest() {
		String expectedAnswer = "9000 / 7 = 1285.7142857142858\nСтаршая цифра "
				+ "дробной части 7\nМладшая цифра целой части 5";
		Assert.assertEquals(nnd.divide(9000, 7), expectedAnswer);
	}
	
}
