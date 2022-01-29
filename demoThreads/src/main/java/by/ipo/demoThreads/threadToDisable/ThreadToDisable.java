package by.ipo.demoThreads.threadToDisable;

public class ThreadToDisable implements Runnable {

	private boolean isActive;

	void disable() {
		isActive = false;
	}

	ThreadToDisable() {
		isActive = true;
	}

	@Override
	public void run() {

		System.out.printf("Поток %s начал работу... \n", Thread.currentThread().getName());
		int counter = 1;
		while (isActive) {
			System.out.println("Цикл " + counter++);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Поток прерван");
			}
		}
		System.out.printf("Поток %sзавершил работу... \n", Thread.currentThread().getName());
	}

}
