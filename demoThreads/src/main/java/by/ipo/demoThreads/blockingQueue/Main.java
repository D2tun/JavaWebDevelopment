package by.ipo.demoThreads.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);
		new Thread(() -> {
			for (int i = 0; i < 3; i++) {
				try {
					TimeUnit.MILLISECONDS.sleep(1);
					queue.put("Java" + i);
					System.out.println("Element " + i + " added");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		new Thread(() -> {
			try {
				System.out.println("Element " + queue.take() + " took");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
