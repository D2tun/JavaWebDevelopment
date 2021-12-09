package by.ipo.task1.view.ru;

/**
 * This class provides method for providing information to user.
 * @author Pavel Isidovich
 *
 */
public class GreaterDigitOfNumberAnswer {

private static GreaterDigitOfNumberAnswer instance;
	
	private GreaterDigitOfNumberAnswer() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of the object.
	 */
	public static GreaterDigitOfNumberAnswer getInstance() {
		if (instance == null) {
			instance = new GreaterDigitOfNumberAnswer();
		}
		return instance;
	}
	
	/**
	 * This method shows answer to user.
	 * @param info - message
	 */
	public void showInfo(int digit) {
		System.out.println("Наибольшая цифра числа: " + digit);
	}
}
