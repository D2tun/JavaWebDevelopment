package by.ipo.task1.controller;

import by.ipo.task1.controller.impl.Command;
import by.ipo.task1.service.NumberOfEvenDigits;
import by.ipo.task1.view.ru.MessageViewer;
import by.ipo.task1.view.ru.EvenDigitsSearchAsnwer;

import java.util.Scanner;

/**
 * This class represents command to get number of even digits in 
 * given number.
 * @author Pavel Isidovich
 *
 */

public class EvenDigitsOfNumberSearch implements Command {
	
	private MessageViewer viewer = MessageViewer.getInstance();
	private EvenDigitsSearchAsnwer edsa = EvenDigitsSearchAsnwer.getInstance();

	/**
	 * This method executes given command.
	 */
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		NumberOfEvenDigits noed = NumberOfEvenDigits.getInstance();
		
		viewer.showInfo("Введите натуральное число");
		
		try {
			int num = Integer.parseInt(sc.nextLine());
			edsa.showInfo(noed.getQuantity(num));
		} catch (NumberFormatException e) {
			viewer.showInfo("Неверные данные");
		}
	}
}
