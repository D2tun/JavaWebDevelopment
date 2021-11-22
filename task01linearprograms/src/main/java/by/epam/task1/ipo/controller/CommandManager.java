
package by.epam.task1.ipo.controller;

import java.util.HashMap;
import java.util.Map;

import by.epam.task1.ipo.controller.impl.Command;

public class CommandManager {

	private Map<String, Command> commands = new HashMap<>();
	private static CommandManager instance;
	
	private CommandManager() {
		this.commands.put("вычислить площадь прямоугольника", 
						  new RectangleInfo());
		this.commands.put("вычислить формулу 1", new FirstExpressionCalc());
		this.commands.put("перевернуть действительное число", 
						  new DecimalNumTurn());
		this.commands.put("найти номер символа UTF8", new SymbolFindingUTF());
		this.commands.put("M/N", new NatNumDiv());
	}
	
	public static CommandManager getInstance() {
		if (instance == null) {
			instance = new CommandManager();
		}
		return instance;
	}
	
	public void doRequest(String request) {
		Command command;
		if (commands.containsKey(request)) {
			command = commands.get(request);
		} else {
			command = null;
		}
		if (command == null) {
			System.out.println("Нет такой команды.");
		} else {
			command.execute();
		}
	}
	
}