package by.ipo.task2.dao.impl;

import by.ipo.task2.bean.Array;
import by.ipo.task2.dao.FileReader;
import by.ipo.task2.dao.exception.FileAccessException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;

/**
 * This class represents file reader, that reads file's text.
 * @author Pavel Isidovich
 *
 */
public class ArrayFileReaderImpl implements FileReader {
	
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();

	@Override
	public String readFile(String path) throws FileAccessException {
		try {
			
			return Files.readString(Paths.get(path));
			
		} catch (IOException e) {
			logger.error("Ошибка чтения файла");
			throw new FileAccessException();
		}
	}
}
