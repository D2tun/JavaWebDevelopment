package by.ipo.task1.controller;

import by.ipo.task1.controller.impl.Command;
import by.ipo.task1.service.ExpressionCalculation;
import by.ipo.task1.view.ru.MessageViewer;
import by.ipo.task1.view.ru.FirstExpressionAnswer;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents command to get expression's result.
 * @author Pavel Isidovich
 *
 */
public class FirstExpressionCalc implements Command {
	
	private MessageViewer viewer = MessageViewer.getInstance();
	private FirstExpressionAnswer fea = FirstExpressionAnswer.getInstance();

	/**
	 * This method executes given command.
	 */
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		ExpressionCalculation ec = ExpressionCalculation.getInstance();
		
		viewer.showInfo("Введите параметры a, b, c, d через пробел");
		
		String[] parsedData = sc.nextLine().split(" ");
		
		try {
			if (parsedData.length != 4) {
				throw new IOException();
			}
			double a = Double.parseDouble(parsedData[0].replace(",", "."));
			double b = Double.parseDouble(parsedData[1].replace(",", "."));
			double c = Double.parseDouble(parsedData[2].replace(",", "."));
			double d = Double.parseDouble(parsedData[3].replace(",", "."));
			fea.showInfo(a, b, c, d, ec.calculateFirstExpression(a, b, c, d));
		} catch (NumberFormatException | IOException e) {
			viewer.showInfo("Неверные данные");
		}
	}
}
