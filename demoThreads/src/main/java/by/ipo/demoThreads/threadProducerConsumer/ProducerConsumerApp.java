package by.ipo.demoThreads.threadProducerConsumer;

public class ProducerConsumerApp {

	public static void main(String[] args) {
		Store store = new Store();
		new Producer(store).start();
		new Consumer(store).start();
	}
}
