package by.ipo.task1.view.ru;

/**
 * This class provides method for providing information to user.
 * @author Pavel Isidovich
 *
 */
public class SquareExpressionAbsAnswer {
	
	private static SquareExpressionAbsAnswer instance;
	
	private SquareExpressionAbsAnswer() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of the bject.
	 */
	public static SquareExpressionAbsAnswer getInstance() {
		if (instance == null) {
			instance = new SquareExpressionAbsAnswer();
		}
		return instance;
	}
	
		/**
		 * This method shows answer to user.
		 * @param info - message
		 */
		public void showInfo(double a, double b, double c, double x,
							 double result) {
			System.out.println("|" + a + " * " + x + " * " + x + " + " + b 
								+ " * " + x + " + " + c + "| = " + result);
		}
}
