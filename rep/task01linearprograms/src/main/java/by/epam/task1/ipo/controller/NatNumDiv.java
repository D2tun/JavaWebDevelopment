package by.epam.task1.ipo.controller;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.NaturalNumDiv;

import java.util.Scanner;

public class NatNumDiv implements Command {

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		NaturalNumDiv nnd = NaturalNumDiv.getInstance();
		
		String data;
		
		System.out.println("Введите число M");
		data = sc.nextLine();
		int m;
		if (data.matches("^[0-9]+$")) {
			m = Integer.valueOf(data);
		} else {
			m = -1;
		}
		
		System.out.println("Введите число N");
		data = sc.nextLine();
		int n;
		if (data.matches("^[0-9]+")) {
			n = Integer.valueOf(data);
		} else {
			n = -1;
		}
		
		if ((m < 0) | (n < 0)) {
			System.out.println("Неверные данные");
		} else {
			System.out.println(nnd.divide(m, n));
		}
	}

}
