package by.epam.task1.ipo.service;

public class NaturalNumDiv {

	private static NaturalNumDiv instance;
	
	private NaturalNumDiv() {
		
	}
	
	public static NaturalNumDiv getInstance() {
		if (instance == null) {
			instance = new NaturalNumDiv();
		}
		return instance;
	}
	
	public String divide(double m, double n) {
		double divRes = m / n;
		int num = (int) divRes;
		double frac = divRes - num;
		int fracElder = (int) (frac * 10);
		int numYounger = (int) num % 10;
		
		return m + " / " + n + " = " + divRes + "\nСтаршая цифра дробной части " 
			   + fracElder + "\nМладшая цифра целой " + "части " + numYounger;
	}
}
