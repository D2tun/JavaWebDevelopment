package by.ipo.task1.view.ru;

/**
 * This class provides method for providing information to user.
 * @author Pavel Isidovich
 *
 */
public class DecimalNumTurnAnswer {
	
	private static DecimalNumTurnAnswer instance;
	
	private DecimalNumTurnAnswer() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of the object.
	 */
	public static DecimalNumTurnAnswer getInstance() {
		if (instance == null) {
			instance = new DecimalNumTurnAnswer();
		}
		return instance;
	}
	
	/**
	 * This method shows answer to user.
	 * @param num - array, where num[0] - original number, num[1] - 
	 * changed number
	 */
	public void showInfo(double num[]) {
		System.out.println("Число " + num[0] + " стало " + num[1]);
	}
}
