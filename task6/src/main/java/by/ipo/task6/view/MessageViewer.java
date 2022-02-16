package by.ipo.task6.view;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * This class provides method for providing information to user.
 * @author Pavel Isidovich
 *
 */
public class MessageViewer {

	private ResourceBundle rb = ResourceBundle.getBundle("view", 
			   											 Locale.getDefault());
	
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
	
	/**
	 * This method shows answer to user.
	 * @param info - message
	 */
	public String makeRequest(String message) {
		System.out.println(message);
		return new Scanner(System.in).nextLine();
	}
}