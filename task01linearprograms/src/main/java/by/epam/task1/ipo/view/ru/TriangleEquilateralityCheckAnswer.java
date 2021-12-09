package by.ipo.task1.view.ru;

/**
 * This class provides method for providing information to user.
 * @author Pavel Isidovich
 *
 */
public class TriangleEquilateralityCheckAnswer {

	private static TriangleEquilateralityCheckAnswer instance;
	
	private TriangleEquilateralityCheckAnswer() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of the object.
	 */
	public static TriangleEquilateralityCheckAnswer getInstance() {
		if (instance == null) {
			instance = new TriangleEquilateralityCheckAnswer();
		}
		return instance;
	}
	
	/**
	 * This method shows answer to user.
	 * @param isEquilateral - isEquilaterality of triangle
	 */
	public void showInfo(boolean isEquilateral) {
		if (isEquilateral) {
			System.out.println("Треугольник равносторонний");
		} else {
			System.out.println("Треугольник не равносторонний");
		}
	}
}
