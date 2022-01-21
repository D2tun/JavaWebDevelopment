package by.ipo.task4.dao;

import java.util.List;

import com.google.gson.JsonElement;

import by.ipo.task4.dao.exception.DAOException;

/**
 * This interface provides methods to read from file.
 * @author Pavel Isidovich
 *
 */
public interface DataOperator {
	
	public List<String> readTxtData(String path) throws DAOException;
	public JsonElement readJsonData(String path) throws DAOException;

}
