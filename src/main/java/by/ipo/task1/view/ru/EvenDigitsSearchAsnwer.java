package by.ipo.task1.view.ru;

/**
 * This class provides method for providing information to user.
 * @author Pavel Isidovich
 *
 */
public class EvenDigitsSearchAsnwer {
	
private static EvenDigitsSearchAsnwer instance;
	
	private EvenDigitsSearchAsnwer() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of the object.
	 */
	public static EvenDigitsSearchAsnwer getInstance() {
		if (instance == null) {
			instance = new EvenDigitsSearchAsnwer();
		}
		return instance;
	}
	
	public void showInfo(int evenNumQuantity) {
		System.out.println("Чётных цифер в числе: " + evenNumQuantity);
	}
}
