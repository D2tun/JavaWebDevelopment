package by.epam.task1.ipo.controller;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.TriangleCheck;
import by.epam.task1.ipo.view.Viewer;

import java.util.Scanner;

/**
 * This class represents command to check if triangle is equilateral.
 * @author Pavel Isidovich
 *
 */

public class TriangleEquilateralityCheck implements Command {

	private Viewer viewer = Viewer.getInstance();
	
	/**
	 * This method executes given command.
	 */
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		TriangleCheck tc = TriangleCheck.getInstance();
		
		viewer.showInfo("Введите длину первой, второй и третьей стороны "
						+ "треугольника (мм) через пробел");
		viewer.showInfo(tc.checkEquilaterality(sc.nextLine()));
	}
}
