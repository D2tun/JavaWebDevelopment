package by.ipo.task3part1.service.impl;

import org.apache.logging.log4j.LogManager;

import by.ipo.task3part1.bean.Commitment;
import by.ipo.task3part1.bean.Derivative;
import by.ipo.task3part1.dao.DataOperator;
import by.ipo.task3part1.dao.exception.DAOException;
import by.ipo.task3part1.dao.factory.DAOFactory;
import by.ipo.task3part1.service.InsuranceService;
import by.ipo.task3part1.service.exception.ServiceException;

/**
 * This class provides method to sort derivative by risk coefficient.
 * @author Pavel Isidovich
 *
 */
public class SortByRisk implements InsuranceService {

	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	/**
	 * This method sorts commitments by risk coefficient
	 * @param path - full name of json-file
	 * @return sorted derivative
	 * @throws ServiceException 
	 */
	public Derivative sort(String path) throws ServiceException {
		if (JsonPathValidator.validate(path) == false) {
			logger.error("Неверный путь");
			throw new ServiceException();
		}
		
		logger.info("Данные получены");
		
		DAOFactory daof = DAOFactory.getInstance();
		
		DataOperator dOperator = daof.getDataOperator();
		
		try {
			Derivative result = dOperator.readData(path);
			
			boolean iteration = true;
			while (iteration) {
				iteration = false;
				for (int i = 1; i < result.getDerivative().size(); ++i) {
					if (result.getCommitment(i).getRiskCoefficient() 
							< result.getCommitment(i - 1).getRiskCoefficient()) {
						Commitment temp = result.getDerivative().get(i);
						result.getDerivative().set(i, result.getCommitment(i - 1));
						result.getDerivative().set(i - 1, temp);
						iteration = true;
					}
				}
			}
			
			logger.info("Ответ отправлен");
			
			return result;
		} catch (DAOException e) {
			logger.error("Ошибка чтения файла");
			throw new ServiceException();
		}		
	}
}
