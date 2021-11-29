package by.epam.task1.ipo.service;

public class GreaterDigitSearch {
	
	private static GreaterDigitSearch instance;
	
	private GreaterDigitSearch() {
		
	}
	
	public static GreaterDigitSearch getInstance() {
		if (instance == null) {
			instance = new GreaterDigitSearch();
		}
		return instance;
	}
	
	public String getGreaterDigit(char[] digits) {
		char greaterDigit = 0;

		for (int i = 0; i < digits.length; i++) {
			if (Integer.valueOf(digits[i]) > greaterDigit) {
				greaterDigit = digits[i];
			}
		}
		
		return "Наибольшая цифра числа: " + greaterDigit; 
	}

}
