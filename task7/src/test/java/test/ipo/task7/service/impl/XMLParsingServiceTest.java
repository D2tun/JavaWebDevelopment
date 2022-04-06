package test.ipo.task7.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import by.ipo.task7.service.exception.ServiceException;
import by.ipo.task7.service.impl.XMLParsingService;

class XMLParsingServiceTest {

	XMLParsingService xps = new XMLParsingService();

	@Test
	void test() throws ServiceException {
		assertEquals(
				this.xps.parseXML(getClass().getClassLoader()
						.getResource("xml/gym.xml").getPath(), "DOM"),
				this.xps.parseXML(getClass().getClassLoader()
						.getResource("xml/gym.xml").getPath(), "SAX"));
		;
	}

	@Test
	void test2() throws ServiceException {
		assertEquals(
				this.xps.parseXML(getClass().getClassLoader()
						.getResource("xml/gym.xml").getPath(), "SAX"),
				this.xps.parseXML(getClass().getClassLoader()
						.getResource("xml/gym.xml").getPath(), "StAX"));
	}

	@Test
	void testWrong() throws ServiceException {
		assertThrows(ServiceException.class,
					() -> xps.parseXML(
						getClass().getClassLoader()
								.getResource("xml/gymWrong.xml").getPath(),
						"DOM"));
	}
}
