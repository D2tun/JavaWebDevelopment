package by.epam.task1.ipo.controller;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.SumOfSquares;

import java.util.Scanner;

/**
 * This class represents command get sum of square values of given
 * amount of numbers.
 * @author Pavel Isidovich
 *
 */

public class SumOfHundredSquares implements Command {

	/**
	 * This method executes given command.
	 */
	
	@Override
	public void execute() {
		SumOfSquares sos = SumOfSquares.getInstance();
		Scanner sc = new Scanner(System.in);
		int quantity = 0;
		
		System.out.println("Введите количество чисел");
		String data = sc.nextLine();
		if (data.matches("[0-9]+")) {
			quantity = Integer.valueOf(data);
			System.out.println(sos.getSum(quantity));
		} else {
			System.out.println("Неверные данные");
		}		
	}
}
