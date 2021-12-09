package by.ipo.task1.controller;

import java.io.IOException;
import java.util.Scanner;

import by.ipo.task1.controller.impl.Command;
import by.ipo.task1.service.UTFSymbolSearch;
import by.ipo.task1.view.ru.MessageViewer;
import by.ipo.task1.view.ru.UTFSymbolSearchAnswer;

/**
 * This class represents command to get byte-code of given symbol.
 * @author Pavel Isidovich
 *
 */
public class SymbolFindingUTF implements Command {
	
	private MessageViewer viewer = MessageViewer.getInstance();
	private UTFSymbolSearchAnswer utfssa = UTFSymbolSearchAnswer.getInstance();

	/**
	 * This method executes given command.
	 */
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		UTFSymbolSearch utfss = UTFSymbolSearch.getInstance();
		
		viewer.showInfo("Введите символ");
		String data = sc.nextLine();
		
		try {
			if (data.length() != 1) {
				throw new IOException();
			}
			char ch = data.charAt(0);
			utfssa.showInfo(utfss.searchSymbol(ch));
		} catch (IOException e) {
			viewer.showInfo("Неверные данные");
		}
	}
}
