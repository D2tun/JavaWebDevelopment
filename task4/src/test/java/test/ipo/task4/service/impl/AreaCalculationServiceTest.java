package test.ipo.task4.service.impl;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.net.URISyntaxException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import by.ipo.task4.service.exception.ServiceException;
import by.ipo.task4.service.impl.AreaCalculationService;
import by.ipo.task4.service.impl.PerimeterCalculationService;

import org.junit.jupiter.api.Test;

class AreaCalculationServiceTest {

private AreaCalculationService a = AreaCalculationService.getInstance();
	
	@ParameterizedTest
	@MethodSource("test.ipo.task4.service.impl.TriangleProvider#data")
	void testCalculateTxt(double[] point1, double[] point2, 
					   double[] point3, double perimeter, double area) 
							   throws ServiceException, URISyntaxException {

		assertEquals(area, a.calculate(new File(getClass()
													 .getClassLoader()
													 .getResource("\\Triang"
													 			 + "leData.txt")
													 .toURI()).getAbsolutePath()
													 .toString(), 
											point1, point2, point3), 0.001);
	}
	
	@ParameterizedTest
	@MethodSource("test.ipo.task4.service.impl.TriangleProvider#data")
	void testWrongCalculateTxt(double[] point1, double[] point2, 
							   double[] point3) 
										throws ServiceException, URISyntaxException {

		assertThrows(ServiceException.class, 
					 () -> a.calculate(new File(getClass().getClassLoader()
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
						   double[] point3, double perimeter, double area) 
							   throws ServiceException, URISyntaxException {

		assertEquals(area, a.calculate(new File(getClass()
													 .getClassLoader()
													 .getResource("\\Triang"
													 			 + "leData.json")
													 .toURI()).getAbsolutePath()
													 .toString(), 
									   point1, point2, point3), 0.001);
	}

}
