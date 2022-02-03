package by.ipo.task5.controller.impl;

import java.util.Locale;
import java.util.ResourceBundle;

import by.ipo.task5.controller.Command;
import by.ipo.task5.view.MessageViewer;

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
	public void run() {
		mw.showInfo(rb.getString("noSuchCommand"));
	}
}
