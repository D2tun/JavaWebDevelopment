package by.ipo.task5.service.impl;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.LogManager;

import by.ipo.task5.bean.Matrix;
import by.ipo.task5.dao.FileReader;
import by.ipo.task5.dao.factory.DAOFactory;
import by.ipo.task5.service.exception.ServiceException;

/**
 * This class provides method to convert string being read to a 
 * matrix
 * @author Pavel Isidovich
 * @see Matrix
 */
public class MatrixReader {

	private static org.apache.logging.log4j
						.Logger logger = LogManager.getFormatterLogger();
	
	public static Matrix readMatrix(String path) throws ServiceException {
		
		ReentrantLock locker = new ReentrantLock();
		DAOFactory daof = DAOFactory.getInstance();
		FileReader afr = daof.getArrayFileReader();
		
		try {
			locker.lock();
			String content = afr.readFile(path);
			locker.unlock();
			String[] strings = content.split("%");
			Double[][] preMatrix = new Double[strings.length]
											  [strings[0].split(" ").length];
		
			for (int i = 0; i < strings.length; ++i) {
				String[] elementSet = strings[i].split(" ");
				for (int j = 0; j < elementSet.length; ++j) {
					preMatrix[i][j] = Double.parseDouble(elementSet[j]);
				}
			}
			 
			Matrix matrix = new Matrix(preMatrix.length, 
										preMatrix[0].length);
			
			for (int i = 0; i < preMatrix.length; ++i) {
				for (int j = 0; j < preMatrix[0].length; ++j) {
					matrix.setElement(i, j, preMatrix[i][j]);
				}
			}
			

			
			logger.info("Ответ отправлен");
			
			return matrix;
		} catch (IOException e) {
			logger.error("Ошибка операции");
			throw new ServiceException();
		}
	}
}
