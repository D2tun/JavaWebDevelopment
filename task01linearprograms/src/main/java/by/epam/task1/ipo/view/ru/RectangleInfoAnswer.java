package by.ipo.task1.view.ru;

/**
 * This class provides method for providing information to user.
 * @author Pavel Isidovich
 *
 */
public class RectangleInfoAnswer {

	private static RectangleInfoAnswer instance;
	
	private RectangleInfoAnswer() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of the object.
	 */
	public static RectangleInfoAnswer getInstance() {
		if (instance == null) {
			instance = new RectangleInfoAnswer();
		}
		return instance;
	}
	
	/**
	 * This method shows answer to user.
	 * @param info - message
	 */
	public void showInfo(double length, double width, double area) {
		System.out.println("Прямоугольник длиной " + length + " мм, шириной "
				+ width + " мм, площадью " + area + " кв. мм.");
	}
}
