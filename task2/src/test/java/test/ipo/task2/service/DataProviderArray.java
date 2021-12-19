package test.ipo.task2.service;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.*;

import by.ipo.task2.bean.Array;

public class DataProviderArray {

	private ClassLoader cl = getClass().getClassLoader();
	private String path1 = new File(cl.getResource("OneElementCheck.txt").getFile()).getAbsolutePath();
	private String path2 = new File(cl.getResource("SameElementCheck.txt").getFile()).getAbsolutePath();
	private String path3 = new File(cl.getResource("RegularArrayCheck.txt").getFile()).getAbsolutePath();
	
	/*
	private String path1 = new File("OneElementCheck.txt").getAbsolutePath();
	private String path2 = new File("SameElementCheck.txt").getAbsolutePath();
	private String path3 = new File("RegularArrayCheck.txt").getAbsolutePath();
	 */
	@DataProvider(name = "fileData")
	public Object[][] setData() throws URISyntaxException {
		Array<Double> arrOne = new Array<Double>(1);
		arrOne.setArray(new Double[]{2.0});
		Array<Double> arrSame = new Array<Double>(7);
		arrSame.setArray(new Double[]{2.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0});
		Array<Double> arrReg = new Array<Double>(10);
		arrReg.setArray(new Double[]{-7136.0, -71.0, -1.0, 8.0, 9.0, 9.87, 
									 9.9, 17.0, 777.0, 6718.0});
		
		return new Object[][] {
			{ path1, arrOne },
			{ path2, arrSame },
			{ path3, arrOne },
							  };
	}
	
}
