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
 * This class represents command to subtract two matrixes.
 * @author Pavel Isidovich
 *
 */
public class MatrixProductCommand implements Command {

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
		MatrixOperationService mos = sf.getMatrixProductService();
		
		String[] paths = mw.dataRequest(rb.getString("pathRequest2")).split(",");
		
		try {
			if (paths.length != 2) {
				throw new IOException();
			}
		
			String path1 = paths[0];
			String path2 = paths[1];
		
			logger.info("Команда выполняется");
			mw.showMatrix(mos.calculate(path1, path2));
		} catch (IOException e) {
			logger.error("Неверные данные");
			mw.showInfo(rb.getString("wrongData"));
		}
	}
}
