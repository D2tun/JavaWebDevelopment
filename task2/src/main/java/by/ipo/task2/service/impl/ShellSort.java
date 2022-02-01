package by.ipo.task5.service.impl;

import by.ipo.task5.bean.Array;

/**
 * This class provides method for Shell's sorting.
 * @author Pavel Isidovich
 * @see Array
 */
public class ShellSort {

	/**
	 * This method sorts array with Shell's sort.
	 * @param array - unsorted array
	 * @return sorted array
	 */
	public static Array<Double> sort(Array<Double> array) {

		int h = 1;
		while (h < array.getLength()) {
			h = 3 * h + 1;
		}

		while (h > 0) {
			h = h / 3;
			for (int k = 0; k < h; k++) {
				for (int i = h + k; i < array.getLength(); i += h) {
					double key = array.getElement(i);
					int j = i - h;
					while (j >= 0 && array.getElement(j) > key) {
						array.setElement(j + h, array.getElement(j));
						j -= h;
					}
					array.setElement(j + h, key);
				}
			}
		}

		return array;
	}
}
