package test.ipo.task4.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import by.ipo.task4.bean.Triangle;
import by.ipo.task4.service.exception.ServiceException;
import by.ipo.task4.service.impl.SortFirstXService;
import by.ipo.task4.service.impl.TriangleLoader;
import by.ipo.task4.service.impl.TriangleRepository;

class SortFirstXServiceTest {

	private SortFirstXService a = SortFirstXService.getInstance();
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
	
	@Test
	void test() throws ServiceException, URISyntaxException {
		List<Triangle> expected = tr.giveContent();
		expected.set(0, tr.find(2));
		expected.set(1, tr.find(1));

		assertEquals(expected, a.sort(new File(getClass()
												.getClassLoader()
														.getResource("\\Triang"
														 			 + "leData.txt")
														.toURI()).getAbsolutePath()
														.toString()));
	}

}
