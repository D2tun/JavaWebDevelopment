package by.ipo.task1.controller;

import by.ipo.task1.controller.impl.Command;
import by.ipo.task1.service.SecondFunctionBuilder;
import by.ipo.task1.view.ru.MessageViewer;
import by.ipo.task1.view.ru.SecondFunctionAnswer;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents command to build math function.
 * @author Pavel Isidovich
 *
 */

public class FunctionFX implements Command {

	private MessageViewer viewer = MessageViewer.getInstance();
	private SecondFunctionAnswer sfa = SecondFunctionAnswer.getInstance();
	
	/**
	 * This method executes given command.
	 */
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		SecondFunctionBuilder sfb = SecondFunctionBuilder.getInstance();
		
		viewer.showInfo("Введите нижний предел счёта, верхний предел счёта, "
						+ "шаг счёта через пробел");
		
		String[] parsedData = sc.nextLine().split(" ");
		
		try {
			if (parsedData.length != 3) {
				throw new IOException();
			}
			double lowLimit = Double.parseDouble(parsedData[0]
										.replace(",", "."));
			double highLimit = Double.parseDouble(parsedData[1]
										.replace(",", "."));
			double step = Double.parseDouble(parsedData[2]
										.replace(",", "."));
			sfa.showInfo(sfb.getCoordinates(lowLimit, highLimit, step));
		} catch (IOException | NumberFormatException e) {
			viewer.showInfo("Неверные данные");
		}
	}
}
