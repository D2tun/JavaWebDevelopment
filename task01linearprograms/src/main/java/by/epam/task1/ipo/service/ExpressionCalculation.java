package by.epam.task1.ipo.service;

public class ExpressionCalculation {

	private static ExpressionCalculation instance;
	
	private ExpressionCalculation() {
		
	}
	
	public static ExpressionCalculation getInstance() {
		if (instance == null) {
			instance = new ExpressionCalculation();
		}
		return instance;
	}
	
	public String calculateFirstExpression(double a, double b, double c, 
										   double d) {
		return a + " / " + c + " * " + b + " / " +  d + " - ((" + a + " * " 
			   + b + " - " + c + ") / (" + c + " * " + d + ")) = " + (a / c 
			   * b / d - ((a * b - c) / (c * d)));
	}
}
