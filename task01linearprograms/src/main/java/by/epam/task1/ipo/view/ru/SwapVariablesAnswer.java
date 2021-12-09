package by.ipo.task1.view.ru;

/**
 * This class provides method for providing information to user.
 * @author Pavel Isidovich
 *
 */
public class SwapVariablesAnswer {

	private static SwapVariablesAnswer instance;
	
	private SwapVariablesAnswer() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of the object.
	 */
	public static SwapVariablesAnswer getInstance() {
		if (instance == null) {
			instance = new SwapVariablesAnswer();
		}
		return instance;
	}
	
	/**
	 * This method shows answer to user.
	 * @param original - original sequence of variables
	 * @param num - array, where element[0] - changed first variable,
	 * element[1] - changed second variable 
	 */
	public void showInfo(String original, int[] num) {
		System.out.println(original + " => " + num[0] + " " + num[1]);
	}
}
