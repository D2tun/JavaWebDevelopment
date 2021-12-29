package by.ipo.task3part1.view;
/*
 * Страхование. Определить иерархию страховых обязательств. Собрать из
 * обязательств дериватив. Подсчитать стоимость. Провести сортировку
 * обязательств в деривативе на основе уменьшения степени риска. Найти
 * обязательство в деривативе, соответствующее заданному диапазону 
 * параметров.
 */

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import by.ipo.task3part1.controller.impl.CommandManager;

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
