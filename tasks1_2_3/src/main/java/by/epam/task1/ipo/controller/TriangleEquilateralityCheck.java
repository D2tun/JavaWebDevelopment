package by.epam.task1.ipo.controller;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.TriangleCheck;

import java.util.Scanner;

public class TriangleEquilateralityCheck implements Command {

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		TriangleCheck tc = TriangleCheck.getInstance();
		
		System.out.println("Введите длину первой стороны треугольника  (мм)");
		double side1 = 0;
		String data = sc.nextLine();
		if (data.matches("^[0-9]+[.,]{0,1}[0-9]{0,}$")) {
			data = data.replace(',', '.');
			side1 = Double.valueOf(data);
		}
		
		System.out.println("Введите длину второй стороны треугольника  (мм)");
		double side2 = 0;
		data = sc.nextLine();
		if (data.matches("^[0-9]+[.,]{0,1}[0-9]{0,}$")) {
			data = data.replace(',', '.');
			side2 = Double.valueOf(data);
		}
		
		System.out.println("Введите длину первой стороны треугольника  (мм)");
		double side3 = 0;
		data = sc.nextLine();
		if (data.matches("^[0-9]+[.,]{0,1}[0-9]{0,}$")) {
			data = data.replace(',', '.');
			side3 = Double.valueOf(data);
		}
		
		if ((side1 == 0) || (side2 == 0) || (side3 == 0)) {
			System.out.println("Неврные данные");
		} else {
			System.out.println(tc.checkEquilaterality(side1, side2, side3));
		}
	}

}
