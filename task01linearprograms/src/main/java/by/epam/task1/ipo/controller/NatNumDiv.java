package by.epam.task1.ipo.controller;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.NaturalNumDiv;
import by.epam.task1.ipo.view.Viewer;

import java.util.Scanner;

/**
 * This class represents command to divide numbers and to get younger
 * radix of result's integer part and result's elder radix of 
 * fractional part.
 * @author Pavel Isidovich
 *
 */
public class NatNumDiv implements Command {

	private Viewer viewer = Viewer.getInstance();
	
	/**
	 * This method executes given command.
	 */
	
	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		NaturalNumDiv nnd = NaturalNumDiv.getInstance();
		
		viewer.showInfo("Введите число M и N через пробел");
		viewer.showInfo(nnd.divide(sc.nextLine()));
	}
}
