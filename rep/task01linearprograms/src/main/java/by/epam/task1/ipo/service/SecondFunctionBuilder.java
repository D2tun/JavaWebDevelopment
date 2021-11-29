package by.epam.task1.ipo.service;

public class SecondFunctionBuilder {
	
	private static SecondFunctionBuilder instance;
	
	private SecondFunctionBuilder() {
		
	}
	
	public static SecondFunctionBuilder getInstance() {
		if (instance == null) {
			instance = new SecondFunctionBuilder();
		}
		return instance;
	}
	
	public String getCoordinates(double a, double b, double h) {
		String answer = "x    y\n";
		double fx = 0;
		
		do {
			fx = a - StrictMath.sin(a);
			answer += a + "    " + fx + "\n";
			a += h;
		} while (a <= b);
		
		return answer;
	}

}
