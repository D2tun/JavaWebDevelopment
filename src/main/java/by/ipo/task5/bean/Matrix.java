package by.ipo.task5.bean;

import java.io.Serializable;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;

/**
 * This class represents matrix.
 * @author Pavel Isidovich
 * @param <T> - matrix's type
 *
 */
public class Matrix<T extends Double> implements Serializable{
	
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	private Object[][] matrix;
	
	/**
	 * This constructor creates matrix.
	 * @param rowNumber - number of rows
	 * @param columnNumber - number of columns
	 */
	public Matrix(int rowNumber, int columnNumber) {
		logger.info("Матрица создана успешно");
		this.matrix = new Object[rowNumber][columnNumber];
	}
	
	/**
	 * This method returns matrix's string length.
	 * @return matrix's string length
	 */
	public int getRowLength() {
		return this.matrix[0].length;
	}
	
	/**
	 * This method returns matrix's column length.
	 * @return matrix's column length
	 */
	public int getColumnLength() {
		return this.matrix.length;
	}
	
	/**
	 * This method changes value of element at given address
	 * @param row - vertical address
	 * @param column - horizontal address
	 * @param value - new value of the element
	 */
	public void setElement(int row, int column, T value) {
		logger.info("Элемент установлен");
		this.matrix[row][column] = value;
	}

	/**
	 * This method return element at the address.
	 * @param rowIndex - row's number
	 * @param columnIndex - column's number
	 * @return value of element
	 */
	public T getElement(int rowIndex, int columnIndex) {
		return (T) this.matrix[rowIndex][columnIndex];
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(matrix);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matrix other = (Matrix) obj;
		if (!Arrays.deepEquals(matrix, other.matrix))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Matrix [matrix=" + Arrays.toString(matrix) + "]";
	}
}
