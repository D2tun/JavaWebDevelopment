package by.ipo.task6.bean;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.ipo.task6.dao.impl.TextFileReaderImpl;
import by.ipo.task6.service.impl.SortParagraphsService;
import by.ipo.task6.service.impl.SortSentenceWordsService;
import by.ipo.task6.service.impl.SortTextLexemesService;
import by.ipo.task6.service.impl.TextRecoverService;

public class test {

	public static void main(String[] args) throws IOException {
//System.out.println(new Text(new TextFileReaderImpl().read("D:\\JWD\\task6\\src\\main\\resources\\text.txt")).getSymbols()/*.getObSentences().get(0).getObWords().size()*/);
		//System.out.println((71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78);
		
		//+System.out.println(new SortParagraphsService().sortBySentencesNumber("D:\\JWD\\task6\\src\\main\\resources\\text.txt"));
		//+System.out.println(new SortSentenceWordsService().sortByLength("D:\\JWD\\task6\\src\\main\\resources\\text.txt"));
		//+System.out.println(new SortTextLexemesService().sortByEnteredSymbol("D:\\JWD\\task6\\src\\main\\resources\\text.txt", "a"));
		//+System.out.println(new TextRecoverService().recover("D:\\JWD\\task6\\src\\main\\resources\\text.txt"));
		
		//System.out.println(new Text(new TextFileReaderImpl().read("D:\\JWD\\task6\\src\\main\\resources\\text.txt")).getObParagraphs().get(2).getParagraphs().get(0));
		
		//System.out.println(new TextFileReaderImpl().read("D:\\JWD\\task6\\src\\main\\resources\\text.txt"));
	}

}
//task6/src/main/resources/text.txt