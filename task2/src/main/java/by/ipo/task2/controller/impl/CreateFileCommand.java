package by.ipo.task2.controller.impl;

import by.ipo.task2.controller.Command;
import by.ipo.task2.service.exception.ServiceException;
import by.ipo.task2.service.factory.ServiceFactory;
import by.ipo.task2.view.MessageViewer;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;

/**
 * This class represents command to create file.
 * @author Pavel Isidovich
 *
 */
public class CreateFileCommand implements Command {
	
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
		Scanner sc = new Scanner(System.in);
		
		mw.showInfo(rb.getString("createFileCommandDataRequest"));
		
		String[] parsedData = sc.nextLine().split(" ");
		
		try {
			if (parsedData.length != 2) {
				logger.error("Ошибка");
				throw new IOException();
			}
			logger.info("Получены даные" + parsedData[0] + " " + parsedData[1]);
			int length = Integer.parseInt(parsedData[1]);
			sf.getFileCreatingService().requestCreation(parsedData[0], length);
			logger.info("Запрос на создание файла отпрвлен");
		} catch (NumberFormatException | IOException e) {
			logger.error("Ошибка");
			mw.showInfo(rb.getString("wrongData"));
		}	
	}
}
