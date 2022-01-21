package test.ipo.task4.service.impl;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import by.ipo.task4.service.exception.ServiceException;
import by.ipo.task4.service.impl.FindByIdService;
import by.ipo.task4.service.impl.TriangleLoader;
import by.ipo.task4.service.impl.TriangleRepository;

class FindByIdServiceTest {

	private FindByIdService a = FindByIdService.getInstance();
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
	@MethodSource("test.ipo.task4.service.impl.IdProvider#data")
	void testCalculate(int id) 
							   throws ServiceException, URISyntaxException {

		assertEquals(tr.find(id),
					 a.find(new File(getClass().getClassLoader()
														.getResource("\\Triang"
													 			 	+ "leData."
													 			 	+ "txt")
														.toURI())
							 							.getAbsolutePath()
							 							.toString(), id));
	}
		
	@ParameterizedTest
	@MethodSource("test.ipo.task4.service.impl.IdProvider#wrongData")
	void testCalculateWrong(int id) 
							   throws ServiceException, URISyntaxException {

		assertThrows(ServiceException.class,
					 () -> a.find(new File(getClass().getClassLoader()
														.getResource("\\Triang"
													 			 	+ "leData."
													 			 	+ "txt")
														.toURI())
							 							.getAbsolutePath()
							 							.toString(), id));
	}
	
	@ParameterizedTest
	@MethodSource("test.ipo.task4.service.impl.IdProvider#data")
	void testWrongCalculateWrongPath(int id) 
										throws ServiceException, 
											   URISyntaxException {

		assertThrows(ServiceException.class, 
					 () -> a.find(new File(getClass().getClassLoader()
													 	  .getResource("\\Tria"
													 	  			  + "ngle"
													 	  			  + "Data")
													 	  .toURI())
							 							  .getAbsolutePath()
							 							  .toString(), id));
	}

}
