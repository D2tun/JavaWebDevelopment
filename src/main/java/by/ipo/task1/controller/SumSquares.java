package by.ipo.task1.controller;

import by.ipo.task1.controller.impl.Command;
import by.ipo.task1.service.SumOfSquares;
import by.ipo.task1.view.ru.MessageViewer;
import by.ipo.task1.view.ru.SumOfSquaresAnswer;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents command get sum of square values of given
 * amount of numbers.
 * @author Pavel Isidovich
 *
 */
public class SumSquares implements Command {
	
	private MessageViewer viewer = MessageViewer.getInstance();
	private SumOfSquaresAnswer sosa = SumOfSquaresAnswer.getInstance();

	/**
	 * This method executes given command.
	 */
	@Override
	public void execute() {
		SumOfSquares sos = SumOfSquares.getInstance();
		Scanner sc = new Scanner(System.in);
		
		viewer.showInfo("Введите количество чисел");
		
		try {
			int quantity = Integer.parseInt(sc.nextLine());
			sosa.showInfo(quantity, sos.getSum(quantity));
		} catch (IOException | NumberFormatException e) {
			viewer.showInfo("Неверные данные");	
		}	
	}
}
