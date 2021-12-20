package test.ipo.task2.service;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.ipo.task2.service.MatrixOperationService;
import by.ipo.task2.service.exception.ServiceException;
import by.ipo.task2.service.factory.ServiceFactory;
import by.ipo.task2.bean.Matrix;

public class MatrixProductServiceTest {
	
	private ServiceFactory sf = ServiceFactory.getInstance();
	private MatrixOperationService mos = sf.getMatrixProductService();
	
	@Test(description = "Проверка суммирования матриц",
		  dataProvider = "matrixData", 
		  dataProviderClass = DataProviderMatrix.class)
	public void calculateTest(String path1, String path2, 
							  Matrix sum, Matrix sub, Matrix prod) 
									  throws ServiceException {
		Assert.assertEquals(mos.calculate(path1, path2), prod);
	}
	
	@Test(description = "Проверка суммирования матриц",
		  dataProvider = "matrixWrongData", 
		  dataProviderClass = DataProviderMatrix.class,
		  expectedExceptions = ServiceException.class) 
	public void calculateTest(String path1, String path2, ServiceException se) 
			throws ServiceException {
		Assert.assertEquals(mos.calculate(path1, path2), se);
	}

}
