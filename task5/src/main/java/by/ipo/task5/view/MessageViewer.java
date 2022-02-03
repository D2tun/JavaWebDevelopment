package by.ipo.task5.view;

import java.util.Scanner;

import by.ipo.task5.bean.Array;
import by.ipo.task5.bean.Matrix;

/**
 * This class provides method for providing information to user.
 * @author Pavel Isidovich
 *
 */
public class MessageViewer {

	private static MessageViewer instance;
	
	private String data;
	
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
	 * This method prints matrix to console
	 * @param matrix - matrix, that will be printed
	 */
	public void showMatrix(Matrix matrix) {
		String answer = "";
		
		for (int row = 0; row < matrix.getColumnLength(); ++row) {
			for (int column = 0; column < matrix.getRowLength(); ++column) {
				answer += matrix.getElement(row, column) + " ";
			}
			answer += "\n";
		}
		
		System.out.println(answer);
	}
	
	/**
	 * This method prints array to console
	 * @param array - array, that will be printed
	 */
	public void showArray(Array array) {
		String answer = "";
		
		for (int i = 0; i < array.getLength(); ++i) {
			answer += String.valueOf(array.getElement(i)) + " ";
		}
		
		System.out.println(answer);
	}
	
	/**
	 * This method requests information from user.
	 * @param message - information request
	 * @return string, entered by user
	 */
	public String dataRequest(String message) {
		
		return this.data;
	}
	
	void setData(String data) {
		this.data = data;
	}
	
	/*public String dataRequest(String message) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(message);
		
		return sc.nextLine();
	}*/
}