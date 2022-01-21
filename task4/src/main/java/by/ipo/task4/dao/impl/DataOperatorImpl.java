package by.ipo.task4.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.logging.log4j.LogManager;

import by.ipo.task4.bean.Triangle;
import by.ipo.task4.dao.DataOperator;
import by.ipo.task4.dao.exception.DAOException;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * This class provides methods to read triangle's information from
 * txt and json files
 * @author Pavel Isidovich
 * @see Triangle 
 */
public class DataOperatorImpl implements DataOperator {
	
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();

	/**
	 * This method reads data from txt-file.
	 * @param path - full file's name
	 * @return list of valid Triangle objects
	 * @see Triangle
	 */
	@Override
	public List<String> readTxtData(String path) throws DAOException {
		try {
			List<String> data = Files.readAllLines(Paths.get(path));
			logger.debug("Файл " + path + " прочитан успешно");
			return data;
		} catch (IOException e) {
			throw new DAOException();
		}
	}

	/**
	 * This method reads data from json-file.
	 * @param path - full file's name
	 * @return list of valid Triangle objects
	 * @see Triangle
	 */
	@Override
	public JsonElement readJsonData(String path) throws DAOException {
		logger.trace("Данные получены");
		
		File input = new File(path);
		JsonElement je = null;
		
		try {
			je = JsonParser.parseReader(new FileReader(input));
			logger.debug("Файл " + path + " прочитан успешно");
			return je;
		} catch (JsonIOException | JsonSyntaxException 
					| FileNotFoundException e1) {
			throw new DAOException();
		}
	}
}
