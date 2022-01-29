package by.ipo.demoThreads.threadCommonResourceReentrantLock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CountThread implements Runnable {

	CommonResource res;
	ReentrantLock locker;
	//ReentrantReadWriteLock locker;

	CountThread(CommonResource res, ReentrantLock lock) {
	//CountThread(CommonResource res, ReentrantReadWriteLock lock) {
		this.res = res;
		locker = lock;
	}
	
	public void run() {
		
		locker.lock(); // устанавливаем блокировку
		//locker.readLock().lock();
		try {
			res.x = 1;
			for (int i = 1; i < 5; i++) {
				System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
				res.x++;
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		} finally {
			locker.unlock(); // снимаем блокировку
			//locker.readLock().unlock();
		}
	}

}
