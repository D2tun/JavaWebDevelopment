package by.ipo.task1.controller;

import by.ipo.task1.controller.impl.Command;
import by.ipo.task1.service.FlatteryPhrase;
import by.ipo.task1.view.ru.MessageViewer;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents command to get flattery phrase.
 * @author Pavel Isidovich
 *
 */

public class Flattery implements Command {
	
	private MessageViewer viewer = MessageViewer.getInstance();

	/**
	 * This method executes given command.
	 */
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		FlatteryPhrase fp = FlatteryPhrase.getInstance();
		
		viewer.showInfo("Кто ты мальчик или девочка? Введи Д или М");
		
		try {
			viewer.showInfo(fp.getPhrase(sc.nextLine()));
		} catch (IOException e) {
			viewer.showInfo("Неверные данные");
		}
	}
}
