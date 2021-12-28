package test.ipo.task3part1.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

import by.ipo.task3part1.bean.Derivative;
import by.ipo.task3part1.bean.PropertyInsuranceCommitment;
import by.ipo.task3part1.service.exception.ServiceException;
import by.ipo.task3part1.service.impl.SortByRisk;

class SortByRiskTest {
	
	@Test
	void testSort() throws ServiceException, URISyntaxException {
		SortByRisk sbr = new SortByRisk();
		Derivative expected = new Derivative();
		try {
			expected.addCommitment(new PropertyInsuranceCommitment(786, 0.3));
			expected.addCommitment(new PropertyInsuranceCommitment(1560, 0.6));
			expected.addCommitment(new PropertyInsuranceCommitment(2684, 7));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertIterableEquals(expected.getDerivative(), 
							 sbr.sort(new File(this.getClass().getClassLoader()
							 						.getResource("\\der.json")
							 						.toURI()).toString())
					 								.getDerivative(),
					 		"Ошибка чтения файла");
	}
	
	@Test
	void testWrongGetCommitment() throws ServiceException, URISyntaxException {
		SortByRisk sbr = new SortByRisk();
		Derivative expected = new Derivative();
		try {
			expected.addCommitment(new PropertyInsuranceCommitment(786, 0.3));
			expected.addCommitment(new PropertyInsuranceCommitment(1560, 0.6));
			expected.addCommitment(new PropertyInsuranceCommitment(2684, 7));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertThrows(ServiceException.class, 
					() -> sbr.sort(new File(this.getClass().getClassLoader()
								 						.getResource("\\derWrong.json")
								 						.toURI()).toString()),
					"Должно выбрасывать ServiceException");
	}

}
