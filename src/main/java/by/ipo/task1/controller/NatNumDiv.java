package by.ipo.task1.controller;

import by.ipo.task1.controller.impl.Command;
import by.ipo.task1.service.NaturalNumDiv;
import by.ipo.task1.view.ru.MessageViewer;
import by.ipo.task1.view.ru.NatNumDivAnswer;

import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents command to divide numbers and to get younger
 * radix of result's integer part and result's elder radix of 
 * fractional part.
 * @author Pavel Isidovich
 *
 */
public class NatNumDiv implements Command {

	private MessageViewer viewer = MessageViewer.getInstance();
	private NatNumDivAnswer nnda = NatNumDivAnswer.getInstance();
	
	/**
	 * This method executes given command.
	 */
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		NaturalNumDiv nnd = NaturalNumDiv.getInstance();
		
		viewer.showInfo("Введите число M и N через пробел");
		
		String[] parsedData = sc.nextLine().split(" ");
		
		try {
			if (parsedData.length != 2) {
				throw new IOException();
			}
			int m = Integer.parseInt(parsedData[0]);
			int n = Integer.parseInt(parsedData[1]);
			nnda.showInfo(nnd.divide(m, n));
		} catch (IOException | NumberFormatException e) {
			viewer.showInfo("Неверные данные");
		}
	}
}
