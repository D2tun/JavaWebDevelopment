package test.epam.task1.service;

import by.epam.task1.ipo.service.UTFSymbolSearch;

import org.testng.Assert;
import org.testng.annotations.*;

public class UTFSymbolSearchTest {

	UTFSymbolSearch utfss = UTFSymbolSearch.getInstance();
	
	@Test 
	public void searchSymbolTest() {
		String expectedAnswer = "Символу k соответствует номер 107.\n Следуюий "
							   + "символ l,\n предыдущий " + "символ j";
		Assert.assertEquals(utfss.searchSymbol('k'), expectedAnswer);
	}
	
}
