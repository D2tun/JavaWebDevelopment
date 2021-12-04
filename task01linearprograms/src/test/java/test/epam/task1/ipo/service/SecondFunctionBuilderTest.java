package test.epam.task1.ipo.service;

import by.epam.task1.ipo.service.SecondFunctionBuilder;

import org.testng.Assert;
import org.testng.annotations.*;

public class SecondFunctionBuilderTest {
	
	private SecondFunctionBuilder sfb = SecondFunctionBuilder.getInstance();

	@DataProvider(name = "buildingData")
	public Object[][] setData() {
		return new Object[][] { {"1 3 1", "x    y\n1.0    0.1585290151921035\n2.0"
										  + "    1.0907025731743183\n3.0    "
										  + "2.8588799919401326\n"},
								{"-9,8 1.4 3.1", "x    y\n-9.8    "
												  + "-10.166479129251929\n"
												  + "-6.700000000000001    "
												  + "-6.295150079383402\n"
												  + "-3.600000000000001    "
												  + "-4.042520443294854\n"
												  + "-0.5000000000000009    "
												  + "-0.020574461395797106\n"},
								{"-9,8 1.4 3.1 4 5", "Неверные данные"},
								{"-9,8 1.4", "Неверные данные"},
								{"цикк", "Неверные данные"},
							  };	
	}
	
	@Test(description = "Проверка построения F(x) = x - sin(x)", 
						dataProvider = "buildingData")
	public void getCoordinates(String data, String expectedAnswer) {
		Assert.assertEquals(sfb.getCoordinates(data), expectedAnswer);
	}
}
