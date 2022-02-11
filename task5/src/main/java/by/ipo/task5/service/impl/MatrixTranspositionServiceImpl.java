package by.ipo.task5.service.impl;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

import org.apache.logging.log4j.LogManager;

import by.ipo.task5.bean.Matrix;
import by.ipo.task5.service.MatrixOperationService;
import by.ipo.task5.service.exception.ServiceException;

/**
 * This class provides method to transpose matrix.
 * @author Pavel Isidovich
 *
 */
public class MatrixTranspositionServiceImpl implements MatrixOperationService {

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
	public Matrix calculate(String path, String path2) throws ServiceException {
		if (!PathValidator.validateTXT(path)) {
			logger.error("Неверные пути к файлу или расширение: " + path);
			throw new ServiceException();
		}
		
		Matrix<Double> matrix = MatrixReader.readMatrix(path);

		if ((matrix.getColumnLength() < 1) || (matrix.getRowLength() < 1)) {
			logger.debug("Ошибка размера матрицы");
			throw new ServiceException();
		}
		
		Matrix<Double> result = new Matrix<>(matrix.getRowLength(), 
											 matrix.getColumnLength());
		CyclicBarrier barrier = new CyclicBarrier(result.getRowLength() + 1);
		Semaphore semaphore = new Semaphore(Runtime.getRuntime()
												.availableProcessors() * 2);
		
		for (int i = 0; i < matrix.getColumnLength(); ++i) {
			Thread transposeRow 
						= new Thread(new MatrixRowTransposition(matrix, 
																result, 
																i, barrier,
																semaphore));
			transposeRow.start();
		}
		
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}

		logger.trace("Ответ отправлен");
		
		return result;
	}
}
