package by.ipo.task5.service.impl;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import by.ipo.task5.bean.Matrix;

/**
 * This class represents thread, which transpose matrix.
 * @author Pavel Isidovich
 * @see Matrix
 */
public class MatrixRowTransposition implements Runnable {

	/**Data fields*/
	private Matrix result;
	private Matrix primal;
	private int rowNum;
	private CyclicBarrier barrier;
	
	/**
	 * This constructor creates new thread object and sets given
	 * parameters.
	 * @param primal - original matrix
	 * @param result - transposed matrix
	 * @param rowNum - number of row to be transposed
	 */
	public MatrixRowTransposition(Matrix primal, Matrix result, int rowNum, 
								  CyclicBarrier barrier) {
		this.primal = primal;
		this.result = result;
		this.rowNum = rowNum;
		this.barrier = barrier;
	}

	@Override
	public void run() {

		for (int i = 0; i < this.primal.getRowLength(); ++i) {
			this.result.setElement(i, this.rowNum,
								   this.primal.getElement(this.rowNum, i));		
		}	
		try {
			this.barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
