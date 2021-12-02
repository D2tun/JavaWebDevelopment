package by.epam.task1.ipo.controller;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.DecimalNumTurner;

import java.util.Scanner;

/**
 * This class represents command to turn number from nnn.ddd to 
 * ddd.nnn.
 * @author Pavel Isidovich
 *
 */

public class DecimalNumTurn implements Command {
	
	/**
	 * This method executes given command.
	 */

	@Override
	public void execute() {
		DecimalNumTurner dnt = DecimalNumTurner.getInstance();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Введите числов вида nnn.ddd");
		String data = sc.nextLine();
		double d;
		if (data.matches("^[0-9]{3}[.,]{1}[0-9]{3}$")) {
			data = data.replace(',', '.');
			d = Double.valueOf(data);
		} else {
			d = Double.NaN;
		}
		
		if (Double.isNaN(d)) {
			System.out.println("Неверные данные.");
		} else {
			System.out.println(dnt.turn(d));
		}
	}

}
