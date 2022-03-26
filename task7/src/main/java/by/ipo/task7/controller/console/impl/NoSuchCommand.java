package by.ipo.task7.controller.console.impl;

import java.util.Locale;
import java.util.ResourceBundle;

import by.ipo.task7.controller.console.Command;
import by.ipo.task7.view.console.MessageViewer;

/**
 * This class represents absent commands.
 * @author Pavel Isidovich
 *
 */
public class NoSuchCommand implements Command {


	private ResourceBundle rb = ResourceBundle.getBundle("view", 
						 								 Locale.getDefault());
	private static MessageViewer mw = MessageViewer.getInstance();

	@Override
	public void execute() {
		mw.showInfo(rb.getString("noSuchCommand"));
	}
}
