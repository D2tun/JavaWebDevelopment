package test.ipo.task2.service;

import java.io.File;
import org.testng.annotations.DataProvider;

import by.ipo.task2.bean.Matrix;
import by.ipo.task2.service.exception.ServiceException;

public class DataProviderMatrix {

	private ClassLoader cl = getClass().getClassLoader();
	private String path1 = new File(cl.getResource("m1.txt").getFile()).getAbsolutePath();
	private String path2 = new File(cl.getResource("m2.txt").getFile()).getAbsolutePath();
	private String path1w = new File(cl.getResource("m1wrong.txt").getFile()).getAbsolutePath();
	private String path2w = new File(cl.getResource("m2wrong.txt").getFile()).getAbsolutePath();
	
	@DataProvider(name = "matrixData")
	public Object[][] setData() {
		Matrix<Double> arrSum = new Matrix<Double>(2, 2);
		Matrix<Double> arrSub = new Matrix<Double>(2, 2);
		Matrix<Double> arrProd = new Matrix<Double>(2, 2);
		arrSum.setElement(0, 0, 2.0);
		arrSum.setElement(0, 1, 2.0);
		arrSum.setElement(1, 0, 2.0);
		arrSum.setElement(1, 1, 2.0);
		arrSub.setElement(0, 0, 0.0);
		arrSub.setElement(0, 1, 0.0);
		arrSub.setElement(1, 0, 0.0);
		arrSub.setElement(1, 1, 0.0);
		arrProd.setElement(0, 0, 2.0);
		arrProd.setElement(0, 1, 2.0);
		arrProd.setElement(1, 0, 2.0);
		arrProd.setElement(1, 1, 2.0);
		
		return new Object[][] {
			{ path1, path2, arrSum, arrSub, arrProd },
							  };
	}
	
	@DataProvider(name = "matrixWrongData")
	public Object[][] setWrongData() {
		
		return new Object[][] {
			{ path1, path2, new ServiceException() },
							  };
	}
}
