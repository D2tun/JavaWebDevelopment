package by.ipo.task3part2.view;

import java.util.Locale;
import java.util.ResourceBundle;

import by.ipo.task3part2.bean.ArtExhibition;

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
	public void showExhibitionInfo(ArtExhibition[] a) {
		for (int i = 0; i < a.length; ++i) {
			System.out.println(rb.getString("exhibition") + " " 
							   + a[i].formatToString());
		}
	}
}