package by.epam.task1.ipo.controller;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.SecondFunctionBuilder;
import by.epam.task1.ipo.view.Viewer;

import java.util.Scanner;

/**
 * This class represents command to build math function.
 * @author Pavel Isidovich
 *
 */

public class FunctionFX implements Command {

	private Viewer viewer = Viewer.getInstance();
	
	/**
	 * This method executes given command.
	 */
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		SecondFunctionBuilder sfb = SecondFunctionBuilder.getInstance();
		
		viewer.showInfo("Введите нижний предел счёта, верхний предел счёта, "
						+ "шаг счёта через пробел");
		viewer.showInfo(sfb.getCoordinates(sc.nextLine()));
	}
}
