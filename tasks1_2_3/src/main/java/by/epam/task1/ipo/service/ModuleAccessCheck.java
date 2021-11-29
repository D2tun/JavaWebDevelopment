package by.epam.task1.ipo.service;

public class ModuleAccessCheck {
	
	private static ModuleAccessCheck instance;
	
	private ModuleAccessCheck() {
		
	}
	
	public static ModuleAccessCheck getInstance() {
		if (instance == null) {
			instance = new ModuleAccessCheck();
		}
		return instance;
	}
	
	public String checkAccess(String password) {
		if (password.matches("^9583$") | password.matches("^1747$")) {
			return "Получен доступ к модулям А, В, С.";
		} else if (password.matches("^3331$") | password.matches("^7922$")) {
			return "Получен доступ к модулям В, С.";
		} else if (password.matches("^9455$") | password.matches("^8997$")) {
			return "Получен доступ к модулю С.";
		} else {
			return "Отказ в доступе.";
		}
	}

}
