package test.ipo.task4.service.impl;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import by.ipo.task4.service.exception.ServiceException;
import by.ipo.task4.service.impl.PerimeterCalculationService;
import by.ipo.task4.service.impl.TriangleTypeDefineService;

class TriangleTypeDefineServiceTest {

private TriangleTypeDefineService a = TriangleTypeDefineService.getInstance();
	
	@ParameterizedTest
	@MethodSource("test.ipo.task4.service.impl.TriangleProvider#data")
	void testCalculateTxt(double[] point1, double[] point2, 
						  double[] point3, /*double perimeter, double area,*/
						  boolean[] type) 
							   throws ServiceException, URISyntaxException {

		assertArrayEquals(type, a.define(new File(getClass()
													 .getClassLoader()
													 .getResource("\\Triang"
													 			 + "leData.txt")
													 .toURI()).getAbsolutePath()
													 .toString(), 
											point1, point2, point3));
	}
	
	@ParameterizedTest
	@MethodSource("test.ipo.task4.service.impl.TriangleProvider#data")
	void testWrongCalculateTxt(double[] point1, double[] point2, 
							   double[] point3) 
										throws ServiceException, URISyntaxException {

		assertThrows(ServiceException.class, 
					 () -> a.define(new File(getClass().getClassLoader()
													 	  .getResource("\\Tria"
													 	  		+ "ngleData")
													 	  .toURI())
							 							  .getAbsolutePath()
							 							  .toString(), 
							 	       point1, point2, point3));
	}
	
	@ParameterizedTest
	@MethodSource("test.ipo.task4.service.impl.TriangleProvider#data")
	void testCalculateJson(double[] point1, double[] point2, 
						   double[] point3, double perimeter, double area,
						   boolean[] type)  
							   throws ServiceException, URISyntaxException {

		assertArrayEquals(type, a.define(new File(getClass()
													 .getClassLoader()
													 .getResource("\\Triang"
													 			 + "leData.json")
													 .toURI()).getAbsolutePath()
													 .toString(), 
											point1, point2, point3));
	}


}
