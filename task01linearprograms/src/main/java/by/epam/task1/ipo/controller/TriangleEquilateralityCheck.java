package by.ipo.task1.controller;

import by.ipo.task1.controller.impl.Command;
import by.ipo.task1.service.TriangleCheck;
import by.ipo.task1.view.ru.MessageViewer;
import by.ipo.task1.view.ru.TriangleEquilateralityCheckAnswer;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents command to check if triangle is equilateral.
 * @author Pavel Isidovich
 *
 */
public class TriangleEquilateralityCheck implements Command {

	private MessageViewer viewer = MessageViewer.getInstance();
	private TriangleEquilateralityCheckAnswer teca = 
				TriangleEquilateralityCheckAnswer.getInstance();
	
	/**
	 * This method executes given command.
	 */
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		TriangleCheck tc = TriangleCheck.getInstance();
		
		viewer.showInfo("Введите длину первой, второй и третьей стороны "
						+ "треугольника (мм) через пробел");
		
		String[] parsedData = sc.nextLine().split(" ");
		
		try {
			if (parsedData.length != 3) {
				throw new IOException();
			}
			
			double side1 = Double.parseDouble(parsedData[0].replace(",", "."));
			double side2 = Double.parseDouble(parsedData[1].replace(",", "."));
			double side3 = Double.parseDouble(parsedData[2].replace(",", "."));
			
			teca.showInfo(tc.checkEquilaterality(side1, side2, side3));
		} catch (IOException | NumberFormatException e) {
			viewer.showInfo("Неверные данные");
		}
	}
}
