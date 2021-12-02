package test.epam.task1.ipo.service;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.epam.task1.ipo.service.SumOfSquares;

public class SumOfSquaresTest {
	
	SumOfSquares sos = SumOfSquares.getInstance();
	
	@DataProvider(name = "buildingData")
	public Object[][] setData() {
		return new Object[][] { {20, "Сумма квадратов первых 20 чисел: 2870"},
								{100, "Сумма квадратов первых 100 чисел: 338350"},
							  };	
	}
	
	@Test(description = "Проверка квадратов первых ста чисел", 
		  dataProvider = "buildingData")
	public void getSumTest(int num, String expectedAnswer) {
		Assert.assertEquals(sos.getSum(num), expectedAnswer);
	}

}
