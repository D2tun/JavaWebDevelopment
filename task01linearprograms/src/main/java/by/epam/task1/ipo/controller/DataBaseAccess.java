package by.ipo.task1.controller;

import java.util.Scanner;

import by.ipo.task1.controller.impl.Command;
import by.ipo.task1.service.ModuleAccessCheck;
import by.ipo.task1.view.ru.MessageViewer;
import by.ipo.task1.view.ru.DataBaseAccessAnswer;

/**
 * This class represents command to get database access. 
 * @author Pavel Isidovich
 *
 */

public class DataBaseAccess implements Command {
	
	private MessageViewer viewer = MessageViewer.getInstance();
	private DataBaseAccessAnswer dbaa = DataBaseAccessAnswer.getInstance();

	/**
	 * This method executes given command.
	 */
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		ModuleAccessCheck mac = ModuleAccessCheck.getInstance();
		
		viewer.showInfo("Введите пароль");
		
		dbaa.showInfo(mac.checkAccess(sc.nextLine()));
	}
}
