package by.ipo.task1.controller;

import by.ipo.task1.controller.impl.Command;
import by.ipo.task1.service.GreaterDigitSearch;
import by.ipo.task1.view.ru.MessageViewer;
import by.ipo.task1.view.ru.GreaterDigitOfNumberAnswer;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents command to find greater digit of given number.
 * @author Pavel Isidovich
 *
 */

public class GreaterDigitOfNumber implements Command {

	private MessageViewer viewer = MessageViewer.getInstance();
	private GreaterDigitOfNumberAnswer gdona = GreaterDigitOfNumberAnswer
														.getInstance();
	
	/**
	 * This method executes given command.
	 */
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		GreaterDigitSearch gds = GreaterDigitSearch.getInstance();
		
		viewer.showInfo("Введите натуральное число");
		
		try {
			gdona.showInfo(gds.getGreaterDigit(Integer.parseInt(sc.nextLine())));
		} catch (IOException | NumberFormatException e) {
			viewer.showInfo("Неверные данные");
		}
	}
}
