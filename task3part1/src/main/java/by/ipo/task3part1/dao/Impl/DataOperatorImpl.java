package by.ipo.task3part1.dao.Impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import by.ipo.task3part1.bean.Commitment;
import by.ipo.task3part1.bean.Derivative;
import by.ipo.task3part1.bean.PropertyInsuranceCommitment;
import by.ipo.task3part1.dao.DataOperator;
import by.ipo.task3part1.dao.exception.DAOException;

/**
 * This class provides method to read Json file.
 * @author Pavel Isidovich
 *
 */
public class DataOperatorImpl implements DataOperator {
	
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();

	/**
	 * This class reads data from Json file.
	 * @param path - full file name
	 * @return object of type Derivative
	 * @see Derivative
	 */
	@Override
	public Derivative readData(String path) throws DAOException {
		logger.info("Данные получено");
		
		File input = new File(path);
		
		JsonElement jElement = null;
		
		try {
			jElement = JsonParser.parseReader(new FileReader(input));
			logger.info("Файл прочитан успешно");
		} catch (JsonIOException | JsonSyntaxException 
					| FileNotFoundException e1) {
			logger.error("Ошибка чтения файла");
			throw new DAOException();
		}
		
		JsonObject jObject = jElement.getAsJsonObject();
		
		JsonArray jArray = jObject.get("Commitments").getAsJsonArray();
		Derivative d = new Derivative();
		
		for (int i = 0; i < jArray.size(); ++i) {
			try {
				
				switch (jArray.get(i).getAsJsonObject().get("insuranceType")
							.getAsString()) {
				case "propertyInsurance":
					d.addCommitment(new PropertyInsuranceCommitment(jArray
															.get(i)
															.getAsJsonObject()
															.get("cost").getAsInt(), 
																    jArray
															.get(i).getAsJsonObject()
															.get("riskCoefficient")
															.getAsDouble()));
					break;
					
				case "lifeInsurance":
					d.addCommitment(new PropertyInsuranceCommitment(jArray
															.get(i)
															.getAsJsonObject()
															.get("cost").getAsInt(), 
																    jArray
															.get(i).getAsJsonObject()
															.get("riskCoefficient")
															.getAsDouble()));
					break;
				
				case "estateInsurance":
					d.addCommitment(new PropertyInsuranceCommitment(jArray
															.get(i)
															.getAsJsonObject()
															.get("cost").getAsInt(), 
																    jArray
															.get(i).getAsJsonObject()
															.get("riskCoefficient")
															.getAsDouble()));
					break;
					
				default:
					logger.error("Ошибка чтения файла");
					throw new DAOException();
				}
				
			} catch (IOException e) {
				logger.error("Ошибка формирования ответа");
				throw new DAOException();
			}
		}
		
		logger.info("Ответ отправлен");
		
		return d;
	}
}
