package by.ipo.task2.service.impl;

import java.io.IOException;

import by.ipo.task2.bean.Array;
import by.ipo.task2.dao.FileReader;
import by.ipo.task2.dao.factory.DAOFactory;
import by.ipo.task2.service.exception.ServiceException;

/**
 * This class provides method to convert string to an array
 * @author Pavel Isidovich
 * @see Array
 */
public class ArrayReader {

	public static Array readArray(String path) throws ServiceException {
		
		DAOFactory daof = DAOFactory.getInstance();
		FileReader afr = daof.getArrayFileReader();
		
		String data;
		try {
			data = afr.readFile(path);
			String[] parsed = data.split(" ");
			
			Array array = new Array(parsed.length);
			
			for (int i = 0; i < parsed.length; ++i) {
				array.setElement(i, parsed[i]);
			}
			
			return array;
		} catch (IOException e) {
			throw new ServiceException();
		}
	}
}
