package by.ipo.task1.controller;

import by.ipo.task1.controller.impl.Command;
import by.ipo.task1.service.DecimalNumTurner;
import by.ipo.task1.view.ru.MessageViewer;
import by.ipo.task1.view.ru.DecimalNumTurnAnswer;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents command to turn number from nnn.ddd to 
 * ddd.nnn.
 * @author Pavel Isidovich
 *
 */

public class DecimalNumTurn implements Command {
	
	private MessageViewer viewer = MessageViewer.getInstance();
	private DecimalNumTurnAnswer dnta = DecimalNumTurnAnswer.getInstance();
	
	/**
	 * This method executes given command.
	 */
	@Override
	public void execute() {
		DecimalNumTurner dnt = DecimalNumTurner.getInstance();
		Scanner sc = new Scanner(System.in);
		
		viewer.showInfo("Введите числов вида nnn.ddd");
		
		try {
			double num = Double.parseDouble(sc.nextLine().replace(",", "."));
			dnta.showInfo(dnt.turn(num));
		} catch (NumberFormatException e) {
			viewer.showInfo("Неверные данные");
		}
	}
}
