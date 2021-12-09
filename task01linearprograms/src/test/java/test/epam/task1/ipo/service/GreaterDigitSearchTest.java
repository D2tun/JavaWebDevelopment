package test.ipo.task1.service;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import by.ipo.task1.service.GreaterDigitSearch;

public class GreaterDigitSearchTest {
	
	GreaterDigitSearch gds = GreaterDigitSearch.getInstance();
	
	@DataProvider(name = "digitsData")
	public Object[][] setData() {
		return new Object[][] {
								{123, 3}, {9146, 9}
							  };
	}
	
	@DataProvider(name = "digitsWrongData")
	public Object[][] setWrongData() {
		return new Object[][] {
								{-914, new IOException()},
								{0, new IOException()},
							  };
	}
	
	@Test(description = "Проверка поиска наибольшей цифры в числе",
		  dataProvider = "digitsData")
	public void getGreaterDigit(int num, int expectedAnswer) 
			throws IOException {
		Assert.assertEquals(gds.getGreaterDigit(num), expectedAnswer);
	}
	
	@Test(description = "Проверка поиска наибольшей цифры в числе",
			 dataProvider = "digitsWrongData",
			 expectedExceptions = IOException.class)
	public void getGreaterDigit(int num, IOException expectedAnswer) 
			throws IOException {
		Assert.assertEquals(gds.getGreaterDigit(num), expectedAnswer);
	}
}
