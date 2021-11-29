package test.epam.task1.ipo.service;

import by.epam.task1.ipo.service.AreaCalculation;

import org.testng.Assert;
import org.testng.annotations.*;

public class AreaCalculationTest {

	private AreaCalculation ac = AreaCalculation.getInstance();
	
	/*@DataProvider(name = "dataForRectangleCalc") 
	public List<Double>[] dataForRectangle() {
		return new Object[][] {
			{new double[] {4}, new String[] {"Прямоугольник длиной 4.0 мм, "
							   + "шириной 2.0 мм, площадью 8.0 кв. мм."},
			 new double[] {2.24}, new String[] {"Прямоугольник длиной 2.24 мм, "
					   + "шириной 1.12 мм, площадью 2.5088 кв. мм."}
			}
		};
	}
	
	
	@Test(dataProvider = "dataForRectangleCalc", 
		  description = "Проверка вычисления прямоугольника")
	public void getAnswerTest(double length, String expectedAnswer) {
		String answer = "Прямоугольник длиной " + length + " мм, "
								+ "шириной " + (length / 2) + " мм, площадью "
								+ (length * length/2) + " кв. мм.";	
		Assert.assertEquals(ac.getAnswer(length), expectedAnswer);	
	}
	*/
	@Test
	public void getAnswerTest() {
		String expectedAnswer = "Прямоугольник длиной 4.0 мм, "
								+ "шириной 2.0 мм, площадью 8.0 кв. мм.";	
		Assert.assertEquals(ac.getAnswer(4), expectedAnswer);	
	}
}
