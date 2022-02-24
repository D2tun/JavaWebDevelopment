package by.ipo.task5.service.impl;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
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
	private CyclicBarrier barrier;
	private CopyOnWriteArrayList<Integer[]> position;
	
	/**
	 * This constructor creates new thread object and sets given
	 * parameters.
	 * @param primal - original matrix
	 * @param result - transposed matrix
	 * @param rowNum - number of row to be transposed
	 */
	public MatrixRowTransposition(Matrix primal, Matrix result, 
								  CyclicBarrier barrier, 
								  CopyOnWriteArrayList<Integer[]> list) {
		this.primal = primal;
		this.result = result;
		this.barrier = barrier;
		this.position = list;
	}

	@Override
	public void run() {
		Integer pos = this.position.get(0)[0];
		this.position.remove(0);
		for (int i = 0; i < this.primal.getRowLength(); ++i) {
			this.result.setElement(i, pos,
								   this.primal.getElement(pos, i));		
		}	
		try {
			this.barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			this.position.add(new Integer[] {pos});
		}
	}
}
