package by.epam.task1.ipo.service;

public class FirstFunctionBuilder {
	
	private static FirstFunctionBuilder instance;
	
	private FirstFunctionBuilder() {
		
	}
	
	public static FirstFunctionBuilder getInstance() {
		if (instance == null) {
			instance = new FirstFunctionBuilder();
		}
		return instance;
	}
	
	public String getCoordinates(double a, double b, double h) {
		String answer = "x    y\n";
		do {
			if (a > 2) {
				answer += a + "    " + a + "\n";
			} else {
				answer += a + "    " + (a * -1) + "\n";
			}
			a += h;
		} while (a <= b); 
		return answer;
	}
}
