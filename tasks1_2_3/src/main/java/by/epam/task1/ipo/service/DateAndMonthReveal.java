package by.epam.task1.ipo.service;

public class DateAndMonthReveal {

	private static DateAndMonthReveal instance;
	
	private DateAndMonthReveal() {
		
	}
	
	public static DateAndMonthReveal getInstance() {
		if (instance == null) {
			instance = new DateAndMonthReveal();
		}
		return instance;
	}
	
	public String getDateAndMonth(int dayInYear) {
		if ((dayInYear >= 1) & (dayInYear <= 31)) {
			return dayInYear + " января";
		} else if ((dayInYear >= 32) & (dayInYear <= 59)) {
			dayInYear -= 31;
			return dayInYear + " февраля";
		} else if ((dayInYear >= 60) & (dayInYear <= 90)) {
			dayInYear -= 59;
			return dayInYear + " марта";
		} else if ((dayInYear >= 91) & (dayInYear <= 120)) {
			dayInYear -= 90;
			return dayInYear + " апреля";
		} else if ((dayInYear >= 121) & (dayInYear <= 150)) {
			dayInYear -= 120;
			return dayInYear + " мая";
		} else if ((dayInYear >= 151) & (dayInYear <= 181)) {
			dayInYear -= 150;
			return dayInYear + " июня";
		} else if ((dayInYear >= 182) & (dayInYear <= 211)) {
			dayInYear -= 181;
			return dayInYear + " июля";
		} else if ((dayInYear >= 212) & (dayInYear <= 241)) {
			dayInYear -= 211;
			return dayInYear + " августа";
		} else if ((dayInYear >= 242) & (dayInYear <= 272)) {
			dayInYear -= 241;
			return dayInYear + " сентября";
		} else if ((dayInYear >= 273) & (dayInYear <= 303)) {
			dayInYear -= 272;
			return dayInYear + " октября";
		} else if ((dayInYear >= 304) & (dayInYear <= 333)) {
			dayInYear -= 303;
			return dayInYear + " ноября";
		} else if ((dayInYear >= 334) & (dayInYear <= 365)) {
			dayInYear -= 333;
			return dayInYear + " декабря";
		} else {
			return "Неверные данные";
		}
	}
}
