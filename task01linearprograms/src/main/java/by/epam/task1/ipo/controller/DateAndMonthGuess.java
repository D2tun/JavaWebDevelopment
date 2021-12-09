package by.ipo.task1.controller;

import by.ipo.task1.controller.impl.Command;
import by.ipo.task1.service.DateAndMonthReveal;
import by.ipo.task1.view.ru.MessageViewer;
import by.ipo.task1.view.ru.DateAndMonthAnswer;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents command to get date and month. 
 * @author Pavel Isidovich
 *
 */

public class DateAndMonthGuess implements Command {
	
	private MessageViewer viewer = MessageViewer.getInstance();
	private DateAndMonthAnswer dama = DateAndMonthAnswer.getInstance();
	
	/**
	 * This method executes given command.
	 */
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		DateAndMonthReveal damr = DateAndMonthReveal.getInstance();
		
		viewer.showInfo("Введите номер дня в году (1 - 365)");
		
		try {
			int data = Integer.parseInt(sc.nextLine());
			dama.showInfo(damr.getDateAndMonth(data));	
		} catch (IOException | NumberFormatException e) {
			viewer.showInfo("Неверные данные");
		}
	}
}
