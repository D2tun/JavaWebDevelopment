package by.ipo.task3part2.controller.impl;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;

import by.ipo.task3part2.view.MessageViewer;
import by.ipo.task3part2.service.exception.ServiceException;
import by.ipo.task3part2.controller.Command;
import by.ipo.task3part2.service.ExhibitionReader;
import by.ipo.task3part2.service.factory.ServiceFactory;

/**
 * This class represents command to get information about exhibitions.
 * @author Pavel Isidovich
 *
 */
public class ShowExhibitInfoCommand implements Command {
	
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	private ResourceBundle rb = ResourceBundle.getBundle("view", 
									Locale.getDefault());
	private static MessageViewer mw = MessageViewer.getInstance();

	/**
	 * This method executes command.
	 */
	@Override
	public void execute() {
		ServiceFactory sf = ServiceFactory.getInstance();
		ExhibitionReader er = sf.getExhibitionReader();
		Scanner sc = new Scanner(System.in);
		
		mw.showInfo(rb.getString("pathRequest"));

		try {
			logger.info("Команда выполняется");
			mw.showExhibitionInfo(er.read(sc.nextLine()));
		} catch (ServiceException e) {
			logger.error("Неверные данные");
			mw.showInfo(rb.getString("wrongData"));
		}
		
	}

}
