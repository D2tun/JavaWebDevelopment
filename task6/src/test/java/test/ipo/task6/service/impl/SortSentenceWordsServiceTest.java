package test.ipo.task6.service.impl;

import java.io.File;
import java.net.URISyntaxException;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.ipo.task6.service.exception.ServiceException;
import by.ipo.task6.service.impl.SortSentenceWordsService;

public class SortSentenceWordsServiceTest {

	@Test
  	public void sortByLengthTest() throws ServiceException, 
  										  URISyntaxException {
		String expected = "It has not but the only also leap into 13<<2 (five) "
						  + "30>>>3 survived centuries remaining unchanged "
						  + "electronic ~6&9|(3&4) typesetting essentially \r"
						  + "\nIt in of of was the the and with more with like "
						  + "Lorem Ipsum Aldus Lorem Ipsum sheets release "
						  + "desktop Letraset passages recently software "
						  + "versions PageMaker including containing publishing"
						  + " popularised 5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1) "
						  + "\r\na a a It is be by of at the its long fact that"
						  + " will page when reader layout content looking"
						  + " readable distracted established \r\na of is it of"
						  + " as to it The has that look like point using Ipsum"
						  + " using here) here' normal making letters opposed "
						  + "content English (Content readable more-or-less "
						  + "distribution (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 "
						  + "\r\na a a It is be of at its fact that will page "
						  + "when reader layout looking established "
						  + "(8^5|1&2<<(2|5>>2&71))|1200 \r\nBye ";
		
		Assert.assertEquals(new SortSentenceWordsService()
									.sortByLength(new File(getClass()
															.getClassLoader()
															.getResource("text"
																		+ ".t"
																		+ "xt")
															.toURI()).toString()), 
							expected);
	}
	
	@Test
	public void sortByLengthWrongTest() throws ServiceException, 
											   URISyntaxException {
		Assert.assertEquals(new SortSentenceWordsService()
									.sortByLength("wge"), 
							new ServiceException());	
	}
}
