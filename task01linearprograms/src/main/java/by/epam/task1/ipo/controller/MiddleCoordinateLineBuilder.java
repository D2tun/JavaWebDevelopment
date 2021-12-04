package by.epam.task1.ipo.controller;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.FirstFunctionBuilder;
import by.epam.task1.ipo.view.Viewer;

import java.util.Scanner;

/**
 * This class represents command to get dots of line.
 * @author Pavel Isidovich
 *
 */

public class MiddleCoordinateLineBuilder implements Command {
	
	private Viewer viewer = Viewer.getInstance();

	/**
	 * This method executes given command.
	 */
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		FirstFunctionBuilder bff = FirstFunctionBuilder.getInstance();
		
		viewer.showInfo("Введите нижний предел счёта");
		viewer.showInfo(bff.getCoordinates(sc.nextLine()));	
	}
}