package test.ipo.task1.service;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.ipo.task1.service.FlatteryPhrase;

public class FlatteryPhraseTest {

	private FlatteryPhrase fp = FlatteryPhrase.getInstance();
	
	@DataProvider(name = "flatteryData")
	public Object[][] setData(){
		return new Object[][] {
								{"М", "Мне нравятся мальчики!"},
								{"Д", "Мне нравятся девочки!"}
							  };
	}
	
	@DataProvider(name = "flatteryWrongData")
	public Object[][] setWrongData(){
		return new Object[][] {
								{"agbasb", new IOException()},
								{"Н", new IOException()}
							  };
	}
	
	@Test(description = "Проверка программы-льстеца", 
		  dataProvider = "flatteryData")
	public void getPhraseTest(String genderSign, String expectedAnswer) 
				throws IOException {
		Assert.assertEquals(fp.getPhrase(genderSign), expectedAnswer);
	}
	
	@Test(description = "Проверка программы-льстеца", 
			  dataProvider = "flatteryWrongData", 
			  expectedExceptions = IOException.class)
	public void getPhraseWrongTest(String genderSign, IOException expectedAnswer) 
				throws IOException {
		Assert.assertEquals(fp.getPhrase(genderSign), expectedAnswer);
	}
}
