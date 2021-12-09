package by.ipo.task1.controller;

import by.ipo.task1.controller.impl.Command;
import by.ipo.task1.service.ExpressionCalculation;
import by.ipo.task1.view.ru.MessageViewer;
import by.ipo.task1.view.ru.SquareExpressionAbsAnswer;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents command to get result of expression.
 * @author Pavel Isidovich
 *
 */
public class ExpressionModuleCalc implements Command {
	
	private MessageViewer viewer = MessageViewer.getInstance();
	private SquareExpressionAbsAnswer seaa = SquareExpressionAbsAnswer
												.getInstance();
	
	/**
	 * This method executes given command.
	 */
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		ExpressionCalculation ec = ExpressionCalculation.getInstance();
		
		viewer.showInfo("Введите параметры a, b, c, x через пробел");
		
		String[] parsedData = sc.nextLine().split(" ");
		
		try {
			if (parsedData.length != 4) {
				throw new IOException();
			}
			double a = Double.parseDouble(parsedData[0].replace(",", "."));
			double b = Double.parseDouble(parsedData[1].replace(",", "."));
			double c = Double.parseDouble(parsedData[2].replace(",", "."));
			double x = Double.parseDouble(parsedData[3].replace(",", "."));
			seaa.showInfo(a, b, c, x, 
						  ec.calculateSquareExpressionAbs(a, b, c, x));
		} catch (IOException | NumberFormatException e) {
			viewer.showInfo("Неверные данные");
		}
	}
}
