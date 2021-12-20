package by.ipo.task2.controller.impl;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;

import by.ipo.task2.controller.Command;
import by.ipo.task2.service.MatrixOperationService;
import by.ipo.task2.service.factory.ServiceFactory;
import by.ipo.task2.view.MessageViewer;

/**
 * This class represents command to subtract two matrixes.
 * @author Pavel Isidovich
 *
 */
public class MatrixSubtractCommand implements Command {
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
		MatrixOperationService mos = sf.getMatrixSubtractService();
		Scanner sc = new Scanner(System.in);

		mw.showInfo(rb.getString("pathRequest2"));

		String[] paths = sc.nextLine().split(",");

		try {
			if (paths.length != 2) {
				throw new IOException();
			}

			String path1 = paths[0];
			String path2 = paths[1];

			logger.info("Команда выполняется");
			mw.showInfo(mos.calculate(path1, path2).formString());
		} catch (IOException e) {
			logger.error("Неверные данные");
			mw.showInfo(rb.getString("wrongData"));
		}
	}
}
