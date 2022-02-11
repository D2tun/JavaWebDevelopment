package by.ipo.task5.service.factory;

import by.ipo.task5.service.FileCreatingService;
import by.ipo.task5.service.MatrixOperationService;
import by.ipo.task5.service.SortingService;
import by.ipo.task5.service.impl.BubbleSortServiceImpl;
import by.ipo.task5.service.impl.ChoiceSortServiceImpl;
import by.ipo.task5.service.impl.FileCreatingServiceImpl;
import by.ipo.task5.service.impl.InsertionSortBinaryImpl;
import by.ipo.task5.service.impl.InsertionSortServiceImpl;
import by.ipo.task5.service.impl.MatrixTranspositionServiceImpl;
import by.ipo.task5.service.impl.MatrixMultiplyServiceImpl;
import by.ipo.task5.service.impl.MatrixProductServiceImpl;
import by.ipo.task5.service.impl.MatrixSubtractServiceImpl;
import by.ipo.task5.service.impl.MatrixSumServiceImpl;
import by.ipo.task5.service.impl.MergeSortServiceImpl;
import by.ipo.task5.service.impl.ShakerSortServiceImpl;
import by.ipo.task5.service.impl.ShellSortServiceImpl;

/**
 * This class represents factory of service.
 * @author Pavel Isidovich
 */
public class ServiceFactory {
	
	private static final ServiceFactory instance = new ServiceFactory();
	
	private final FileCreatingService fcs = new FileCreatingServiceImpl();
	private final SortingService ssbs = new BubbleSortServiceImpl();
	private final SortingService ssss = new ShakerSortServiceImpl();
	private final SortingService sscs = new ChoiceSortServiceImpl();
	private final SortingService ssis = new InsertionSortServiceImpl();
	private final SortingService ssisb = new InsertionSortBinaryImpl();
	private final SortingService ssms = new MergeSortServiceImpl();
	private final SortingService ssshs = new ShellSortServiceImpl();
	private final MatrixOperationService moss = new MatrixSumServiceImpl();
	private final MatrixOperationService mossb = new MatrixSubtractServiceImpl();
	private final MatrixOperationService mosp = new MatrixProductServiceImpl();
	private final MatrixOperationService most 
										= new MatrixTranspositionServiceImpl();
	private final MatrixOperationService mosm = new MatrixMultiplyServiceImpl();
	
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
	public FileCreatingService getFileCreatingService() {
		return fcs;
	}

	/**
	 * This method returns link on existing object of 
	 * SortingService class.
	 * @return <strong>instance</strong> of object.
	 */
	public SortingService getBubbleSortService() {
		return ssbs;
	}
	
	/**
	 * This method returns link on existing object of 
	 * SortingService class.
	 * @return <strong>instance</strong> of object.
	 */
	public SortingService getShakerSortService() {
		return ssss;
	}
	
	/**
	 * This method returns link on existing object of 
	 * SortingService class.
	 * @return <strong>instance</strong> of object.
	 */
	public SortingService getChoiceSortService() {
		return sscs;
	}
	
	/**
	 * This method returns link on existing object of 
	 * SortingService class.
	 * @return <strong>instance</strong> of object.
	 */
	public SortingService getInsertionSortService() {
		return ssis;
	}
	
	/**
	 * This method returns link on existing object of 
	 * SortingService class.
	 * @return <strong>instance</strong> of object.
	 */
	public SortingService getInsertionSortBSService() {
		return ssisb;
	}
	
	/**
	 * This method returns link on existing object of 
	 * SortingService class.
	 * @return <strong>instance</strong> of object.
	 */
	public SortingService getMergeSortService() {
		return ssms;
	}
	
	/**
	 * This method returns link on existing object of 
	 * SortingService class.
	 * @return <strong>instance</strong> of object.
	 */
	public SortingService getShellSortService() {
		return ssshs;
	}
	
	/**
	 * This method returns link on existing object of 
	 * SortingService class.
	 * @return <strong>instance</strong> of object.
	 */
	public MatrixOperationService getMatrixSumService() {
		return moss;
	}
	
	/**
	 * This method returns link on existing object of 
	 * SortingService class.
	 * @return <strong>instance</strong> of object.
	 */
	public MatrixOperationService getMatrixSubtractService() {
		return mossb;
	}
	
	/**
	 * This method returns link on existing object of 
	 * SortingService class.
	 * @return <strong>instance</strong> of object.
	 */
	public MatrixOperationService getMatrixProductService() {
		return mosp;
	}
	
	/**
	 * This method returns link on existing object of 
	 * SortingService class.
	 * @return <strong>instance</strong> of object.
	 */
	public MatrixOperationService getMatixTranspositionService() {
		return most;
	}
	
	/**
	 * This method returns link on existing object of 
	 * SortingService class.
	 * @return <strong>instance</strong> of object.
	 */
	public MatrixOperationService getMatrixMultiplyService() {
		return mosm;
	}
}
