package test.ipo.task6.service.impl;

import java.io.File;
import java.net.URISyntaxException;

import org.testng.Assert;
import org.testng.annotations.Test;

import by.ipo.task6.service.exception.ServiceException;
import by.ipo.task6.service.impl.SortSentenceWordsService;
import by.ipo.task6.service.impl.SortTextLexemesService;

public class SotTextLexemesService {

	@Test
  	public void sortByLengthTest() throws ServiceException, 
  										  URISyntaxException {
		String expected = "PageMaker passages, readable readable Letraset a a "
						  + "a a a a a also and as at at containing distracted "
						  + "essentially established established fact fact has"
						  + " has layout. layout. leap making normal page page"
						  + " popularised reader reader release remaining "
						  + "software that that that unchanged. was "
						  + "(8^5|1&2<<(2|5>>2&71))|1200 (Content (five) "
						  + "(~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78 - 13<<2 "
						  + "30>>>3 5|(1&2&(3|(4&(25^5|6&47)|3)|2)|1) Aldus "
						  + "Bye. English. Ipsum Ipsum Ipsum. It It It It Lorem"
						  + " Lorem The be be but by centuries, content content"
						  + " desktop distribution electronic here', here), in "
						  + "including into is is is it it its its letters, "
						  + "like like long look looking looking more "
						  + "more-or-less not of of of of of of only opposed "
						  + "point publishing recently sheets survived the the "
						  + "the the to typesetting, using using versions when "
						  + "when will will with with ~6&9|(3&4) \r\n";
		
		Assert.assertEquals(new SortTextLexemesService().sortByEnteredSymbol(
															new File(getClass()
															 .getClassLoader()
															 .getResource("text"
																 		 + ".t"
																		 + "xt")
															 .toURI())
															 .toString(), "a"), 
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
