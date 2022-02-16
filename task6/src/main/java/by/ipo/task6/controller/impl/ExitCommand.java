package by.ipo.task6.controller.impl;

import by.ipo.task6.controller.Command;

/**
 * This class represents command to exit from program.
 * @author Pavel Isidovich
 *
 */
public class ExitCommand implements Command {

	@Override
	public void execute() {
		System.exit(0);
	}
}
