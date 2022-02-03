package by.ipo.task5.service.impl;

import java.util.concurrent.CountDownLatch;

import by.ipo.task5.bean.Matrix;

/**
 * This class represents thread, which multiplies matrix's element 
 * by number.
 * @author Pavel Isidovich
 * @see Matrix
 */
public class MatrixMultiplyElementCalc implements Runnable {

	/**Data Fields*/
	private double multiplier;
	private int[] position;
	private Matrix matrix;
	private CountDownLatch cl;
	
	/**
	 * This constructor creates new thread object and sets given
	 * parameters.
	 * @param matrix - target matrix
	 * @param multiplier - by this number matrix's element will be 
	 * multiplied
	 * @param position - position of matrix's element: array, where
	 * element[0] is column index, element[1] is row index
	 */
	public MatrixMultiplyElementCalc(Matrix matrix, double multiplier, 
									 int[] position, CountDownLatch cl) {
		this.matrix = matrix;
		this.multiplier = multiplier;
		this.position = position;
		this.cl = cl;
	}
	
	@Override
	public void run() {
		this.matrix.setElement(this.position[0], this.position[1], 
							   this.matrix.getElement(this.position[0], 
							   this.position[1]) * this.multiplier);
		cl.countDown();
	}
}
