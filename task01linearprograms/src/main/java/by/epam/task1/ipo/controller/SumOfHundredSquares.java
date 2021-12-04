package by.epam.task1.ipo.controller;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.SumOfSquares;
import by.epam.task1.ipo.view.Viewer;

import java.util.Scanner;

/**
 * This class represents command get sum of square values of given
 * amount of numbers.
 * @author Pavel Isidovich
 *
 */

public class SumOfHundredSquares implements Command {
	
	private Viewer viewer = Viewer.getInstance();

	/**
	 * This method executes given command.
	 */
	
	@Override
	public void execute() {
		SumOfSquares sos = SumOfSquares.getInstance();
		Scanner sc = new Scanner(System.in);
		
		viewer.showInfo("Введите количество чисел");
		viewer.showInfo(sos.getSum(sc.nextLine()));	
	}
}
