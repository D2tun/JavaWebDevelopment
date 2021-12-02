package by.epam.task1.ipo.controller;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.GreaterDigitSearch;

import java.util.Scanner;

/**
 * This class represents command to find greater digit of given number.
 * @author Pavel Isidovich
 *
 */

public class GreaterDigitOfNumber implements Command {

	/**
	 * This method executes given command.
	 */
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		GreaterDigitSearch gds = GreaterDigitSearch.getInstance();
		
		System.out.println("Введите натуральное число");
		String data = sc.nextLine();
		if (data.matches("[0-9]+") & !data.matches("0{1}")) {
			System.out.println(gds.getGreaterDigit(data.toCharArray()));
		} else {
			System.out.println("Неверные данные");
		}
		
	}

}
