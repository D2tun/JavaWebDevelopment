package by.epam.task1.ipo.controller;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.FlatteryPhrase;
import java.util.Scanner;

/**
 * This class represents command to get flattery phrase.
 * @author Pavel Isidovich
 *
 */

public class Flattery implements Command {

	/**
	 * This method executes given command.
	 */
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		FlatteryPhrase fp = FlatteryPhrase.getInstance();
		String data;
		char gender;
		
		System.out.println("Кто ты мальчик или девочка? Введи Д или М");
		data = sc.nextLine();
		if (data.matches("[МД]")) {
			gender = data.charAt(0);
			System.out.println(fp.getPhrase(gender));
		} else {
			System.out.println("Неверные данные");
		}
	}
}
