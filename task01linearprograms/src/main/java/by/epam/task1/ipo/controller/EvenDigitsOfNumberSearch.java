package by.epam.task1.ipo.controller;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.NumberOfEvenDigits;

import java.util.Scanner;

/**
 * This class represents command to get number of even digits in 
 * given number.
 * @author Pavel Isidovich
 *
 */

public class EvenDigitsOfNumberSearch implements Command {

	/**
	 * This method executes given command.
	 */
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		NumberOfEvenDigits noed = NumberOfEvenDigits.getInstance();
		
		System.out.println("Введит натуральное число");
		String data = sc.nextLine();
		if (data.matches("[0-9]+") & !data.matches("0{1}")) {
			System.out.println(noed.getQuantity(data.toCharArray()));
		} else {
			System.out.println("Неверные данные");
		}
		
	}

}
