
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
		this.commands.put("найти модуль квадратичного выражения", 
						  new ExpressionModuleCalc());
		this.commands.put("проверить равносторонность треугольника", 
						  new TriangleEquilateralityCheck());
		this.commands.put("лесть", new Flattery());
		this.commands.put("секретная база данных", new DataBaseAccess());
		this.commands.put("узнать день и месяц", new DateAndMonthGuess());
		this.commands.put("вычислить точки прямой", 
						  new MiddleCoordinateLineBuilder());
		this.commands.put("сумма квадратов первых ста чисел", 
						  new SumOfHundredSquares());
		this.commands.put("вычисление F(x) = x - sin(x)", new FunctionFX());
		this.commands.put("наибольшая цифра натурального числа", 
						  new GreaterDigitOfNumber());
		this.commands.put("чётные цифры натурального числа", 
						  new EvenDigitsOfNumberSearch());
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