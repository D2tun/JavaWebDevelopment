package by.epam.task1.ipo.controller;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.DateAndMonthReveal;
import by.epam.task1.ipo.view.Viewer;

import java.util.Scanner;

/**
 * This class represents command to get date and month. 
 * @author Pavel Isidovich
 *
 */

public class DateAndMonthGuess implements Command {
	
	private Viewer viewer = Viewer.getInstance();
	
	/**
	 * This method executes given command.
	 */

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		DateAndMonthReveal damr = DateAndMonthReveal.getInstance();
		
		viewer.showInfo("Введите номер дня в году (1 - 365)");
		viewer.showInfo(damr.getDateAndMonth(sc.nextLine()));	
	}
}
