package by.ipo.task5.service.impl;

import java.io.IOException;

import by.ipo.task5.bean.Array;
import by.ipo.task5.dao.FileReader;
import by.ipo.task5.dao.factory.DAOFactory;
import by.ipo.task5.service.exception.ServiceException;

/**
 * This class provides method to convert string being read to an 
 * array
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
			
			Array<Double> array = new Array<>(parsed.length);
			
			for (int i = 0; i < parsed.length; ++i) {
				array.setElement(i, Double.parseDouble(parsed[i]));
			}
			
			return array;
		} catch (IOException e) {
			throw new ServiceException();
		}
	}
}
