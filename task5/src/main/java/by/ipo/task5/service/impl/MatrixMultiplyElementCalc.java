package by.ipo.task5.service.impl;

import java.util.concurrent.CopyOnWriteArrayList;
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
	private Matrix matrix;
	private CountDownLatch cl;
	private CopyOnWriteArrayList<Integer[]> position;
	
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
									 CopyOnWriteArrayList<Integer[]> list, 
									 CountDownLatch cl) {
		this.matrix = matrix;
		this.multiplier = multiplier;
		this.position = list;
		this.cl = cl;
	}
	
	@Override
	public void run() {
		Integer[] pos = this.position.get(0);
		this.position.remove(pos);
		this.matrix.setElement(pos[0], pos[1], 
							   this.matrix.getElement(pos[0], 
							   pos[1]) * this.multiplier);
		if (Thread.interrupted()) {
			this.position.add(pos);
		}
		this.cl.countDown();
	}
}
