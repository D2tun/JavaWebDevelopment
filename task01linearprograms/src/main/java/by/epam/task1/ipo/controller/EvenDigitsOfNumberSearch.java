package by.epam.task1.ipo.controller;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.NumberOfEvenDigits;
import by.epam.task1.ipo.view.Viewer;

import java.util.Scanner;

/**
 * This class represents command to get number of even digits in 
 * given number.
 * @author Pavel Isidovich
 *
 */

public class EvenDigitsOfNumberSearch implements Command {
	
	private Viewer viewer = Viewer.getInstance();

	/**
	 * This method executes given command.
	 */
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		NumberOfEvenDigits noed = NumberOfEvenDigits.getInstance();
		
		viewer.showInfo("Введите натуральное число");
		viewer.showInfo(noed.getQuantity(sc.nextLine()));	
	}
}
