package test.ipo.task2.service;

import org.testng.Assert;
import org.testng.annotations.*;

import by.ipo.task2.bean.Array;
import by.ipo.task2.service.exception.ServiceException;
import by.ipo.task2.service.impl.BubbleSortServiceImpl;

public class BubbleSortServiceTest {

	private BubbleSortServiceImpl bss = new BubbleSortServiceImpl();
	
	@Test(description = "Проверка пузырьковой сортировки", dataProvider = "fileData", dataProviderClass = DataProviderArray.class)
	public void testBubbleSort(String path, Array<Double> expected) throws ServiceException {
		Assert.assertEquals(bss.sort(path), expected);
	}
}
