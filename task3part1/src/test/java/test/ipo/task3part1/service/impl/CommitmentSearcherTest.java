package test.ipo.task3part1.service.impl;



import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;

import by.ipo.task3part1.bean.Derivative;
import by.ipo.task3part1.bean.PropertyInsuranceCommitment;
import by.ipo.task3part1.service.exception.ServiceException;
import by.ipo.task3part1.service.impl.CommitmentSearcher;

class CommitmentSearcherTest {

	@Test
	void testGetCommitment() throws ServiceException, URISyntaxException {
		CommitmentSearcher cs = new CommitmentSearcher();
		int cost = 1560;
		double risk = 0.6;
		Derivative expected = new Derivative();
		try {
			expected.addCommitment(new PropertyInsuranceCommitment(cost, risk));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertIterableEquals(expected.getDerivative(), 
					 cs.getCommitment(new File(this.getClass().getClassLoader()
							 						.getResource("\\der.json")
							 						.toURI()).toString(), cost, 
							 											  risk)
					 								.getDerivative(),
					 "Ошибка чтения файла");
	}
	
	@Test
	void testWrongGetCommitment() throws ServiceException, URISyntaxException {
		CommitmentSearcher cs = new CommitmentSearcher();
		int cost = 1560;
		double risk = 0.6;
		Derivative expected = new Derivative();
		try {
			expected.addCommitment(new PropertyInsuranceCommitment(cost, risk));
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertThrows(ServiceException.class, 
					() -> cs.getCommitment(new File(this.getClass().getClassLoader()
								 						.getResource("\\derWrong.json")
								 						.toURI()).toString(), cost, 
								 											  risk),
					"Должно выбрасывать ServiceException");
	}
}
