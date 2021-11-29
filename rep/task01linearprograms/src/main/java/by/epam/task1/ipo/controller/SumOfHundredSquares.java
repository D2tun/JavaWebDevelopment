package by.epam.task1.ipo.controller;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.SumOfSquares;

public class SumOfHundredSquares implements Command {

	@Override
	public void execute() {
		SumOfSquares sos = SumOfSquares.getInstance();
		
		System.out.println(sos.getSum());
	}

}
