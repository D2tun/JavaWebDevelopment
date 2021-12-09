package by.ipo.task1.view.ru;

/**
 * This class provides method for providing information to user.
 * @author Pavel Isidovich
 *
 */
public class FirstExpressionAnswer {
	
	private static FirstExpressionAnswer instance;
	
	private FirstExpressionAnswer() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of the object.
	 */
	public static FirstExpressionAnswer getInstance() {
		if (instance == null) {
			instance = new FirstExpressionAnswer();
		}
		return instance;
	}
	
	/**
	 * This method shows answer to user.
	 * @param info - message
	 */
	public void showInfo(double a, double b, double c, double d, 
						 double result) {
		System.out.println(a + " / " + c + " * " + b + " / " +  d + " - ((" 
						  + a + " * " + b + " - " + c + ") / (" + c + " * " 
						  + d + ")) = " + result);
	}
}
