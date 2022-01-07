package by.ipo.task2.controller.impl;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;

import by.ipo.task2.controller.Command;
import by.ipo.task2.service.SortingService;
import by.ipo.task2.service.exception.ServiceException;
import by.ipo.task2.service.factory.ServiceFactory;
import by.ipo.task2.view.MessageViewer;

/**
 * This class represents command to sort array through insertion sort
 * with binary search.
 * @author Pavel Isidovich
 *
 */
public class InsertionSortBSCommand implements Command {

		private static org.apache.logging.log4j
						.Logger logger = LogManager.getFormatterLogger();
		private ResourceBundle rb = ResourceBundle.getBundle("view", 
															 Locale.getDefault());
		private static MessageViewer mw = MessageViewer.getInstance();

		/** 
		* Executes command.
		*/
		@Override
		public void execute() {
			ServiceFactory sf = ServiceFactory.getInstance();
			SortingService ss = sf.getInsertionSortBSService();

			try {
				logger.info("Команда выполняется");
				mw.showArray(ss.sort(mw.dataRequest(rb.getString("pathRequest"))));
			} catch (ServiceException e) {
				logger.error("Неверные данные");
				mw.showInfo(rb.getString("wrongData"));
			}
	}
}

