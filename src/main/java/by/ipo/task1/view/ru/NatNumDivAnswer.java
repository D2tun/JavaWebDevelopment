package by.ipo.task1.view.ru;

/**
 * This class provides method for providing information to user.
 * @author Pavel Isidovich
 *
 */
public class NatNumDivAnswer {

	private static NatNumDivAnswer instance;
	
	private NatNumDivAnswer() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of the object.
	 */
	public static NatNumDivAnswer getInstance() {
		if (instance == null) {
			instance = new NatNumDivAnswer();
		}
		return instance;
	}
	
	/**
	 * This method shows answer to user.
	 * @param result - array, where element[0] - youngest integer 
	 * radix, element[0] - eldest fractional radix
	 */
	public void showInfo(int[] result) {
		System.out.println("Старшая цифра " + "дробной части " + result[1] 
						  + "\nМладшая цифра целой " + "части " + result[0]);
	}
}
