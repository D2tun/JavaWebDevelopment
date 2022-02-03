package by.ipo.task5.service.impl;

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
	private int[] position;
	
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
									   Matrix resultMatrix, int[] position) {
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.result = resultMatrix;
		this.position = position;
	}
	
	@Override
	public void run()  {
		
		double resultElement = 0;
		
		for (int i = 0; i < this.matrix1.getRowLength(); ++i) {
			resultElement += this.matrix1.getElement (position[0], i) 
							* this.matrix2.getElement(i, position[1]);		
		}
		
		this.result.setElement(this.position[0], this.position[1], 
							   resultElement);
	}
}
