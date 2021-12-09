package by.ipo.task1.view.ru;

/**
 * This class provides method for providing information to user.
 * @author Pavel Isidovich
 *
 */
public class SecondFunctionAnswer {

	private static SecondFunctionAnswer instance;
	
	private SecondFunctionAnswer() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of the object.
	 */
	public static SecondFunctionAnswer getInstance() {
		if (instance == null) {
			instance = new SecondFunctionAnswer();
		}
		return instance;
	}
	
	/**
	 * This method shows answer to user.
	 * @param info - message
	 */
	public void showInfo(double[][] dots) {
		String answer = "x    y\n";
		
		for (int i = 0; i < dots.length; ++i) {
			answer += dots[i][0] + "    " + dots[i][1] + "\n";
		}
		System.out.println(answer);
	}
}
