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
public class CommitmentSearcher implements InsuranceService {
	
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	/**
	 * This method creates list of commitments, corresponding to search 
	 * parameters.
	 * @param path - full file name
	 * @param cost - search parameter
	 * @param risk - search parameter
	 * @return list of commitments according to search parameters
	 */
	@Override
	public Derivative getCommitment(String path, int cost, double risk)
			throws ServiceException {
		if ((JsonPathValidator.validate(path) == false) || (cost < 0) 
				|| (risk < 0)) {
			logger.error("Неверный путь");
			throw new ServiceException();
		}
		
		logger.info("Данные получены");
		
		DAOFactory daof = DAOFactory.getInstance();
		
		DataOperator dOperator = daof.getDataOperator();
		
		try {
			Derivative result = dOperator.readData(path);
			
			for (int i = result.getDerivative().size() - 1; i > -1 ; --i) {
				if ((cost != result.getCommitment(i).getCost()) & (risk != result.getCommitment(i).getRiskCoefficient())) {
					result.deleteCommitment(i);
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
