package by.ipo.task5.service.impl;

import by.ipo.task5.bean.Array;

/**
 * This class provides method for merge sorting.
 * @author Pavel Isidovich
 * @see Array
 */
public class MergeSort {

	/**
	 * This method sorts array with merge sort.
	 * @param array - unsorted array
	 * @return sorted array
	 */
	public static <T> Array<T> sort(Array<T> array) {
		
		int mid = array.getLength() / 2;
	    Array<T> left = new Array<T>(mid);
	    Array<T> right = new Array<T>(array.getLength() - mid);

	    for (int i = 0; i < mid; i++) {
	    	left.setElement(i, array.getElement(i));
	    }
	    for (int i = mid; i < array.getLength(); i++) {
	    	right.setElement(i, array.getElement(i));
	    }
	    sort(left);
	    sort(right);
	    
	    int i = 0; 
	    int	j = 0;
	    int	k = 0;
	    while (i < left.getLength() && j < right.getLength()) {
	        if (left.getElement(i).hashCode() <= right.getElement(j).hashCode()) {
	            array.setElement(k++, left.getElement(i++));
	        }
	        else {
	        	array.setElement(k++, right.getElement(i++));
	        }
	    }
	    while (i < left.getLength()) {
	    	array.setElement(k++, left.getElement(i++));
	    }
	    while (j < right.getLength()) {
	    	array.setElement(k++, right.getElement(i++));
	    }
	    return array;
	}
}
