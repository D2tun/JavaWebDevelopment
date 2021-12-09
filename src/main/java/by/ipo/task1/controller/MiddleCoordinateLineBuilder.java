package by.ipo.task1.controller;

import by.ipo.task1.controller.impl.Command;
import by.ipo.task1.service.FirstFunctionBuilder;
import by.ipo.task1.view.ru.MessageViewer;
import by.ipo.task1.view.ru.FirstFunctionAnswer;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents command to get dots of line.
 * @author Pavel Isidovich
 *
 */

public class MiddleCoordinateLineBuilder implements Command {
	
	private MessageViewer viewer = MessageViewer.getInstance();
	private FirstFunctionAnswer ffa = FirstFunctionAnswer.getInstance();

	/**
	 * This method executes given command.
	 */
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		FirstFunctionBuilder bff = FirstFunctionBuilder.getInstance();
		
		viewer.showInfo("Введите нижний предел счёта, верхний предел счёта и "
				+ "шаг через пробел");
		
		String[] parsedData = sc.nextLine().split(" ");
		
		try {
			if (parsedData.length != 3) {
				throw new IOException();
			}
			double lowLimit = Double.parseDouble(parsedData[0]);
			double highLimit = Double.parseDouble(parsedData[1]);
			double step = Double.parseDouble(parsedData[2]);
			ffa.showInfo(bff.getCoordinates(lowLimit, highLimit,step));
		} catch (IOException | NumberFormatException e) {
			viewer.showInfo("Неверные данные");
		}
	}
}