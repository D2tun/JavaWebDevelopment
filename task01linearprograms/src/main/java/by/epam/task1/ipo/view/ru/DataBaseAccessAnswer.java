package by.ipo.task1.view.ru;

/**
 * This class provides method for providing information to user.
 * @author Pavel Isidovich
 *
 */
public class DataBaseAccessAnswer {
	
	private static DataBaseAccessAnswer instance;
	
	private DataBaseAccessAnswer() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of the object.
	 */
	public static DataBaseAccessAnswer getInstance() {
		if (instance == null) {
			instance = new DataBaseAccessAnswer();
		}
		return instance;
	}
	
	
	public void showInfo(int accessLevel) {
		switch (accessLevel) {
		case 3:
			System.out.println("Получен доступ к модулям А, В, С.");
			break;
		case 2:
			System.out.println("Получен доступ к модулям В, С.");
			break;
		case 1:
			System.out.println("Получен доступ к модулям С.");
			break;
		default:
			System.out.println("Отказ в доступе.");
			break;
		}
	}
}
