package by.ipo.task1.view.ru;

/**
 * This class provides method for providing information to user.
 * @author Pavel Isidovich
 *
 */
public class UTFSymbolSearchAnswer {
	
private static UTFSymbolSearchAnswer instance;
	
	private UTFSymbolSearchAnswer() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of the object.
	 */
	public static UTFSymbolSearchAnswer getInstance() {
		if (instance == null) {
			instance = new UTFSymbolSearchAnswer();
		}
		return instance;
	}
	
	/**
	 * This method shows answer to user.
	 * @param info - message
	 */
	public void showInfo(char[] ch) {
		System.out.println("Символу " + ch[0] + " соответствует номер " 
				   + (byte) ch[0] + ".\n Следуюий символ " + ch[1] 
				   + ",\n предыдущий " + "символ " + ch[2]);
	}
}
