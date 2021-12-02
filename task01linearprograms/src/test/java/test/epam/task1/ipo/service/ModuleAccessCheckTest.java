package test.epam.task1.ipo.service;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.epam.task1.ipo.service.ModuleAccessCheck;

public class ModuleAccessCheckTest {

	private ModuleAccessCheck mac = ModuleAccessCheck.getInstance();
	
	@DataProvider(name = "baseAccessData")
	public Object[][] setData() {
		return new Object[][] {
								{"9583", "Получен доступ к модулям А, В, С."},
								{"3331", "Получен доступ к модулям В, С."},
								{"8997", "Получен доступ к модулю С."},
								{"354f", "Отказ в доступе."},
							  };
	}
	
	@Test(description = "Проверка выдачи доступа к модулям базы данных",
		  dataProvider = "baseAccessData")
	public void checkAccessTest(String password, String expectedAnswer) {
		Assert.assertEquals(mac.checkAccess(password), expectedAnswer);
	}
}
