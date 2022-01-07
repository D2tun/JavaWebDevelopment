package by.ipo.task2.service.impl;

import by.ipo.task2.bean.Array;

/**
 * This class provides method for Shell's sorting.
 * @author Pavel Isidovich
 * @see Array
 */
public class ShellSort {
	
	/**
	 * This method sorts array with shaker sort.
	 * @param array - unsorted array
	 * @return sorted array
	 */
	public static  <T> Array<T> sort(Array<T> array) {
		
		 for (int gap = array.getLength() / 2; gap > 0; gap /= 2) {
		        for (int i = gap; i < array.getLength(); i++) {
		        	T key = array.getElement(i);
		            int j = i;
		            while ((j >= gap) && (array.getElement(j - gap).toString()
		            						.compareTo(key.toString()) 
		            		< 0)) {
		            	array.swapElements(j, j - gap);
		                j -= gap;
		            }
		            array.setElement(j, key);
		        }
		    }
		
		return array;
	}
}
