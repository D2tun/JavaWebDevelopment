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

public class ChoiceSortCommand implements Command {
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	private ResourceBundle rb = ResourceBundle.getBundle("view", 
														Locale.getDefault());
	private static MessageViewer mw = MessageViewer.getInstance();

	/**
	* Executes command
	*/
	@Override
	public void execute() {
	
		ServiceFactory sf = ServiceFactory.getInstance();
		SortingService ss = sf.getChoiceSortService();
		Scanner sc = new Scanner(System.in);
		
		mw.showInfo(rb.getString("pathRequest"));
		
		try {
			logger.info("Команда выполняется");
			mw.showInfo(ss.sort(sc.nextLine()).formatArrayToString());
		} catch (ServiceException e) {
			logger.error("Неверные данные");
			mw.showInfo(rb.getString("wrongData"));
		}
	}
}
