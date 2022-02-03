package by.ipo.task5.service.impl;

import by.ipo.task5.bean.Array;

/**
 * This class provides method for insertion sorting.
 * @author Pavel Isidovich
 * @see Array
 */
public class InsertionSort {

	/**
	 * This method sorts array with insertion sort (binary search).
	 * @param array - unsorted array
	 * @return sorted array
	 */
	public static Array sortBinary(Array array) {
		
		for (int i = 1; i < array.getLength(); i++) {
			double number = (double) array.getElement(i);
			int indexToInsert = BinarySearch.find(array, number, i);
			for (int j = i; j > indexToInsert; j--) {
				array.swapElements(j, j - 1);
			}
			array.setElement(indexToInsert, number);
		}
		
		return array;
	}
	
	/**
	 * This method sorts array with insertion sort.
	 * @param array - unsorted array
	 * @return sorted array
	 */
	public static Array<Double> sort(Array<Double> array) {
		
		for (int i = 0; i < array.getLength(); i++) {
			int indexToInsert = i;
			double min = Double.valueOf(array.getElement(i));
			for (int j = i; j > indexToInsert; j--) {
				if (array.compareElements(i, j) > 0) {
					array.swapElements(j, j - 1);
				} else {
					break;
				}
			}
			array.setElement(i, min);
		}
		
		return array;
	}
}
