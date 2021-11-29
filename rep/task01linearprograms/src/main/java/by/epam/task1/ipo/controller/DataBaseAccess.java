package by.epam.task1.ipo.controller;

import java.util.Scanner;

import by.epam.task1.ipo.controller.impl.Command;
import by.epam.task1.ipo.service.ModuleAccessCheck;

public class DataBaseAccess implements Command {

	@Override
	public void execute() {
		Scanner sc = new Scanner(System.in);
		ModuleAccessCheck mac = ModuleAccessCheck.getInstance();
		
		System.out.println("Введите пароль");
		String data = sc.nextLine();
		System.out.println(mac.checkAccess(data));	
	}
}
