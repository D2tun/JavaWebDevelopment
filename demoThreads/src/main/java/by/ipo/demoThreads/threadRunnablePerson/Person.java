package by.ipo.demoThreads.threadRunnablePerson;

public class Person implements Runnable {

	private String message;
	
	public Person(String message) {
		this.message = message;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; ++i) {
			System.out.println(this.message);
		}
	}
}
