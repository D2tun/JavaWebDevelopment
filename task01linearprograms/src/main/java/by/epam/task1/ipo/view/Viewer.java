package by.epam.task1.ipo.view;

/**
 * This class provides method for providing information to user.
 * @author Pavel Isidovich
 *
 */
public class Viewer {

	private static Viewer instance;
	
	private Viewer() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of object.
	 */
	public static Viewer getInstance() {
		if (instance == null) {
			instance = new Viewer();
		}
		return instance;
	}
	
	public void showInfo(String info) {
		System.out.println(info);
	}
	
}
