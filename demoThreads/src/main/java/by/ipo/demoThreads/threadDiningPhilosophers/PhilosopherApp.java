package by.ipo.demoThreads.threadDiningPhilosophers;

import java.util.concurrent.Semaphore;

public class PhilosopherApp {

	public static void main(String[] args) {

		Semaphore sem = new Semaphore(2);
		for (int i = 1; i <= 13; i++)
			new Philosopher(sem, i).start();
	}

}
