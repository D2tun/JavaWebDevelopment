package by.ipo.task6.dao.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;

import by.ipo.task6.dao.TextFileReader;
import by.ipo.task6.dao.exception.FileAccessException;

/**
 * This class provides method to read text from file.
 * @author Pavel Isidovich
 *
 */
public class TextFileReaderImpl implements TextFileReader {

	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	@Override
	public String read(String path) throws FileAccessException {
		try {
			return Files.readString(Paths.get(path));
		} catch (IOException e) {
			logger.error("Ошибка чтения файла " + path);
			throw new FileAccessException();
		}
	}
}
