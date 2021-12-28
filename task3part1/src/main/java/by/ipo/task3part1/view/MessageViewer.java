package by.ipo.task3part1.view;

import java.util.Locale;
import java.util.ResourceBundle;

import by.ipo.task3part1.bean.Derivative;

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
	public void showDerivative(Derivative d) {
		if (d.getDerivative().size() == 0 || d.equals(null)) {
			System.out.println(rb.getString("commitmentNotFound"));
		} else {
			for (int i = 0; i < d.getDerivative().size(); ++i) {
				System.out.println((i + 1) + ") " + rb.getString("cost") + " " 
								  + d.getCommitment(i).getCost() + " " 
								  + rb.getString("riskCoefficient") + " " 
								  + d.getCommitment(i).getRiskCoefficient()); 
			}
		}
	}
}