package by.epam.task1.ipo.controller;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.SecondFunctionBuilder;

import java.util.Scanner;

public class FunctionFX implements Command {

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		SecondFunctionBuilder sfb = SecondFunctionBuilder.getInstance();
		
		System.out.println("Введите нижний предел счёта");
		String data = sc.nextLine();
		double lowBorder;
		if (data.matches("^-{0,1}[0-9]+[.,]{0,1}[0-9]{0,}$")) {
			data = data.replace(',', '.');
			lowBorder = Double.parseDouble(data);
		} else {
			lowBorder = Double.NaN;
		}
		
		System.out.println("Введите верхний предел счёта");
		data = sc.nextLine();
		double highBorder;
		if (data.matches("^-{0,1}[0-9]+[.,]{0,1}[0-9]{0,}$")) {
			data = data.replace(',', '.');
			highBorder = Double.parseDouble(data);
		} else {
			highBorder = Double.NaN;
		}
		
		if (lowBorder > highBorder) {
			double tmp = highBorder;
			highBorder = lowBorder;
			lowBorder = tmp;
		}
		
		System.out.println("Введите шаг счёта");
		data = sc.nextLine();
		double step;
		if (data.matches("^[0-9]+[.,]{0,1}[0-9]{0,}$")) {
			data = data.replace(',', '.');
			step = Double.parseDouble(data);
		} else {
			step = Double.NaN;
		}
		
		if ((lowBorder == Double.NaN) || (highBorder == Double.NaN) 
				|| (step == Double.NaN)) {
			System.out.println("Неверные данные");
		} else {
			System.out.println(sfb.getCoordinates(lowBorder, highBorder, step));
		}
		
	}

}
