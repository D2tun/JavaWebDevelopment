package by.epam.task1.ipo.controller;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.DateAndMonthReveal;
import java.util.Scanner;

public class DateAndMonthGuess implements Command {

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		DateAndMonthReveal damr = DateAndMonthReveal.getInstance();
		
		System.out.println("Введите номер дня в году (1 - 365)");
		String data = sc.nextLine();
		
		if (data.matches("[0-9]{1,3}")) {
			System.out.println(damr.getDateAndMonth(Integer.parseInt(data)));
		} else {
			System.out.println("Неверные данные");
		}
		
	}

}
