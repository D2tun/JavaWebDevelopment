package by.ipo.demoThreads.helloworld;

public class Main {

	public static void main(String[] args) {

		for (int i = 0; i < 10; ++i) {
			new HelloWorldThread().start();
		}

	}

}
