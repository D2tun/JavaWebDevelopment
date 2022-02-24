package by.ipo.task5.service.impl;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Phaser;
import org.apache.logging.log4j.LogManager;

import by.ipo.task5.bean.Matrix;
import by.ipo.task5.service.MatrixOperationService;
import by.ipo.task5.service.exception.ServiceException;

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
		if (!PathValidator.validateTXT(path1)
				&& !PathValidator.validateTXT(path2)) {
			logger.error("Неверные пути к файлу или расширение: " + path1 
						+ ", " + path2);
			throw new ServiceException();
		}
	
		Matrix matrix1 = MatrixReader.readMatrix(path1); 
		Matrix matrix2 = MatrixReader.readMatrix(path2);
	
		logger.trace("Данные получены");
		
		if ((matrix1.getColumnLength() != matrix2.getColumnLength()) 
				|| (matrix1.getRowLength() != matrix2.getRowLength())) {
			logger.debug("Несоответствие размеров матриц");
			throw new ServiceException();
		}
	
		Matrix<Double> result = new Matrix(matrix1.getColumnLength(), 
										   matrix1.getRowLength());
		
		CopyOnWriteArrayList<Integer[]> indexList 
											= new CopyOnWriteArrayList<>();

		for (int i = 0; i < result.getColumnLength(); ++i) {
			for (int j = 0; j < result.getRowLength(); ++j) {
				indexList.add(new Integer[] {i, j});
			}
		}
		
		while (!indexList.isEmpty()) {
			Phaser phaser = new Phaser(Runtime
										.getRuntime()
										.availableProcessors() 
									   * 2);
			phaser.register();	
			for (int j = 0; j < Runtime.getRuntime().availableProcessors() 
								* 2; ++j) {
				Thread calc = new Thread(new MatrixSubtractElementCalc(
											matrix1, matrix2, result, 
											indexList, phaser));
				
				calc.start();
			}
			phaser.arriveAndAwaitAdvance(); 
		}
		
		logger.trace("Ответ отправлен");
	
		return result;
	}
}
