package by.ipo.demoThreads.waitNotify;

public class Consumer extends Thread {
	Store store;

	Consumer(Store store) {
		this.store = store;
	}

	public void run() {
		for (int i = 1; i < 6; i++) {
			store.get();
		}
	}
}
