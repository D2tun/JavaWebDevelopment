package by.ipo.task2.service.impl;

import org.apache.logging.log4j.LogManager;

import by.ipo.task2.dao.exception.FileAccessException;
import by.ipo.task2.dao.factory.DAOFactory;
import by.ipo.task2.dao.impl.CreateArrayTextFile;
import by.ipo.task2.service.FileCreatingService;
import by.ipo.task2.service.exception.ServiceException;

/**
 * This class provides method to request text file creation.
 * @author Pavel Isidovich
 *
 */
public class FileCreatingServiceImpl implements FileCreatingService {

	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	@Override
	public void requestCreation(String path, int length) throws ServiceException {
		
			if (path.matches("([A-Za-z]{1}:{1}\\\\{1}){1}([^|?/:\"<>*]*\\\\{1})*[^|?/:\\\"<>*]{1,}(\\.txt){1}")) {

				logger.info("Данные получены");
				
				DAOFactory daof = DAOFactory.getInstance();
				CreateArrayTextFile catf = daof.getCreateArrayTextFile();
				String data = "";
				
				for (int i = 0; i < length; ++i) {
					data += (StrictMath.random() * Double.MAX_VALUE 
							- Double.MAX_VALUE / 2) + " ";
				}
				
				try {
					catf.create(path, data);
					logger.info("Файл создан");
				} catch (FileAccessException e) {
					logger.error("Ошибка создания файла");
					throw new ServiceException();
				}
		} else {
			logger.error("Ошибка создания файла");
			throw new ServiceException();
		}
	}
}
