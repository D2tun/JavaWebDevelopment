package by.ipo.task6.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;

import by.ipo.task6.bean.Lexeme;
import by.ipo.task6.bean.Text;
import by.ipo.task6.dao.TextFileReader;
import by.ipo.task6.dao.exception.FileAccessException;
import by.ipo.task6.dao.factory.DAOFactory;
import by.ipo.task6.service.TextOperation;
import by.ipo.task6.service.exception.ServiceException;

/**
 * This class provides method to sort text's lexemes by number of 
 * entered symbol in them.
 * @author Pavel Isidovich
 *
 */
public class SortTextLexemesService implements TextOperation {

	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	/**
	 * This method sorts text's lexemes by number of entered symbol 
	 * in them. If this number is equal, then it sorts lexemes by 
	 * alphabet order.
	 * @param path - path to file
	 * @param symbol - entered symbol
	 * @return result of sorting as a string
	 * @throws ServiceException if file not found or can't be read
	 */
	public String sortByEnteredSymbol(String path, String symbol) 
					throws ServiceException {
		if (PathValidator.validate(path) == false) {
			logger.error("Неверный путь " + path);
			throw new ServiceException();
		}
		
		logger.trace("Данные получены");
		
		DAOFactory daof = DAOFactory.getInstance();
		TextFileReader tfr = daof.getTextFileReader();
		
		try {
			Text text = new Text(tfr.read(path));
			List<Lexeme> lexemes = text.getObLexemes();
			int[] symbolCounters = new int[lexemes.size()];
			
	
			String result = "";
			
			for (int i = 0; i < lexemes.size(); ++i) {
				Matcher m = Pattern.compile(symbol).matcher(lexemes.get(i)
																	.getLexemes()
																	.get(0));
				while (m.find()) {
					++symbolCounters[i];
					
				}
			}
			
			boolean iteration = true;
			while (iteration == true) {
				iteration = false;
				for (int i = 1; i < lexemes.size(); ++i) {
					if (symbolCounters[i - 1] < symbolCounters[i]) {
						Lexeme tmp = lexemes.get(i - 1);
						lexemes.set(i - 1, lexemes.get(i));
						lexemes.set(i, tmp);
						int tmp2 = symbolCounters[i - 1];
						symbolCounters[i - 1] = symbolCounters[i];
						symbolCounters[i] = tmp2;
						iteration = true;	
					} else if (symbolCounters[i] == symbolCounters[i - 1]) {
						if (lexemes.get(i - 1).getLexemes().get(0)
								.compareTo(lexemes
										.get(i)
										.getLexemes()
										.get(0)) 
							> 0) {
						Lexeme tmp = lexemes.get(i);
						lexemes.set(i, lexemes.get(i - 1));
						lexemes.set(i - 1, tmp);
						int tmp2 = symbolCounters[i];
						symbolCounters[i] = symbolCounters[i - 1];
						symbolCounters[i - 1] = tmp2;
						iteration = true;
						}
					} 
				}
			}
			
			for (int i = 0; i < lexemes.size(); ++i) {
				result += lexemes.get(i).getLexemes().get(0) + " ";
			}
			
			logger.trace("Ответ отправлен");
			
			return result;
		} catch (FileAccessException e) {
			logger.error("Ошибка чтения файла " + path);
			throw new ServiceException();
		}
	}
}
