package by.ipo.task5.controller.impl;

import by.ipo.task5.controller.Command;

/**
 * This class represents command to exit from program.
 * @author Pavel Isidovich
 *
 */
public class ExitCommand implements Command {

	@Override
	public void run() {
		System.exit(0);
	}
}
