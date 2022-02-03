package by.ipo.task5.service;

import by.ipo.task5.bean.Matrix;
import by.ipo.task5.service.exception.ServiceException;

/**
 * This interface is implemented by classes, which provides methods
 * of operations with matrix.
 * @author Pavel Isidovich
 *
 */
public interface MatrixOperationService {
	
	public Matrix calculate(String path1, String path2) throws ServiceException;

}
