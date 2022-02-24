package by.ipo.task5.service.impl;

import java.util.concurrent.CopyOnWriteArrayList;
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
	private CopyOnWriteArrayList<Integer[]> position;
	
	/**
	 * This constructor creates new thread object and sets given
	 * parameters.
	 * @param element1 - element of first matrix
	 * @param element2 - element of second matrix
	 * @param resultMatrix - result of sum of matrix
	 * @param position - position in resulting matrix: array, where
	 * element[0] is column index, element[1] is row index
	 */
	public MatrixSumElementCalc(Matrix matrix1, Matrix matrix2, 
								CopyOnWriteArrayList<Integer[]> list,
								Matrix resultMatrix) {
		this.position = list;
		this.element1 = matrix1.getElement(this.position.get(0)[0], 
										   this.position.get(0)[1]);
		this.element2 = matrix2.getElement(this.position.get(0)[0], 
										   this.position.get(0)[1]);
		this.result = resultMatrix;
	}
	
	@Override
	public void run()  {
		Integer[] pos = this.position.get(0);
		this.position.remove(pos);
		this.result.setElement(pos[0], pos[1], 
							   this.element1 + this.element2);
		if (Thread.interrupted()) {
			this.position.add(pos);
		}
	}
}
