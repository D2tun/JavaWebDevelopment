package by.ipo.task5.service.impl;

import java.util.concurrent.CopyOnWriteArrayList;
import by.ipo.task5.bean.Matrix;

/**
 * This class represents thread, which calculates element of 
 * resulting matrix.
 * @author Pavel Isidovich
 * @see Matrix
 */
public class MatrixProductionElementCalc implements Runnable {

	/**Data fields*/
	private Matrix matrix1;
	private Matrix matrix2;
	private Matrix result;
	private CopyOnWriteArrayList<Integer[]> position;
	
	/**
	 * This constructor creates new thread object and sets given
	 * parameters.
	 * @param matrix1 - matrix on first position
	 * @param matrix2 - matrix on second position
	 * @param resultMatrix - result of matrix production
	 * @param position - position in resulting matrix: array, where
	 * element[0] is column index, element[1] is row index
	 */
	public MatrixProductionElementCalc(Matrix matrix1, Matrix matrix2, 
									   Matrix resultMatrix,  
									   CopyOnWriteArrayList<Integer[]> list) {
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.result = resultMatrix;
		this.position = list;
	}
	
	@Override
	public void run()  {
		Integer[] pos = this.position.get(0);
		this.position.remove(pos);
		
		double resultElement = 0;
		
		for (int i = 0; i < this.matrix1.getRowLength(); ++i) {
			resultElement += this.matrix1.getElement(pos[0], i) 
							* this.matrix2.getElement(i, pos[1]);		
		}
		
		this.result.setElement(pos[0], pos[1], resultElement);
		
		if (Thread.interrupted()) {
			this.position.add(pos);
		}
	}
}
