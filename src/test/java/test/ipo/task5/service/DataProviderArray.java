package test.ipo.task5.service;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.*;

import by.ipo.task5.bean.Array;

public class DataProviderArray {

	private ClassLoader cl = getClass().getClassLoader();
	private String path1 = new File(cl.getResource("OneElementCheck.txt")
											.getFile()).getAbsolutePath();
	private String path2 = new File(cl.getResource("SameElementCheck.txt")
											.getFile()).getAbsolutePath();
	private String path3 = new File(cl.getResource("RegularArrayCheck.txt")
											.getFile()).getAbsolutePath();
	
	@DataProvider(name = "fileData")
	public Object[][] setData() throws URISyntaxException {
		Array<Double> arrOne = new Array<Double>(1);
		arrOne.setElement(0, 2.0);
		Array<Double> arrSame = new Array<Double>(7);
		arrSame.setElement(0, 2.0);
		arrSame.setElement(0, 2.0);
		arrSame.setElement(0, 2.0);
		arrSame.setElement(0, 2.0);
		arrSame.setElement(0, 2.0);
		arrSame.setElement(0, 2.0);
		arrSame.setElement(0, 2.0);
		Array<Double> arrReg = new Array<Double>(10);
		arrSame.setElement(0, -7136.0);
		arrSame.setElement(1, -71.0);
		arrSame.setElement(2, -1.0);
		arrSame.setElement(3, 8.0);
		arrSame.setElement(4, 9.0);
		arrSame.setElement(5, 9.87);
		arrSame.setElement(6, 9.9);
		arrSame.setElement(7, 17.0);
		arrSame.setElement(8, 777.0);
		arrSame.setElement(9, 6718.0);
		
		return new Object[][] {
			{ path1, arrOne },
			{ path2, arrSame },
			{ path3, arrReg },
							  };
	}
	
}
