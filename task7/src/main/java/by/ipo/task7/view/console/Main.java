package by.ipo.task7.view.console;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import by.ipo.task7.controller.console.impl.CommandManager;

//TODO tomcat вывод в таблицу браузера

public class Main {
	
	public static void main(String[] args) {

		CommandManager cm = CommandManager.getInstance();
		Scanner sc = new Scanner(System.in);
		ResourceBundle menu = ResourceBundle.getBundle("view", 
													   Locale.getDefault());
		
		while(true) {
			System.out.println(menu.getString("menu"));

			cm.doRequest(sc.nextLine());	
		}
	}
}
