package by.ipo.task3part1.service.factory;

import by.ipo.task3part1.service.InsuranceService;
import by.ipo.task3part1.service.impl.CommitmentSearcher;
import by.ipo.task3part1.service.impl.CostCounter;
import by.ipo.task3part1.service.impl.SortByRisk;

/**
 * This class represents factory of service.
 * @author Pavel Isidovich
 */
public class ServiceFactory {
	
	private static final ServiceFactory instance = new ServiceFactory();
	
	private final InsuranceService cc = new CostCounter();
	private final InsuranceService sbr = new SortByRisk();
	private final InsuranceService cs = new CommitmentSearcher();
	
	/**
	 * This method returns link on existing object of this class.
	 * @return <strong>instance</strong> of object.
	 */
	public static ServiceFactory getInstance() {
		return instance;
	}
	
	/**
	 * This method returns link on existing object of 
	 * FileCreatingService class.
	 * @return <strong>instance</strong> of object.
	 */
	public InsuranceService getCostCounter() {
		return cc;
	}
	
	/**
	 * This method returns link on existing object of 
	 * FileCreatingService class.
	 * @return <strong>instance</strong> of object.
	 */
	public InsuranceService getSortByRisk() {
		return sbr;
	}
	
	/**
	 * This method returns link on existing object of 
	 * FileCreatingService class.
	 * @return <strong>instance</strong> of object.
	 */
	public InsuranceService getCommitmentSearcher() {
		return cs;
	}
}
