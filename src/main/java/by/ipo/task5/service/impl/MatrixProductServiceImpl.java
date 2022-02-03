package by.ipo.task5.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;

import by.ipo.task5.bean.Matrix;
import by.ipo.task5.service.MatrixOperationService;
import by.ipo.task5.service.exception.ServiceException;

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
			logger.error("Неверные пути к файлу или расширение: " + path1 
						+ ", " + path2);
			throw new ServiceException();
		}
		
		Matrix<Double> matrix1 = MatrixReader.readMatrix(path1);
		Matrix<Double> matrix2 = MatrixReader.readMatrix(path2);
		
		logger.trace("Данные получены");
		
		if ((matrix1.getRowLength() != matrix2.getColumnLength()) 
				|| (matrix1.getColumnLength() != matrix2.getRowLength())) {
			logger.debug("Несоответствие размеров матриц");
			throw new ServiceException();
		}	

		 Matrix<Double> result = new Matrix(matrix1.getColumnLength(), 
				 							matrix2.getRowLength());
		

		List<Thread> calcThreads = new ArrayList<>();
		
		for (int i = 0; i < result.getColumnLength(); ++i) {
			for (int j = 0; j < result.getRowLength(); ++j) {
				Thread calc = new Thread(new MatrixProductionElementCalc(
											matrix1, matrix2, result, 
											new int[] {i, j})
							  			);
				calc.start();
				calcThreads.add(calc);
			}
		}
		
		for (int i = 0; i < calcThreads.size(); ++i) {
			try {
				calcThreads.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
				
		logger.trace("Ответ отправлен");
		
		return result;
	}
}
