package by.ipo.task5.bean;

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
	private Object[] array;
	
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();

	/**
	 * This constructor creates array of chosen type.
	 * @param length - length of the array
	 */
	public Array(int length) {
		this.array = new Object[length]; 
		logger.info("Массив успешно создан");
	}
	
	private Array() {

	}
	
	/**
	 * This method adds elements to the array
	 * @param value - element's value
	 * @param index - index of an element
	 * @throws IndexOutOfBoundsException - wrong index request
	 */
	public void setElement(int index, T value) {
		this.array[index] = value;
		logger.info("Параметр установлен");
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
			return (Double) this.array[index1] - (Double) this.array[index2];
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
		T temp = (T) this.array[index1];
		this.array[index1] = this.array[index2];
		this.array[index2] = temp;
	}
	
	/**
	 * This method returns element according to index.
	 * @param index of element
	 * @return element
	 */
	public T getElement(int index) {
		return (T) this.array[index];
	}

	/**
	 * This method searches for element with given value
	 * @param value - search's aim
	 * @return - index of element, -1 if element not found
	 */
	public int getIndex(T value) {
		int index = -1;
		for (int i = 0; i < this.array.length; i++) {
			if (this.getElement(i) == value) {
				index = i;
				break;
			}
		}
		return index;
	}

	/**
	 * This method returns array's length.
	 * @return array's length
	 */
	public int getLength() {
		return this.array.length;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(array);
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
		return true;
	}

	@Override
	public String toString() {
		return "Array [array=" + Arrays.toString(array) + "]";
	}
}
