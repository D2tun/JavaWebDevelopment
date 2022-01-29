package by.ipo.demoThreads.threadCommonResourceReentrantLock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Runner {
	public static void main(String[] args) {

		CommonResource commonResource = new CommonResource();
		ReentrantLock locker = new ReentrantLock(); // создаем заглушку
		//ReentrantReadWriteLock locker = new ReentrantReadWriteLock();
		
		for (int i = 1; i < 6; i++) {

			Thread t = new Thread(new CountThread(commonResource, locker));
			t.setName("Поток " + i);
			t.start();
		}
	}
}
