package by.ipo.task2.service.impl;

import by.ipo.task2.bean.Array;

public class BinarySearch {
	
	public static <T> int find(Array<Double> array, double number, int rightBorder) {

		int leftBorder = 0;
		while (leftBorder <= rightBorder) {
			int middle = leftBorder + ((rightBorder - leftBorder) / 2);
			if (array.getParameter(array.getIndex(number)) > number) {
				rightBorder = middle - 1;
			} else if (array.getParameter(array.getIndex(number)) < number) {
				leftBorder = middle + 1;
			} else {
				return middle;
			}
		}
		return leftBorder;
	}
}