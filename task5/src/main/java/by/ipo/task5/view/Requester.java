package by.ipo.task5.view;

import java.util.concurrent.TimeUnit;

import by.ipo.task5.controller.impl.CommandManager;

public class Requester implements Runnable {
	private CommandManager cm = CommandManager.getInstance();
	private MessageViewer mv = MessageViewer.getInstance();
	
	private String[] commands = new String[] {
			"sort array (bubble sort)",
			"sort array (shaker sort)",
			"sort array (choice sort)",
			"sum two matrixes",
			"matrix subtraction",
			"matrix production"
	};
	
	@Override
	public void run() { 
		
		int command = (int) StrictMath.round(StrictMath.random() * 5);
		
		if (command < 3) {
			this.mv.setData("D:\\JWD\\task5\\src\\main\\resources\\arr.txt");
		} else {
			this.mv.setData("D:\\JWD\\task5\\src\\main\\resources\\m1.txt,"
							+ "D:\\JWD\\task5\\src\\main\\resources\\m2.txt");
		}
		System.out.println(this.commands[command]);
		cm.doRequest(this.commands[command]);

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
