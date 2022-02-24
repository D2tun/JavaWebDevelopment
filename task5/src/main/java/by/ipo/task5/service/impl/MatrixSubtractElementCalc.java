package by.ipo.task5.service.impl;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Phaser;
import by.ipo.task5.bean.Matrix;

/**
 * This class represents thread, which calculates element of 
 * resulting matrix.
 * @author Pavel Isidovich
 * @see Matrix
 */
public class MatrixSubtractElementCalc implements Runnable {

	/**Data fields*/
	private double element1;
	private double element2;
	private Matrix result;
	private CopyOnWriteArrayList<Integer[]> position;
	private Phaser phaser;
	
	/**
	 * This constructor creates new thread object and sets given
	 * parameters.
	 * @param element1 - element of first matrix
	 * @param element2 - element of second matrix
	 * @param resultMatrix - result of sum of matrix
	 * @param position - position in resulting matrix: array, where
	 * element[0] is column index, element[1] is row index
	 */
	public MatrixSubtractElementCalc(Matrix matrix1, Matrix matrix2, 
									 Matrix resultMatrix, 
									 CopyOnWriteArrayList<Integer[]> list,
									 Phaser phaser) {
		this.element1 = matrix1.getElement(list.get(0)[0], list.get(0)[1]);
		this.element2 = matrix2.getElement(list.get(0)[0], list.get(0)[1]);
		this.result = resultMatrix;
		this.position = list;
		this.phaser = phaser;
	}
	
	@Override
	public void run()  {
		this.phaser.register();
		Integer[] pos = this.position.get(0);
		this.position.remove(pos);
		this.result.setElement(pos[0], pos[1], 
							   this.element1 - this.element2);
		if (Thread.interrupted()) {
			this.position.add(pos);
		}
		this.phaser.arriveAndDeregister();
	}
}
