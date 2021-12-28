package by.ipo.task3part1.service.impl;

import org.apache.logging.log4j.LogManager;

import by.ipo.task3part1.bean.Derivative;
import by.ipo.task3part1.dao.DataOperator;
import by.ipo.task3part1.dao.exception.DAOException;
import by.ipo.task3part1.dao.factory.DAOFactory;
import by.ipo.task3part1.service.InsuranceService;
import by.ipo.task3part1.service.exception.ServiceException;

/**
 * This class provides method to summarize cost of derivative.
 * @author Pavel Isidovich
 *
 */
public class CostCounter implements InsuranceService {
	
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	/**
	 * This method counts total cost of the derivative.
	 * @param path - full json-file name
	 * @return total cost
	 * @throws ServiceException if method fails
	 */
	public int getTotalCost(String path) throws ServiceException {
		
		if (JsonPathValidator.validate(path) == false) {
			logger.error("Неверный путь");
			throw new ServiceException();
		}
		
		logger.info("Данные получены");
		
		DAOFactory daof = DAOFactory.getInstance();
		
		DataOperator dOperator = daof.getDataOperator();
		
		int sum = 0;
		
		try {
			Derivative d = dOperator.readData(path);
			
			for(int i = 0; i < d.getDerivative().size(); ++i) {
				sum += d.getCommitment(i).getCost();
			}
			
			logger.info("Ответ отправлен");
			
			return sum;
		} catch (DAOException e) {
			logger.error("Ошибка чтения файла");
			throw new ServiceException();
		}
	}
}
