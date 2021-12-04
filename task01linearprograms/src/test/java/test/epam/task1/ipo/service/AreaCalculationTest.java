package test.epam.task1.ipo.service;

import by.epam.task1.ipo.service.AreaCalculation;

import org.testng.Assert;
import org.testng.annotations.*;

public class AreaCalculationTest {

	private AreaCalculation ac = AreaCalculation.getInstance();

	@DataProvider(name = "dataForRectangleCalc")
	public Object[][] setData() {
		return new Object[][] {
				{ "4", "Прямоугольник длиной 4.0 мм, шириной 2.0 мм, " 
					 + "площадью 8.0 кв. мм." },
				{ "2.2", "Прямоугольник длиной 2.2 мм, шириной 1.1 мм, " 
					   + "площадью 2.42 кв. мм." },
				{ "9,2", "Прямоугольник длиной 9.0 мм, шириной 4.5 мм, " 
					  + "площадью 40.5 кв. мм." },
				{ "gwsg", "Неверные данные"}
					  };
	}

	@Test(description = "Проверка вычисления площади прямоугольника", 
		  dataProvider = "dataForRectangleCalc")
	public void getAnswerTest(String length, String expectedAnswer) {
		Assert.assertEquals(ac.getAnswer(length), expectedAnswer);
	}
}
