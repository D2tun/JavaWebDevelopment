package by.ipo.task5.service.impl;

import by.ipo.task5.service.exception.ServiceException;
import by.ipo.task5.view.MessageViewer;

public class test {

	public static void main(String[] args) throws ServiceException {
		// MessageViewer.getInstance().showMatrix(new MatrixProductServiceImpl().calculate("D:\\JWD\\task5\\src\\main\\resources\\m1.txt","D:\\JWD\\task5\\src\\main\\resources\\m2.txt"));
		 MessageViewer.getInstance().showMatrix(new MatrixMultiplyServiceImpl().calculate("D:\\JWD\\task5\\src\\main\\resources\\m1.txt","D:\\JWD\\task5\\src\\main\\resources\\Multiplier.txt"));
		//MessageViewer.getInstance().showArray(new MergeSortServiceImpl().sort("D:\\JWD\\task5\\src\\main\\resources\\arr.txt"));

	}

}
