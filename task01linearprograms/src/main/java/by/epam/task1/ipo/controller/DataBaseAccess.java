package by.epam.task1.ipo.controller;

import java.util.Scanner;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.ModuleAccessCheck;
import by.epam.task1.ipo.view.Viewer;

/**
 * This class represents command to get database access. 
 * @author Pavel Isidovich
 *
 */

public class DataBaseAccess implements Command {
	
	private Viewer viewer = Viewer.getInstance();

	/**
	 * This method executes given command.
	 */
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		ModuleAccessCheck mac = ModuleAccessCheck.getInstance();
		
		viewer.showInfo("Введите пароль");
		viewer.showInfo(mac.checkAccess(sc.nextLine()));	
	}
}
