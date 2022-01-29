package by.ipo.demoThreads.threadManagement;

public class JoinThread extends Thread {

	public JoinThread(String name) {
		super(name);
	}

	public void run() {
		String nameT = getName();
		long timeout = 0;
		System.out.println("Стартпотока " + nameT);
		try {
			switch (nameT) {
			case"First":
				timeout = 5_000;
				break;
			case"Second":
				timeout = 1_000;
			}
			Thread.sleep(timeout);
			System.out.println("завершениепотока " + nameT);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


