package by.ipo.task5.view;

import java.util.concurrent.TimeUnit;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {

		int i = 0;
		while (i < 10) {
			Thread a = new Thread(new Requester());
			a.start();
			TimeUnit.SECONDS.sleep((long) StrictMath.round(StrictMath.random() 
													   * 10));
			++i;
		}
	}
}
//D:\JWD\task5\src\main\resources\arr.txt

//D:\JWD\task5\src\main\resources\m1.txt,D:\JWD\task5\src\main\resources\m2.txt