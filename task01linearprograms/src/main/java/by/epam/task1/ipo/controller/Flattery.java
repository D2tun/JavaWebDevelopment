package by.epam.task1.ipo.controller;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.FlatteryPhrase;
import by.epam.task1.ipo.view.Viewer;

import java.util.Scanner;

/**
 * This class represents command to get flattery phrase.
 * @author Pavel Isidovich
 *
 */

public class Flattery implements Command {
	
	private Viewer viewer = Viewer.getInstance();

	/**
	 * This method executes given command.
	 */
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		FlatteryPhrase fp = FlatteryPhrase.getInstance();
		
		viewer.showInfo("Кто ты мальчик или девочка? Введи Д или М");
		viewer.showInfo(fp.getPhrase(sc.nextLine()));
	}
}
