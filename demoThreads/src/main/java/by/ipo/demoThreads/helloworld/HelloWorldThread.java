package by.ipo.demoThreads.helloworld;

public class HelloWorldThread extends Thread {
	
	@Override
	public void run() {
		System.out.println(this.getName() + ": Hello world!");
	}

}
