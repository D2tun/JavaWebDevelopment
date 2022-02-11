package by.ipo.task5.service.impl;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

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
	private Semaphore sem;
	
	/**
	 * This constructor creates new thread object and sets given
	 * parameters.
	 * @param primal - original matrix
	 * @param result - transposed matrix
	 * @param rowNum - number of row to be transposed
	 */
	public MatrixRowTransposition(Matrix primal, Matrix result, int rowNum, 
								  CyclicBarrier barrier, Semaphore sem) {
		this.primal = primal;
		this.result = result;
		this.rowNum = rowNum;
		this.barrier = barrier;
		this.sem = sem;
	}

	@Override
	public void run() {
		try {
			this.sem.acquire();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		for (int i = 0; i < this.primal.getRowLength(); ++i) {
			this.result.setElement(i, this.rowNum,
								   this.primal.getElement(this.rowNum, i));		
		}	
		try {
			this.barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		this.sem.release();
	}
}
