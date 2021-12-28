package by.ipo.task3part1.service;

import by.ipo.task3part1.bean.Derivative;
import by.ipo.task3part1.service.exception.ServiceException;

/**
 * This marker-interface for classes, which provides methods
 * operations with derivative.
 * @author Pavel Isidovich
 *
 */
public interface InsuranceService {

	default int getTotalCost(String nextLine) throws ServiceException {
		return 0;
	}

	default Derivative sort(String nextLine) throws ServiceException {
		return null;
	}

	default Derivative getCommitment(String nextLine, int cost, double risk)
			throws ServiceException {
		return null;
	}
}
