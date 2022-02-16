package by.ipo.task6.controller.impl;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;

import by.ipo.task6.controller.Command;
import by.ipo.task6.service.TextOperation;
import by.ipo.task6.service.exception.ServiceException;
import by.ipo.task6.service.factory.ServiceFactory;
import by.ipo.task6.view.MessageViewer;

/**
 * This class represents command to sort sentence's words by their
 * lengths.
 * @author Pavel Isidovich
 *
 */
public class SortSentenceWordsCommand implements Command {

	private static org.apache.logging.log4j
							.Logger logger = LogManager.getFormatterLogger();
	private ResourceBundle rb = ResourceBundle.getBundle("view", 
									 					 Locale.getDefault());
	private static MessageViewer mw = MessageViewer.getInstance();

	@Override
	public void execute() {
		ServiceFactory sf = ServiceFactory.getInstance();
		TextOperation to = sf.getSortSentenceWordsService();

		try {
			logger.info("Команда выполняется");
			mw.showInfo(to.sortByLength(mw.makeRequest(rb
												.getString("pathRequest"))));
		} catch (ServiceException e) {
			logger.error("Неверные данные");
			mw.showInfo(rb.getString("wrongData"));
		}
	}
}
