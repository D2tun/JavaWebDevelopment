package test.epam.task1.ipo.service;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.epam.task1.ipo.service.FlatteryPhrase;

public class FlatteryPhraseTest {

	private FlatteryPhrase fp = FlatteryPhrase.getInstance();
	
	@DataProvider(name = "flatteryData")
	public Object[][] setData(){
		return new Object[][] {
								{"М", "Мне нравятся мальчики!"},
								{"Д", "Мне нравятся девочки!"},
								{"agbasb", "Неверные данные"},
							  };
	}
	
	@Test(description = "Проверка программы-льстеца", 
		  dataProvider = "flatteryData")
	public void getPhraseTest(String genderSign, String expectedAnswer) {
		Assert.assertEquals(fp.getPhrase(genderSign), expectedAnswer);
	}
	
}
