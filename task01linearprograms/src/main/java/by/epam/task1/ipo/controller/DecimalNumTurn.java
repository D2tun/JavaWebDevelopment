package by.epam.task1.ipo.controller;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.DecimalNumTurner;
import by.epam.task1.ipo.view.Viewer;

import java.util.Scanner;

/**
 * This class represents command to turn number from nnn.ddd to 
 * ddd.nnn.
 * @author Pavel Isidovich
 *
 */

public class DecimalNumTurn implements Command {
	
	private Viewer viewer = Viewer.getInstance();
	
	/**
	 * This method executes given command.
	 */

	@Override
	public void execute() {
		DecimalNumTurner dnt = DecimalNumTurner.getInstance();
		Scanner sc = new Scanner(System.in);
		
		viewer.showInfo("Введите числов вида nnn.ddd");
		viewer.showInfo(dnt.turn(sc.nextLine()));
	}
}
