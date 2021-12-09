package test.ipo.task1.service;

import org.testng.Assert;
import org.testng.annotations.*;

import by.ipo.task1.service.UTFSymbolSearch;

public class UTFSymbolSearchTest {

	private UTFSymbolSearch utfss = UTFSymbolSearch.getInstance();
	
	@DataProvider(name = "charFindData")
	public Object[][] setData() {
		return new Object[][] { 
								{'k', new char[] {'k', 'l', 'j'}},
								{'7', new char[] {'7', '8', '6'}},
							  };	
	}
	
	@Test(description = "Проверка нахождения символа utf8", 
		  dataProvider = "charFindData")
	public void searchSymbolTest(char ch, char[] expectedAnswer) {
		Assert.assertEquals(utfss.searchSymbol(ch), expectedAnswer);
	}
}