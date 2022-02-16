package by.ipo.task6.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import by.ipo.task6.bean.Paragraph;
import by.ipo.task6.bean.Text;
import by.ipo.task6.dao.TextFileReader;
import by.ipo.task6.dao.exception.FileAccessException;
import by.ipo.task6.dao.factory.DAOFactory;
import by.ipo.task6.service.TextOperation;
import by.ipo.task6.service.exception.ServiceException;

/**
 * This class provides method to sort text's paragraphs by the number
 * of sentences.
 * @author Pavel Isidovich
 *
 */
public class SortParagraphsService implements TextOperation {

	private static org.apache.logging.log4j
						.Logger logger = LogManager.getFormatterLogger();
	
	/**
	 * This method sorts text's paragraphs by the number of sentences.
	 * @param path - path to file
	 * @return string with sorted paragraphs
	 * @throws ServiceException if file not found or can't be read
	 */
	public String sortBySentencesNumber(String path) 
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
			List<Paragraph> paragraphs = text.getObParagraphs();
			
			boolean iteration = true;
			while (iteration == true) {
				iteration = false;
				for (int i = 1; i < paragraphs.size(); ++i) {
					if (paragraphs.get(i).getSentences().size() 
							< paragraphs.get(i - 1).getSentences().size()) {
						Paragraph tmp = paragraphs.get(i);
						paragraphs.set(i, paragraphs.get(i - 1));
						paragraphs.set(i - 1, tmp);
						iteration = true;
					}
				}
			}
		
			String result = "";
			
			for (int i = 0; i < paragraphs.size(); ++i) {
				result += paragraphs.get(i).getParagraphs().get(0) + "\n";
			}
			
			logger.trace("Ответ отправлен");
			
			return result;
		} catch (FileAccessException e) {
			logger.error("Ошибка чтения файла " + path);
			throw new ServiceException();
		}	
	}
}
