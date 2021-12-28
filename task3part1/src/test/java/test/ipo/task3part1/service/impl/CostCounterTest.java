package test.ipo.task3part1.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

import by.ipo.task3part1.service.exception.ServiceException;
import by.ipo.task3part1.service.impl.CostCounter;

class CostCounterTest {
	
	@Test
	void testGetTotalCost() throws ServiceException, URISyntaxException {
		CostCounter cc = new CostCounter();
		int expected = 5030;
		assertEquals(expected, 
					 cc.getTotalCost(new File(this.getClass().getClassLoader()
							 .getResource("\\der.json").toURI()).toString()),
					 "Ошибка чтения файла");
	}
	
	@Test
	void testWrongGetTotalCost() throws ServiceException, URISyntaxException {
		CostCounter cc = new CostCounter();
		assertThrows(ServiceException.class, 
					 	() -> cc.getTotalCost(new File(this.getClass()
					 			.getClassLoader()
					 			.getResource("\\derWrong.json").toURI())
					 			.toString()),
					 	"При чтении пореждённых данных или отсутствии целевого "
					 	+ "файла должно выбрасываться ServiceException.");
	}

}
