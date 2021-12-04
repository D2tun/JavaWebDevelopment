package by.epam.task1.ipo.controller;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.AreaCalculation;
import by.epam.task1.ipo.view.Viewer;

import java.util.Scanner;

/**
 * This class represents command to get information about rectangle 
 * with given length.
 * @author Pavel Isidovich
 *
 */

public class RectangleInfo implements Command {
	
	private Viewer viewer = Viewer.getInstance();

	/**
	 * This method executes given command.
	 */
	
	@Override
	public void execute() {
		AreaCalculation ac = AreaCalculation.getInstance();
		Scanner sc = new Scanner(System.in);
		
		viewer.showInfo("Введите длину прямоугольника  (мм)");
		viewer.showInfo(ac.getAnswer(sc.nextLine()));
	}
}
