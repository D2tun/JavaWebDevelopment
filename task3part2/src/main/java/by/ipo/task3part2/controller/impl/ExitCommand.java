package by.ipo.task3part2.controller.impl;

import by.ipo.task3part2.controller.Command;

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
