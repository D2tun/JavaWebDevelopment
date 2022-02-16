package test.ipo.task6.service.impl;

import java.io.File;
import java.net.URISyntaxException;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.ipo.task6.service.exception.ServiceException;
import by.ipo.task6.service.impl.SortParagraphsService;

public class SortParagraphsServiceTest {

	@Test
  	public void sortBySentencesNumberTest() throws ServiceException, 
  												   URISyntaxException {
		String expected = "	It is a (8^5|1&2<<(2|5>>2&71))|1200 established "
						+ "fact that a reader will be of a page when looking "
						+ "at its layout.\n	Bye.\n	It has survived - not only "
						+ "(five) centuries, but also the leap into 13<<2 "
						+ "electronic typesetting, remaining 30>>>3 essentially "
						+ "~6&9|(3&4) unchanged.  It was popularised in the "
						+ "5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1) with the release "
						+ "of Letraset sheets containing Lorem Ipsum passages, "
						+ "and more recently with desktop publishing software "
						+ "like Aldus PageMaker including versions of Lorem "
						+ "Ipsum.\n	It is a long established fact that a reader "
						+ "will be distracted by the readable content of a page "
						+ "when looking at its layout.  The point of using "
						+ "(~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 Ipsum is that "
						+ "it has a more-or-less normal distribution of "
						+ "letters, as opposed to using (Content here), content "
						+ "here', making it look like readable English.";
		
		Assert.assertEquals(new SortParagraphsService()
									.sortBySentencesNumber(new File(getClass()
															.getClassLoader()
															.getResource("text"
																		+ ".t"
																		+ "xt")
															.toURI()).toString()), 
							expected);
	}
	
	@Test
	public void sortBySentencesWrongTest() throws ServiceException, 
												  URISyntaxException {
		Assert.assertEquals(new SortParagraphsService()
									.sortBySentencesNumber("wge"), 
							new ServiceException());	
	}
}
