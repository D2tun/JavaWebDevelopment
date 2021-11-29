package test.epam.task1.ipo.service;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.epam.task1.ipo.service.ModuleAccessCheck;

public class ModuleAccessCheckTest {

	private ModuleAccessCheck mac = ModuleAccessCheck.getInstance();
	
	@Test(description = "Проверка выдачи доступа к модулям базы данных")
	public void checkAccessTest() {
		String expectedAnswer = "Получен доступ к модулю С.";
		Assert.assertEquals(mac.checkAccess("8997"), expectedAnswer);
	}
}
