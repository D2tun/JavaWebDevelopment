package by.epam.task1.ipo.controller;

import java.util.Scanner;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.UTFSymbolSearch;
import by.epam.task1.ipo.view.Viewer;

/**
 * This class represents command to get byte-code of given symbol.
 * @author Pavel Isidovich
 *
 */

public class SymbolFindingUTF implements Command {
	
	private Viewer viewer = Viewer.getInstance();

	/**
	 * This method executes given command.
	 */
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		UTFSymbolSearch utfss = UTFSymbolSearch.getInstance();
		
		viewer.showInfo("Введите символ");
		System.out.println(utfss.searchSymbol(sc.nextLine()));
	}
}
