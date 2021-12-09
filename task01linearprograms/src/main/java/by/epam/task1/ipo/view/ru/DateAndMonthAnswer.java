package by.ipo.task1.view.ru;

/**
 * This class provides method for providing information to user.
 * @author Pavel Isidovich
 *
 */

public class DateAndMonthAnswer {
	
	private static DateAndMonthAnswer instance;
	
	private DateAndMonthAnswer() {
		
	}
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of the object.
	 */
	public static DateAndMonthAnswer getInstance() {
		if (instance == null) {
			instance = new DateAndMonthAnswer();
		}
		return instance;
	}
	
	/**
	 * This method shows answer to user.
	 * @param dateAndMonth - array, where dateAndMonth[0] - number 
	 * of day, dateAndMonth[1] - number of month
	 */
	public void showInfo(int[] dateAndMonth) {
		
		String answer = dateAndMonth[0] + " ";
		
		switch (dateAndMonth[1]) {
		case 1:
			answer += "января";
			break;
		case 2:
			answer += "февраля";
			break;
		case 3:
			answer += "марта";
			break;
		case 4:
			answer += "апреля";
			break;
		case 5:
			answer += "мая";
			break;
		case 6:
			answer += "июня";
			break;
		case 7:
			answer += "июля";
			break;
		case 8:
			answer += "августа";
			break;
		case 9:
			answer += "сентября";
			break;
		case 10:
			answer += "октября";
			break;
		case 11:
			answer += "ноября";
			break;
		case 12:
			answer += "декабря";
			break;
		}
		
		System.out.println(answer);
	}
}
