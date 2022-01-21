package test.ipo.task4.service.impl;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import by.ipo.task4.bean.Point;
import by.ipo.task4.service.exception.ServiceException;
import by.ipo.task4.service.impl.FindByPointsService;
import by.ipo.task4.service.impl.TriangleLoader;
import by.ipo.task4.service.impl.TriangleRepository;

class FindByPointsServiceTest {

	private FindByPointsService a = FindByPointsService.getInstance();
	private TriangleRepository tr = TriangleRepository.getInstance();
	
	@BeforeEach
	public void repInit() {
		try {
			TriangleLoader.load(new File(getClass().getClassLoader()
														.getResource("\\Triang"
														 			 + "leData.txt")
														.toURI()).getAbsolutePath()
														.toString(), tr);
		} catch (ServiceException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	@ParameterizedTest
	@MethodSource("test.ipo.task4.service.impl.TriangleProvider#data")
	void testCalculateTxt(double[] point1, double[] point2, 
					 	  double[] point3) 
							   throws ServiceException, URISyntaxException {

		assertEquals(tr.find(new Point[] {new Point(point1[0], point1[1]),
										  new Point(point2[0], point2[1]), 
										  new Point(point3[0], point3[1])}),
					 a.find(new File(getClass().getClassLoader()
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
										throws ServiceException, 
											   URISyntaxException {

		assertThrows(ServiceException.class, 
					 () -> a.find(new File(getClass().getClassLoader()
													 	  .getResource("\\Tria"
													 	  			  + "ngle"
													 	  			  + "Data")
													 	  .toURI())
							 							  .getAbsolutePath()
							 							  .toString(), 
							 	       point1, point2, point3));
	}
	
	@ParameterizedTest
	@MethodSource("test.ipo.task4.service.impl.TriangleProvider#data")
	void testCalculateJson(double[] point1, double[] point2, 
						   double[] point3) 
							   throws ServiceException, URISyntaxException {

		assertEquals(tr.find(new Point[] {new Point(point1[0], point1[1]),
										  new Point(point2[0], point2[1]), 
										  new Point(point3[0], point3[1])}),
					 a.find(new File(getClass().getClassLoader()
							 						.getResource("\\Triang"
							 									+ "leData.json")
							 						.toURI()).getAbsolutePath()
							 						.toString(), 
					 point1, point2, point3));
	}
	
	@ParameterizedTest
	@MethodSource("test.ipo.task4.service.impl.TriangleProvider#data")
	void testWrongCalculateNull(double[] point1, double[] point2, 
							    double[] point3) 
									throws ServiceException, URISyntaxException {
		point3[0] = 0;
		point3[1] = 0;
		assertNull(a.find(new File(getClass().getClassLoader()
												.getResource("\\TriangleData.js"
															+ "on")
												.toURI()).getAbsolutePath()
												.toString(), 
						  point1, point2, point3));
	}

}
