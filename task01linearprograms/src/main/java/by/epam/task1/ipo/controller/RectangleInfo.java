package by.epam.task1.ipo.controller;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.AreaCalculation;
import java.util.Scanner;

/**
 * This class represents command to get information about rectangle 
 * with given length.
 * @author Pavel Isidovich
 *
 */

public class RectangleInfo implements Command {

	/**
	 * This method executes given command.
	 */
	
	@Override
	public void execute() {
		AreaCalculation ac = AreaCalculation.getInstance();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Введите длину прямоугольника  (мм)");
		double length = 0;
		String data = sc.nextLine();
		if (data.matches("^[0-9]+[.,]{0,1}[0-9]{0,}$")) {
			data = data.replace(',', '.');
			length = Double.valueOf(data);
		}
		if (length > 0) {
			System.out.println(ac.getAnswer(length));
		} else {
			System.out.println("Неверные данные.");
		}
	}
}
