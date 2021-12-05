package by.epam.task1.ipo.controller;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.SwapVariables;
import by.epam.task1.ipo.service.TriangleCheck;
import by.epam.task1.ipo.view.Viewer;

import java.util.Scanner;

/**
 * This class represents command to swap variables.
 * @author Pavel Isidovich
 *
 */
public class VariableSwap implements Command {
	
	private Viewer viewer = Viewer.getInstance();
	
	/**
	 * This method executes given command.
	 */
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		SwapVariables sw = SwapVariables.getInstance();
		
		viewer.showInfo("Введите способ (1 - дополнительная переменная, 2 -  "
						+ "арифметические операции, 3 - Исключающее ИЛИ), "
						+ "первую переменную, вторую переменную через пробел");
		String data = sc.nextLine();
		
		switch (data.charAt(0)) {
		case '1':
			viewer.showInfo(sw.swapFirstWay(data));
			break;
		case '2':
			viewer.showInfo(sw.swapSecondWay(data));
			break;
		case '3':
			viewer.showInfo(sw.swapThirdWay(data));
			break;
		default:
			viewer.showInfo("Неверные данные");
			break;
		}	
	}
}
