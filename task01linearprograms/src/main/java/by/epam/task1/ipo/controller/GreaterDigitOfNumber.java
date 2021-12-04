package by.epam.task1.ipo.controller;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.GreaterDigitSearch;
import by.epam.task1.ipo.view.Viewer;

import java.util.Scanner;

/**
 * This class represents command to find greater digit of given number.
 * @author Pavel Isidovich
 *
 */

public class GreaterDigitOfNumber implements Command {

	private Viewer viewer = Viewer.getInstance();
	
	/**
	 * This method executes given command.
	 */
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		GreaterDigitSearch gds = GreaterDigitSearch.getInstance();
		
		viewer.showInfo("Введите натуральное число");
		viewer.showInfo(gds.getGreaterDigit(sc.nextLine()));	
	}
}
