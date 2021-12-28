package by.ipo.task3part1.view;
/*
 * 1. Определить класс Массив. Создать методы сортировки: 
 * 		обменная сортировка (метод пузырька); 
 * 		обменная сортировка «Шейкер-сортировка», 
 * 		сортировка посредством выбора (метод простого выбора),
 * 		сортировка вставками: 0 (сортировка с вычислением адреса),
 * 		сортировкавставками (метод простых вставок), 
 * 		сортировка бинарного слияния, 
 * 		сортировка Шелла (сортировка с убывающим шагом).
 * 		*внешняя сортировка (сортировка файла БОЛЬШОГО размера, 
 * 		например >2(16)Гб).
 * 
 * 2. Определить класс Матрица для решения задач сложения, вычитания, 
 * умножения, и других операция с матрицами. 
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
