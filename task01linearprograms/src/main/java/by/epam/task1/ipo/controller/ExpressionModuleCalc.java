package by.epam.task1.ipo.controller;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.ExpressionCalculation;
import by.epam.task1.ipo.view.Viewer;

import java.util.Scanner;

/**
 * This class represents command to get result of expression.
 * @author Pavel Isidovich
 *
 */

public class ExpressionModuleCalc implements Command {
	
	private Viewer viewer = Viewer.getInstance();
	
	/**
	 * This method executes given command.
	 */

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		ExpressionCalculation ec = ExpressionCalculation.getInstance();
		
		viewer.showInfo("Введите параметры a, b, c, x через пробел");
		viewer.showInfo(ec.calculateSquareExpressionAbs(sc.nextLine()));
	}
}
