package by.ipo.task6.view;
/*
 * Создать класс Художественная Выставка с внутренним классом, с 
 * помощью объектов которого можно хранить информацию о картинах,
 * авторах и времени проведения выставок.
 */

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import by.ipo.task6.controller.impl.CommandManager;

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
