package by.ipo.task1.view.ru;

/**
 * This class provides method for providing information to user.
 * @author Pavel Isidovich
 *
 */
public class SumOfSquaresAnswer {

	private static SumOfSquaresAnswer instance;
	
	private SumOfSquaresAnswer() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of the object.
	 */
	public static SumOfSquaresAnswer getInstance() {
		if (instance == null) {
			instance = new SumOfSquaresAnswer();
		}
		return instance;
	}
	
	/**
	 * This method shows answer to user.
	 * @param quantity - quantity of numbers
	 * @param sum - sum of numbers' squares
	 */
	public void showInfo(int quantity, int sum) {
		System.out.println("Сумма квадратов первых " + quantity + " чисел: " 
						   + sum);
	}
}
