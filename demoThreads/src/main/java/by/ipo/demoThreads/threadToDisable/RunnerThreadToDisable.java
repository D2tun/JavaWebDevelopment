package by.ipo.demoThreads.threadToDisable;

public class RunnerThreadToDisable {

	public static void main(String[] args) {

		System.out.println("Главный поток начал работу...");
		ThreadToDisable myThread = new ThreadToDisable();
		Thread myT = new Thread(myThread, "name of ThreadToDisable");
		myT.start();
		
		Thread demon = new Thread() {
			{
				this.setDaemon(true);
			}
			
			@Override
			public void run() {
				System.out.println("Поток-демон начал работу");
				try {
					Thread.sleep(9000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Поток-демон окончил работу");
			}
			
		};
		
		demon.start();
		
		try {
			Thread.sleep(1100);

			myThread.disable();

			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Поток прерван");
		}
		System.out.println("Главный поток завершил работу...");
	}
}
