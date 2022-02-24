package by.ipo.task5.service.impl;

import org.apache.logging.log4j.LogManager;

import by.ipo.task5.bean.Matrix;
import by.ipo.task5.service.MatrixOperationService;
import by.ipo.task5.service.exception.ServiceException;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * This class provides method to sum matrixes
 * @author Pavel Isidovich
 *
 */
public class MatrixSumServiceImpl implements MatrixOperationService {

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
		
		logger.trace("Данные получены");
			
		Matrix<Double> matrix1 = MatrixReader.readMatrix(path1); 
		Matrix<Double> matrix2 = MatrixReader.readMatrix(path2);
			
		if ((matrix1.getRowLength() != matrix2.getRowLength()) 
				|| (matrix1.getColumnLength() != matrix2.getColumnLength())) {
			logger.debug("Несоответствие размеров матриц");
			throw new ServiceException();
		}
		
		Matrix<Double> result = new Matrix<>(matrix1.getColumnLength(), 
											 matrix1.getRowLength());	

		CopyOnWriteArrayList<Integer[]> indexList 
										= new CopyOnWriteArrayList<>();
		
		for (int i = 0; i < result.getColumnLength(); ++i) {
			for (int j = 0; j < result.getRowLength(); ++j) {
				indexList.add(new Integer[] {i, j});
			}
		}
		
		while (!indexList.isEmpty()) {
			ExecutorService es = Executors.newCachedThreadPool();
			for (int i = 0; i < Runtime.getRuntime()
											.availableProcessors() * 2; ++i) {
				Thread calc = new Thread(new MatrixSumElementCalc(matrix1, 
																  matrix2,
																  indexList, 
																  result));
				es.submit(calc);
			}
			es.shutdown();
			try {
				es.awaitTermination(40, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
			
		logger.trace("Ответ отправлен");
		
		return result;
	}
}
