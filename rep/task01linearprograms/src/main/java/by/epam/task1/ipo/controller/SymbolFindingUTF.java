package by.epam.task1.ipo.controller;

import java.util.Scanner;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.UTFSymbolSearch;

public class SymbolFindingUTF implements Command{

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		UTFSymbolSearch utfss = UTFSymbolSearch.getInstance();
		
		System.out.println("Введите символ");
		String data = sc.nextLine();
		
		char ch;
		
		if (data.matches("^.{1}$")) {
			ch = data.charAt(0);
			System.out.println(utfss.searchSymbol(ch));
		} else {
			System.out.println("Неверные данные");
		}
	}
}
