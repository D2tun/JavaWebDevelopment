package test.ipo.task5.service;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.ipo.task5.bean.Matrix;
import by.ipo.task5.service.MatrixOperationService;
import by.ipo.task5.service.exception.ServiceException;
import by.ipo.task5.service.factory.ServiceFactory;

public class MatrixSubtractServiceTest {

	private ServiceFactory sf = ServiceFactory.getInstance();
	private MatrixOperationService mos = sf.getMatrixSubtractService();
	
	@Test(description = "Проверка суммирования матриц",
		  dataProvider = "matrixData", 
		  dataProviderClass = DataProviderMatrix.class)
	public void calculateTest(String path1, String path2, 
							  Matrix sum, Matrix sub, Matrix prod) 
									  throws ServiceException {
		Assert.assertEquals(mos.calculate(path1, path2), sub);
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
