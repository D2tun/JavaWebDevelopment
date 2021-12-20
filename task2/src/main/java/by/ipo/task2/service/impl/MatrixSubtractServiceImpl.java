package by.ipo.task2.service.impl;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;

import by.ipo.task2.bean.Matrix;
import by.ipo.task2.dao.ArrayFileReader;
import by.ipo.task2.dao.factory.DAOFactory;
import by.ipo.task2.service.MatrixOperationService;
import by.ipo.task2.service.exception.ServiceException;

/**
 * This class provides method to subtract matrixes
 * @author Pavel Isidovich
 *
 */
public class MatrixSubtractServiceImpl implements MatrixOperationService {
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
		if (!path1.matches("([A-Za-z]{1}:{1}\\\\{1}){1}([^|?/:\"<>*]*\\\\{1})*"
						   + "[^|?/:\\\"<>*]{1,}(\\.txt){1}")
				&& !path2.matches("([A-Za-z]{1}:{1}\\\\{1}){1}([^|?/:\"<>*]*"
								 + "\\\\{1})*[^|?/:\\\"<>*]{1,}(\\.txt){1}")) {
			throw new ServiceException();
		}
	
		logger.info("Данные получены");
	
		DAOFactory daof = DAOFactory.getInstance();
		ArrayFileReader afr = daof.getArrayFileReader();
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
	
			if ((preMatrix1.length != preMatrix2.length) 
					|| (preMatrix1[0].length != preMatrix2[0].length)) {
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
	
			Matrix matrix1 = new Matrix(preMatrix1.length, preMatrix1[0].length); 
			Matrix matrix2 = new Matrix(preMatrix2.length, preMatrix2[0].length);
	
			matrix1.setMatrix(preMatrix1);
			matrix2.setMatrix(preMatrix2);
	
			Matrix<Double> result = new Matrix(matrix1.getColumnLength(), 
											   matrix1.getStringLength());
	
			for (int i = 0; i < result.getColumnLength(); ++i) {
				for (int j = 0; j < result.getStringLength(); ++j) {
					result.setElement(i, j, matrix1.getElement(i, j) 
											- matrix2.getElement(i, j));
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
