package by.ipo.task3part1.controller.impl;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;

import by.ipo.task3part1.service.InsuranceService;
import by.ipo.task3part1.service.exception.ServiceException;
import by.ipo.task3part1.service.factory.ServiceFactory;
import by.ipo.task3part1.view.MessageViewer;
import by.ipo.task3part1.controller.Command;

/**
 * This class represents command to get derivative's total cost.
 * @author Pavel Isidovich
 *
 */
public class SortByRiskCommand implements Command {

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
		InsuranceService is = sf.getSortByRisk();
		Scanner sc = new Scanner(System.in);
		
		mw.showInfo(rb.getString("pathRequest"));

		try {
			logger.info("Команда выполняется");
			mw.showDerivative(is.sort(sc.nextLine()));
		} catch (ServiceException e) {
			logger.error("Неверные данные");
			mw.showInfo(rb.getString("wrongData"));
		}
	}
}
