package by.ipo.task5.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

import org.apache.logging.log4j.LogManager;

import by.ipo.task5.bean.Matrix;
import by.ipo.task5.service.MatrixOperationService;
import by.ipo.task5.service.exception.ServiceException;

/**
 * This class provides method to multiply matrix by number.
 * @author Pavel Isidovich
 *
 */
public class MatrixMultiplyServiceImpl implements MatrixOperationService {

	private static org.apache.logging.log4j
						.Logger logger = LogManager.getFormatterLogger();

	/**
	* This method reads original matrix from file and returns it's
	* transposed variant.
	* @param path - path to file
	* @return transposed matrix
	* @throws ServiceException if matrix got wrong size or
	* file wasn't found.
	*/
	@Override
	public Matrix calculate(String path1, String path2) throws ServiceException {
		if (!PathValidator.validateTXT(path1) 
				&& !PathValidator.validateTXT(path2)) {
			logger.error("Неверные пути к файлу или расширение: " + path1 
						+ ", " + path2);
			throw new ServiceException();
		}
		
		Matrix<Double> matrix = MatrixReader.readMatrix(path1);
		double multiplier;
		
		try {
			multiplier = Double.parseDouble(Files.readString(Paths.get(path2)));
		} catch (NumberFormatException | IOException e) {
			logger.debug("Неверный формат числа");
			throw new ServiceException();
		}
		
		logger.trace("Данные получены");
		
		CountDownLatch cl = new CountDownLatch(matrix.getColumnLength() 
											   * matrix.getRowLength());
		Semaphore semaphore = new Semaphore(Runtime.getRuntime()
												.availableProcessors() * 2);

		for (int i = 0; i < matrix.getColumnLength(); ++i) {
			for (int j = 0; j < matrix.getRowLength(); ++j) {			
				Thread calc = new Thread(new MatrixMultiplyElementCalc(matrix, 
										 multiplier, new int[] {i, j}, cl,
										 semaphore));
				calc.start();
			}
		}
		
		try {
			cl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		logger.trace("Ответ отправлен");

		return matrix;
	}
}
