package by.ipo.task5.service.impl;

import java.util.concurrent.Semaphore;

import by.ipo.task5.bean.Matrix;

/**
 * This class represents thread, which calculates element of 
 * resulting matrix.
 * @author Pavel Isidovich
 * @see Matrix
 */
public class MatrixSumElementCalc implements Runnable {
	
	/**Data fields*/
	private double element1;
	private double element2;
	private Matrix result;
	private int[] position;
	private Semaphore sem;
	
	/**
	 * This constructor creates new thread object and sets given
	 * parameters.
	 * @param element1 - element of first matrix
	 * @param element2 - element of second matrix
	 * @param resultMatrix - result of sum of matrix
	 * @param position - position in resulting matrix: array, where
	 * element[0] is column index, element[1] is row index
	 */
	public MatrixSumElementCalc(double element1, double element2, 
								Matrix resultMatrix, int[] position,
								Semaphore sem) {
		this.element1 = element1;
		this.element2 = element2;
		this.result = resultMatrix;
		this.position = position;
		this.sem = sem;
	}
	
	@Override
	public void run()  {
		try {
			this.sem.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.result.setElement(this.position[0], this.position[1], 
							   this.element1 + this.element2);
		this.sem.release();
	}
}
