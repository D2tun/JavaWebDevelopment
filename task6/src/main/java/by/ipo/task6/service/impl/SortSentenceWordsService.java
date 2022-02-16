package by.ipo.task6.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;

import by.ipo.task6.bean.Sentence;
import by.ipo.task6.bean.Text;
import by.ipo.task6.bean.Word;
import by.ipo.task6.dao.TextFileReader;
import by.ipo.task6.dao.exception.FileAccessException;
import by.ipo.task6.dao.factory.DAOFactory;
import by.ipo.task6.service.TextOperation;
import by.ipo.task6.service.exception.ServiceException;

/**
 * This class provides method to sort sentence's words by their 
 * lengths.
 * @author Pavel Isidovich
 *
 */
public class SortSentenceWordsService implements TextOperation {

	private static org.apache.logging.log4j
						.Logger logger = LogManager.getFormatterLogger();
	
	/**
	 * This method sorts words in text's sentences by their lengths.
	 * @param path - path to file
	 * @return sorted text as a string
	 * @throws ServiceException if file not found or can't be read
	 */
	public String sortByLength(String path) throws ServiceException {
		if (PathValidator.validate(path) == false) {
			logger.error("Неверный путь " + path);
			throw new ServiceException();
		}
		
		logger.trace("Данные получены");
		
		DAOFactory daof = DAOFactory.getInstance();
		TextFileReader tfr = daof.getTextFileReader();
		
		try {
			Text text = new Text(tfr.read(path));
			List<Sentence> sentences = text.getObSentences();
			List<Word> words = new ArrayList<>();
	
			String result = "";
			
			for (int j = 0; j < sentences.size(); ++j) {
				boolean iteration = true;
				words.addAll(sentences.get(j).getObWords());
				while (iteration == true) {
					iteration = false;
					for (int i = 1; i < words.size(); ++i) {
						if (words.get(i).getWords().get(0).length()
								< words.get(i - 1).getWords().get(0).length()) {
							Word tmp = words.get(i);
							words.set(i, words.get(i - 1));
							words.set(i - 1, tmp);
							iteration = true;
						}
					}
				}
				for (int i = 0; i < words.size(); ++i) {
					result += words.get(i).getWords().get(0) + " ";
				}
				result += "\n";
				words.clear();
			}
			
			logger.trace("Ответ отправлен");
			
			return result;
		} catch (FileAccessException e) {
			logger.error("Ошибка чтения файла " + path);
			throw new ServiceException();
		}
	}
}
