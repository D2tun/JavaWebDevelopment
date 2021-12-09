package by.ipo.task1.controller;

import by.ipo.task1.controller.impl.Command;
import by.ipo.task1.service.AreaCalculation;
import by.ipo.task1.view.ru.MessageViewer;
import by.ipo.task1.view.ru.RectangleInfoAnswer;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents command to get information about rectangle 
 * with given length.
 * @author Pavel Isidovich
 *
 */
public class RectangleInfo implements Command {
	
	private MessageViewer viewer = MessageViewer.getInstance();
	private RectangleInfoAnswer ria = RectangleInfoAnswer.getInstance();

	/**
	 * This method executes given command.
	 */	
	@Override
	public void execute() {
		AreaCalculation ac = AreaCalculation.getInstance();
		Scanner sc = new Scanner(System.in);
		
		viewer.showInfo("Введите длину прямоугольника  (мм)");
		
		try {
			double length = Double.parseDouble(sc.nextLine().replace(",", ","));
			ria.showInfo(length, length / 2, ac.getAnswer(length));
		} catch (IOException | NumberFormatException e) {
			viewer.showInfo("Неверные данные");
		}
	}
}
