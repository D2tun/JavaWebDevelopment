package by.ipo.task2.service.impl;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;

import by.ipo.task2.bean.Matrix;
import by.ipo.task2.dao.FileReader;
import by.ipo.task2.dao.factory.DAOFactory;
import by.ipo.task2.service.MatrixOperationService;
import by.ipo.task2.service.exception.ServiceException;

/**
 * This class provides method to sum matrixes
 * @author Pavel Isidovich
 *
 */
public class MatrixProductServiceImpl implements MatrixOperationService {

	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();

	/**
	* This method sums two matrixes
	* @param path1 - math to file with first matrix
	* @param path2 - math to file with second matrix
	* @throws ServiceException if matrixes aren't got same size or
	* file wasn't found.
	* @see Matrix
	*/
	@Override
	public Matrix calculate(String path1, String path2) throws ServiceException {

		if (!PathValidator.validateTXT(path1) 
				&& !PathValidator.validateTXT(path2)) {
			throw new ServiceException();
		}

		logger.info("Данные получены");

		DAOFactory daof = DAOFactory.getInstance();
		FileReader afr = daof.getArrayFileReader();
		String content1;
		String content2;
	
		try {
			content1 = afr.readFile(path1);
			content2 = afr.readFile(path2);
			String[] strings1 = content1.split("%");
			String[] strings2 = content2.split("%");
			Double[][] preMatrix1 = new Double[strings1.length]
											  [strings1[0].split(" ").length];
			Double[][] preMatrix2 = new Double[strings2.length]
					  						  [strings2[0].split(" ").length];
			
			if ((preMatrix1.length != preMatrix2[0].length) 
					|| (preMatrix1[0].length != preMatrix2.length)) {
				throw new ServiceException();
			}
			
			
			for (int i = 0; i < strings1.length; ++i) {
				String[] elementSet1 = strings1[i].split(" ");
				String[] elementSet2 = strings2[i].split(" ");
				for (int j = 0; j < elementSet1.length; ++j) {
					preMatrix1[i][j] = Double.parseDouble(elementSet1[j]);
					preMatrix2[i][j] = Double.parseDouble(elementSet2[j]);
				}
			}
			 
			Matrix matrix1 = new Matrix(preMatrix1.length, 
										preMatrix1[0].length);
			Matrix matrix2 = new Matrix(preMatrix2.length, 
					 					preMatrix2[0].length);
			
			for (int i = 0; i < preMatrix1.length; ++i) {
				for (int j = 0; j < preMatrix1[0].length; ++j) {
					matrix1.setElement(i, j, preMatrix1[i][j]);
				}
			}
			for (int i = 0; i < preMatrix2.length; ++i) {
				for (int j = 0; j < preMatrix2[0].length; ++j) {
					matrix2.setElement(i, j, preMatrix2[i][j]);
				}
			}
			
			Matrix<Double> result = new Matrix(matrix1.getColumnLength(), 
				 							matrix2.getRowLength());
			double resultElement = 0;
			
			for (int i = 0; i < matrix1.getColumnLength(); ++i) {
				for (int j = 0; j < matrix2.getRowLength(); ++j) {
					for (int k = 0; k < matrix1.getColumnLength(); ++k) {
					resultElement += result.getElement(i, k) 
					     		* result.getElement(k, i);
					}
				result.setElement(i, j, resultElement);
				}
			}
			
			logger.info("Ответ отправлен");
			
			return result;
		} catch (IOException e) {
			logger.error("Ошибка операции");
			throw new ServiceException();
		}
	}
}
