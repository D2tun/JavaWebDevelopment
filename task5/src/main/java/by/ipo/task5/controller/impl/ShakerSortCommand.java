package by.ipo.task5.controller.impl;

import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;

import by.ipo.task5.controller.Command;
import by.ipo.task5.service.SortingService;
import by.ipo.task5.service.exception.ServiceException;
import by.ipo.task5.service.factory.ServiceFactory;
import by.ipo.task5.view.MessageViewer;

/**
 * This class represents command to sort array through shaker sort.
 * @author Pavel Isidovich
 *
 */
public class ShakerSortCommand implements Command {

	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	private ResourceBundle rb = ResourceBundle.getBundle("view", 
														 Locale.getDefault());
	private static MessageViewer mw = MessageViewer.getInstance();
	
	/** 
	 * This constructor creates new CommandManager and initializes
	 * command map.
	 */
	@Override
	public void run() {
		ServiceFactory sf = ServiceFactory.getInstance();
		SortingService ss = sf.getShakerSortService();
		
		try {
			logger.info("Команда выполняется");
			mw.showArray(ss.sort(mw.dataRequest(rb.getString("pathRequest"))));
		} catch (ServiceException e) {
			logger.error("Неверные данные");
			mw.showInfo(rb.getString("wrongData"));
		}
	}
}
