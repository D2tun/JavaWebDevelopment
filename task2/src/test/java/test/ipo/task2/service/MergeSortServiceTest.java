package test.ipo.task2.service;

import org.testng.Assert;
import org.testng.annotations.*;

import by.ipo.task2.bean.Array;
import by.ipo.task2.service.exception.ServiceException;
import by.ipo.task2.service.impl.MergeSortServiceImpl;

public class MergeSortServiceTest {

private MergeSortServiceImpl mss = new MergeSortServiceImpl();
	
	@Test(description = "Проверка пузырьковой сортировки", 
		  dataProvider = "fileData", 
		  dataProviderClass = DataProviderArray.class)
	public void testBubbleSort(String path, Array<Double> expected) 
			throws ServiceException {
		Assert.assertEquals(mss.sort(path), expected);
	}
}
