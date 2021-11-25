package test.epam.task1.service;

import by.epam.task1.ipo.service.DecimalNumTurner;

import org.testng.Assert;
import org.testng.annotations.*;

public class DecimalNumTurnerTest {

	private DecimalNumTurner dmt = DecimalNumTurner.getInstance();
	
	@Test
	public void turnTest() {
		String expectedAnswer = "Число 111.222 стало 222.111";
		Assert.assertEquals(dmt.turn(111.222), expectedAnswer, "Ответ неверен");
	}
}
