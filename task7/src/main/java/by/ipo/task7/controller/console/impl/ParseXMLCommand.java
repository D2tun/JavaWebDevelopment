package by.ipo.task7.controller.console.impl;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;

import by.ipo.task7.view.console.MessageViewer;
import by.ipo.task7.service.XMLDocumentOperation;
import by.ipo.task7.service.exception.ServiceException;
import by.ipo.task7.service.factory.ServiceFactory;
import by.ipo.task7.controller.console.Command;

/**
 * This class represents command to sort array through bubble sort.
 * @author Pavel Isidovich
 *
 */
public class ParseXMLCommand implements Command {

	private static org.apache.logging.log4j
							.Logger logger = LogManager.getFormatterLogger();
	private ResourceBundle rb = ResourceBundle.getBundle("view", 
														 Locale.getDefault());
	private static MessageViewer mw = MessageViewer.getInstance();

	@Override
	public void execute() {
		
		ServiceFactory sf = ServiceFactory.getInstance();
		XMLDocumentOperation xps = sf.getXMLParsingService();

		try {
			String data = mw.dataRequest(rb.getString("pathRequest"));
			
			String[] parsedData = data.split(" ");
			if (parsedData.length != 2) {
				mw.showInfo(rb.getString("wrongData"));
			} else {
				mw.showOrderList(xps.parseXML(parsedData[0], parsedData[1]));
			}
		} catch (ServiceException e) {
			mw.showInfo(e.getMessage());
		}

	}

}
