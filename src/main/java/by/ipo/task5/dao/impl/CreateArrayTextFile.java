package by.ipo.task5.dao.impl;

import by.ipo.task5.dao.CreateFile;
import by.ipo.task5.dao.exception.FileAccessException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;

/**
 * This class provides method to create file and write data for array
 * in it.
 * @author Pavel Isidovich
 *
 */
public class CreateArrayTextFile implements CreateFile {
	
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	/**
	 * This method creates file and writes array data in it.
	 * Directories, pointed in <strong>path</strong>, which are 
	 * absent, will be created.
	 * @throws FileAccessException 
	 */
	@Override
	public void create(String path, String data) throws FileAccessException {
		
		try (BufferedWriter bw = 
				new BufferedWriter(new FileWriter(path))) {
			if (!Files.exists(Paths.get(path))) {
				Files.createDirectories(Paths.get(path));
				Files.createFile(Paths.get(path));
			}
			bw.append(data);
			bw.flush();
			logger.info("Файл успешно создан: " + path);
		} catch(IOException e) {
			logger.error("Ошибка при создании файла");
			throw new FileAccessException();
		}
	}
}
