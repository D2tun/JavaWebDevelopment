package test.epam.task1.ipo.service;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.epam.task1.ipo.service.FlatteryPhrase;

public class FlatteryPhraseTest {

	private FlatteryPhrase fp = FlatteryPhrase.getInstance();
	
	@Test(description = "Проверка программы-льстеца")
	public void getPhraseTest() {
		String expectedAnswer = "Мне нравятся мальчики!";
		Assert.assertEquals(fp.getPhrase('М'), expectedAnswer);
	}
	
}
