package by.epam.task1.ipo.service;

public class SumOfSquares {
	
	private static SumOfSquares instance;
	
	private SumOfSquares() {
		
	}
	
	public static SumOfSquares getInstance() {
		if (instance == null) {
			instance = new SumOfSquares();
		}
		return instance;
	}
	
	public String getSum() {
		int result = 0;
		
		for (int i = 1; i < 101; i++) {
			result += i * i;
		}
		
		return "Сумма квадратов первых ста чисел: " + result;
	}

}
