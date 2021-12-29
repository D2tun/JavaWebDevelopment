package by.ipo.task3part2.dao.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import by.ipo.task3part2.bean.ArtExhibition;
import by.ipo.task3part2.dao.DataOperator;
import by.ipo.task3part2.dao.exception.DAOException;

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
	 * @return array of type ArtExhibition
	 * @see ArtExhibition
	 */
	@Override
	public ArtExhibition[] readData(String path) throws DAOException {
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
		
		JsonArray jArray = jObject.get("artExhibitions").getAsJsonArray();
		ArtExhibition[] exhibitions = new ArtExhibition[jArray.size()];
		
		for (int i = 0; i < exhibitions.length; ++i) {
			exhibitions[i] = new ArtExhibition(jArray.get(i).getAsJsonObject().get("date").getAsString());
			JsonArray jPics = jArray.get(i).getAsJsonObject().get("pictures").getAsJsonArray();
			for (int j = 0; j < jPics.size(); ++j) {
				exhibitions[i].addPicture(exhibitions[i].new Picture(jPics.get(j).getAsJsonObject().get("picture").getAsString(), jPics.get(j).getAsJsonObject().get("author").getAsString()));
			}
		}
		
		logger.info("Ответ отправлен");
		
		return exhibitions;
	}
}
