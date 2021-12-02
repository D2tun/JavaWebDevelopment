package test.epam.task1.ipo.service;

import by.epam.task1.ipo.service.UTFSymbolSearch;

import org.testng.Assert;
import org.testng.annotations.*;

public class UTFSymbolSearchTest {

	private UTFSymbolSearch utfss = UTFSymbolSearch.getInstance();
	
	@DataProvider(name = "charFindData")
	public Object[][] setData() {
		return new Object[][] { {'k', "Символу k соответствует номер 107.\n "
									  + "Следуюий символ l,\n предыдущий символ "
									  + "j"},
								{'7', "Символу 7 соответствует номер 55.\n "
									  + "Следуюий символ 8,\n предыдущий символ "
									  + "6"},
							  };	
	}
	
	@Test(description = "Проверка нахождения символа utf8", 
		  dataProvider = "charFindData")
	public void searchSymbolTest(char ch, String expectedAnswer) {
		Assert.assertEquals(utfss.searchSymbol(ch), expectedAnswer);
	}
	
}
