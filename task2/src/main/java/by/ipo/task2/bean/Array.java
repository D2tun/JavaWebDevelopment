package by.ipo.task2.bean;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.logging.log4j.LogManager;

/**
 * This class represents array.
 * @author Pavel Isidovich
 * @param <type> - array's type
 *
 */
public class Array<T> implements Serializable {
	
	/**Array field*/
	private T[] array;
	/**Array's length field*/
	private int length;
	
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();

	/**
	 * This constructor creates array of  chosen type.
	 * @param length - length of the array
	 */
	public Array(int length) {
		this.length = length;
		this.array = (T[]) new Object[length]; 
		logger.info("Экземпляр класса создан");
	}
	
	public Array() {

	}
	
	/**
	 * This method adds elements to the array
	 * @param param - element's value
	 * @param index - index of an element
	 * @throws IndexOutOfBoundsException - wrong index request
	 */
	public void setParameter(T param, int index) 
			throws IndexOutOfBoundsException {
		if ((index > this.length) || (index <= 0)) {
			logger.error("Ошибка при добавлении элемента: неверный индекс");
			throw new IndexOutOfBoundsException();
		}
		this.array[index] = param;
		logger.info("Параметры добавлены");
	}
	
	/**
	 * This method adds elements to the array
	 * @param params - array of parameters
	 */
	public void setParameters(Object[] params) {
		this.array = (T[]) params;
		logger.info("Параметры добавлены");
	}
	
	/**
	 * This method compares two elements.
	 * @param index1 - index of element
	 * @param index2 - index of element
	 * @return 0 if elements are equal, positive value if 
	 * element[index1] > element[index2], negative value if 
	 * element[index1] < element[index2]
	 */
	public double compareElements(int index1, int index2) {
		try {
			return Double.parseDouble((String) this.array[index1]) 
				   - Double.parseDouble((String) this.array[index2]);
		} catch (NumberFormatException e) {
			return String.valueOf(this.array[index1])
							.compareTo(String.valueOf(this.array[index2]));
		}
	}
	
	/**
	 * This method swaps two elements.
	 * @param index1 - index of element
	 * @param index2 - index of element
	 */
	public void swapElements(int index1, int index2) {
		T temp = this.array[index1];
		this.array[index1] = this.array[index2];
		this.array[index2] = temp;
	}
	
	/**
	 * This method returns element according to index.
	 * @param index of element
	 * @return element
	 */
	public T getParameter(int index) throws IndexOutOfBoundsException {
		if ((index > this.length) || (index <= 0)) {
			logger.error("Ошибка при добавлении элемента: неверный индекс");
			throw new IndexOutOfBoundsException();
		}
		return this.array[index];
	}

	/**
	 * This method searches for element with given value
	 * @param value - search's aim
	 * @return - index of element, -1 if element not found
	 */
	public int getIndex(T value) {
		int index = -1;
		for (int i = 0; i < this.length; i++) {
			if (this.getParameter(i) == value) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	/**
	 * This method provides arrays's elements in string 
	 * format.
	 * @return Elements in string with space delimiters
	 */
	public String formatArrayToString() {
		String stringArray = "";
		
		for (int i = 0; i < this.length; ++i) {
			stringArray += String.valueOf(this.array[i]) + " ";
		}
		
		return stringArray;
	}
	
	public T[] getArray() {
		return array;
	}

	public void setArray(T[] array) {
		this.array = array;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(array);
		result = prime * result + length;
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
		Array other = (Array) obj;
		if (!Arrays.equals(array, other.array))
			return false;
		if (length != other.length)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Array [array=" + Arrays.toString(array) + ", length=" + length 
				+ "]";
	}
}
