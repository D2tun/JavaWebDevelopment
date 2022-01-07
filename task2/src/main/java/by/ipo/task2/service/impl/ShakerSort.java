package by.ipo.task2.service.impl;

import by.ipo.task2.bean.Array;

/**
 * This class provides method for shaker sorting.
 * @author Pavel Isidovich
 * @see Array
 */
public class ShakerSort {

	/**
	 * This method sorts array with shaker sort.
	 * @param array - unsorted array
	 * @return sorted array
	 */
	public static <T> Array<T> sort(Array<T> array) {
		
		int left = 0;
		int right = array.getLength() - 1;
		while (left <= right) {
			for (int i = right; i > left; --i) {
				if (array.compareElements(i, i - 1) < 0) {
					array.swapElements(i - 1, i);
				}
			}
			++left;
			
			for (int i = left; i < right; ++i) {
				if (array.compareElements(i, i + 1) > 0) {
					array.swapElements(i, i + 1);
				}
			}
			--right;
		}
		
		return array;
	}
}
