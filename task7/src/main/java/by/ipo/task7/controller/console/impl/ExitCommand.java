package by.ipo.task7.controller.console.impl;

import by.ipo.task7.controller.console.Command;

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
