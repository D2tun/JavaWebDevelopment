package by.epam.task1.ipo.service;

public class NumberOfEvenDigits {

	private static NumberOfEvenDigits instance;

	private NumberOfEvenDigits() {

	}

	public static NumberOfEvenDigits getInstance() {
		if (instance == null) {
			instance = new NumberOfEvenDigits();
		}
		return instance;
	}

	public String getQuantity(char[] digits) {
		String answer = "Чётные цифры числа: ";
		
		for (int i = 0; i < digits.length; i++) {
			if (Integer.valueOf(digits[i]) % 2 == 0) {
				answer += (digits[i]) + ", ";
			}
		}
		
		answer = answer.trim();
		
		StringBuilder cut = new StringBuilder(answer);
		answer = cut.deleteCharAt(answer.length() - 1).toString();
		return answer;
	}
}
