package by.ipo.task2.view;

/**
 * This class provides method for providing information to user.
 * @author Pavel Isidovich
 *
 */
public class MessageViewer {

	private static MessageViewer instance;
	
	private MessageViewer() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of the object.
	 */
	public static MessageViewer getInstance() {
		if (instance == null) {
			instance = new MessageViewer();
		}
		return instance;
	}
	
	/**
	 * This method shows answer to user.
	 * @param info - message
	 */
	public void showInfo(String info) {
		System.out.println(info);
	}
}