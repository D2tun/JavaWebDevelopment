package by.ipo.task4.service.impl;

import java.util.List;

import by.ipo.task4.bean.Triangle;
import by.ipo.task4.dao.DataOperator;
import by.ipo.task4.dao.exception.DAOException;
import by.ipo.task4.dao.factory.DAOFactory;
import by.ipo.task4.service.exception.ServiceException;

/**
 * This class provides methods to read triangle information from file.
 * @author Pavel Isidovich
 * @see TriangleDataParser
 * @see DataOperatorImpl
 */
public class TriangleReader {

	/**
	 * This method reads triangle's to list.
	 * @param path - path to file
	 * @return list of triangles
	 * @throws ServiceException if there is no such file or file's
	 * type is different from txt or json
	 */
	public static List<Triangle> readTriangles(String path) 
			throws ServiceException {
		DataOperator dOperator = DAOFactory.getInstance().getDataOperator();
		List<Triangle> triangles;
		
		try {
			if (PathDefiner.definePath(path).compareTo("txt") == 0) {
				triangles = TriangleDataParser.parseTxt(dOperator
															.readTxtData(path));
			} else if (PathDefiner.definePath(path).compareTo("json") == 0) {
				triangles = TriangleDataParser.parseJson(dOperator
															.readJsonData(path));
			} else {
				throw new ServiceException();
			}
			
			return triangles;
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}
}
