package by.ipo.demoThreads.threadRunnablePerson;

public class Main {

	public static void main(String[] args) {
		
		Thread a = new Thread(new Person("egg"));
		Thread b = new Thread(new Person("chicken"));
		
		a.start();
		b.start();
		
		a.setPriority(10);
		b.setPriority(10);
		
	}

}
