package by.ipo.task2.bean;

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
	
	private T[][] matrix;
	
	/**
	 * This constructor creates matrix.
	 * @param stringNumber - number of strings
	 * @param columnNumber - number of columns
	 * @throws IndexOutOfBoundsException if matrix's borders are 
	 * wrong.
	 */
	public Matrix(int stringNumber, int columnNumber) 
			throws IndexOutOfBoundsException {
		if ((stringNumber < 1) || (columnNumber < 1)) {
			logger.error("Ошибка создания матрицы");
			throw new IndexOutOfBoundsException();
		} else {
			logger.info("Матрица создана успешно");
			this.matrix = (T[][]) new Object[stringNumber][columnNumber];
		}
	}
	
	/**
	 * This method copies values from another matrix
	 * @param matrix
	 * @throws IndexOutOfBoundsException if matrix's aren't got same 
	 * sizes.
	 */
	public void setMatrix(T[][] matrix) throws IndexOutOfBoundsException {
		if ((this.matrix.length != matrix.length) 
				|| (this.matrix[0].length != matrix[0].length)) {
			logger.error("Ошибка создания матрицы");
			throw new IndexOutOfBoundsException();
		} else {
			logger.info("Матрица создана успешно");
			this.matrix = matrix;
		}
	}
	
	/**
	 * This method returns matrix's string length.
	 * @return matrix's string length
	 */
	public int getStringLength() {
		return this.matrix[0].length;
	}
	
	/**
	 * This method returns matrix's column length.
	 * @return matrix's column length
	 */
	public int getColumnLength() {
		return this.matrix.length;
	}

	public T[][] getMatrix() {
		return this.matrix;
	}
	
	/**
	 * This method changes value of element at given address
	 * @param string - vertical address
	 * @param column - horizontal address
	 * @param value - new value of the element
	 * @throws IndexOutOfBoundsException
	 */
	public void setElement(int string, int column, T value) 
			throws IndexOutOfBoundsException {
		if ((string < 0) || (column < 0)) {
			logger.error("Ошибка установки элемента матрицы матрицы");
			throw new IndexOutOfBoundsException();
		} else {
			logger.info("Элемент установлен");
			this.matrix[string][column] = value;
		}
	}

	/**
	 * This method return element at the address.
	 * @param stringIndex - string's number
	 * @param columnIndex - column's number
	 * @return value of element
	 */
	public T getElement(int stringIndex, int columnIndex) {
		return this.matrix[stringIndex][columnIndex];
	}
	
	/**
	 * This method puts matrix's values into string.
	 * @return string representation of matrix
	 */
	public String formString() {
		String answer = "";
		
		for (int string = 0; string < this.matrix.length; ++string) {
			for (int column = 0; column < this.matrix[0].length; ++column) {
				answer += this.matrix[string][column] + " ";
			}
			answer += "\n";
		}
		
		return answer;
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
