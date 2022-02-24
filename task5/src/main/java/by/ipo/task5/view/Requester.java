package by.ipo.task5.view;

import java.io.File;
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
			this.mv.setData(new File(getClass().getClassLoader()
													.getResource("arr.txt")
													.getFile())
														.getAbsolutePath());
		} else {
			this.mv.setData(new File(getClass().getClassLoader()
													.getResource("m1.txt")
													.getPath())
														.getAbsolutePath() + ","
							+ new File(getClass().getClassLoader()
														.getResource("m2.txt")
														.getPath())
															.getAbsolutePath());
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
//"D:\\JWD\\task5\\src\\main\\resources\\arr.txt"