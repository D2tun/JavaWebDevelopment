package by.ipo.task4.service.impl;

import org.apache.logging.log4j.LogManager;

import by.ipo.task4.bean.Triangle;
import by.ipo.task4.dao.exception.DAOException;
import by.ipo.task4.dao.factory.DAOFactory;
import by.ipo.task4.service.Repository;
import by.ipo.task4.service.exception.ServiceException;

/**
 * This class loads triangle's information in repository.
 * @author Pavel Isidovich
 * @see Triangle
 */
public class TriangleLoader {
	
	private static org.apache.logging.log4j
						.Logger logger = LogManager.getFormatterLogger();

	/**
	 * This method adds given files content to repository.
	 * @param path - path to file
	 * @param repository - target repository
	 * @throws ServiceException - if file is absent, got name 
	 * suffix different from txt or json, or if triangle with entered
	 * point coordinates is absent in file, or path is invalid.
	 */
	public static void load(String path, Repository<Triangle> repository) 
			throws ServiceException {
		switch (PathDefiner.definePath(path)) {

		case "txt":
			logger.trace("Данные получены");
			try {
				ListAdder.addList(TriangleDataParser.parseTxt(DAOFactory
															.getInstance()
															.getDataOperator()
															.readTxtData(path)));
			} catch (DAOException e) {
				logger.error("Ошибка чтения файла " + path);
				throw new ServiceException();
			}
			break;

		case "json":
			logger.trace("Данные получены");
			try {
				ListAdder.addList(TriangleDataParser.parseJson(DAOFactory
															.getInstance()
															.getDataOperator()
															.readJsonData(path)));
			} catch (DAOException e) {
				logger.error("Ошибка чтения файла " + path);
				throw new ServiceException();
			}
			break;

		case "invalid":
			logger.error("Ошибка чтения файла " + path);
			throw new ServiceException();
		}
	}
}
