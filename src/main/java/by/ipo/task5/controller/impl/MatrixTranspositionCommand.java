package by.ipo.task5.controller.impl;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;

import by.ipo.task5.controller.Command;
import by.ipo.task5.service.MatrixOperationService;
import by.ipo.task5.service.factory.ServiceFactory;
import by.ipo.task5.view.MessageViewer;

/**
 * This class represents command to sum two matrixes.
 * @author Pavel Isidovich
 *
 */
public class MatrixTranspositionCommand implements Command {

	private static org.apache.logging.log4j
							.Logger logger = LogManager.getFormatterLogger();
	private ResourceBundle rb = ResourceBundle.getBundle("view", 
														 Locale.getDefault());
	private static MessageViewer mw = MessageViewer.getInstance();

	/**
	* Executes command
	*/
	@Override
	public void run() {
		ServiceFactory sf = ServiceFactory.getInstance();
		MatrixOperationService mos = sf.getMatixTranspositionService();

		try {
			logger.info("Команда выполняется");
			mw.showMatrix(mos.calculate(rb.getString("pathRequest"), null));
		} catch (IOException e) {
			logger.error("Неверные данные");
			mw.showInfo(rb.getString("wrongData"));
		}
	}
}
