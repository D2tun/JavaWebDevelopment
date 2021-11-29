package by.epam.task1.ipo.controller;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.ExpressionCalculation;
import java.util.Scanner;

public class ExpressionModuleCalc implements Command {

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		ExpressionCalculation ec = ExpressionCalculation.getInstance();
		String data;
		
		System.out.println("Введите параметр a");
		data = sc.nextLine();
		double a;
		if (data.matches("^-{0,1}[0-9]+[.,]{0,1}[0-9]{0,}$")) {
			data = data.replace(',', '.');
			a = Double.valueOf(data);
		} else {
			a = Double.NaN;
		}
		
		System.out.println("Введите параметр b");
		data = sc.nextLine();
		double b;
		if (data.matches("^-{0,1}[0-9]+[.,]{0,1}[0-9]{0,}$")) {
			data = data.replace(',', '.');
			b = Double.valueOf(data);
		} else {
			b = Double.NaN;
		}
		
		System.out.println("Введите параметр a");
		data = sc.nextLine();
		double c;
		if (data.matches("^-{0,1}[0-9]+[.,]{0,1}[0-9]{0,}$")) {
			data = data.replace(',', '.');
			c = Double.valueOf(data);
		} else {
			c = Double.NaN;
		}
		
		System.out.println("Введите параметр x");
		data = sc.nextLine();
		double x;
		if (data.matches("^-{0,1}[0-9]+[.,]{0,1}[0-9]{0,}$")) {
			data = data.replace(',', '.');
			x = Double.valueOf(data);
		} else {
			x = Double.NaN;
		}
		
		if (Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c) 
				|| Double.isNaN(x)) {
			System.out.println("Неверные данные.");
		} else {
			System.out.println(ec.calculateSquareExpressionAbs(a, b, c, x));
		}
	}

}
