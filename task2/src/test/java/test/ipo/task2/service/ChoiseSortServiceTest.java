package test.ipo.task2.service;

import org.testng.Assert;
import org.testng.annotations.*;

import by.ipo.task2.bean.Array;
import by.ipo.task2.service.exception.ServiceException;
import by.ipo.task2.service.impl.ChoiceSortServiceImpl;

public class ChoiseSortServiceTest {
	
	private ChoiceSortServiceImpl css = new ChoiceSortServiceImpl();
	
	@Test(description = "Проверка пузырьковой сортировки", 
		  dataProvider = "fileData",
		  dataProviderClass = DataProviderArray.class)
	public void testBubbleSort(String path, Array<Double> expected) 
			throws ServiceException {
		Assert.assertEquals(css.sort(path), expected);
	}

}
