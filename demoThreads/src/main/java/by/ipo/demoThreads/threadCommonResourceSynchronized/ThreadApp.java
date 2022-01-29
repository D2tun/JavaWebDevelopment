package by.ipo.demoThreads.threadCommonResourceSynchronized;

public class ThreadApp {
	
	public static void main(String[] args) {

		CommonResource commonResource = new CommonResource();
		for (int i = 1; i < 6; i++) {

			Thread t = new Thread(new CountThread(commonResource));
			t.setName("Поток " + i);
			t.start();
		}
	}

}
