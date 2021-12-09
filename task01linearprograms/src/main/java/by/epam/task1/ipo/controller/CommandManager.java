package by.ipo.task1.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;

import by.ipo.task1.controller.impl.Command;

/**
 * This class calls another command class, depended on user's request.
 * @author Pavel Isidovich
 *
 */

public class CommandManager {

	/**Command map field*/
	private Map<String, Command> commands = new HashMap<>();
	private static CommandManager instance;
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();
	
	/** 
	 * This constructor creates new CommandManager and initializes
	 * command map.
	 */
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
		this.commands.put("сумма квадратов первых n чисел", 
						  new SumSquares());
		this.commands.put("вычисление F(x) = x - sin(x)", new FunctionFX());
		this.commands.put("наибольшая цифра натурального числа", 
						  new GreaterDigitOfNumber());
		this.commands.put("чётные цифры натурального числа", 
						  new EvenDigitsOfNumberSearch());
		this.commands.put("поменять переменные местами", new VariableSwap());
	}
	
	/**
	 * This method returns an instance of CommandManager.
	 */
	public static CommandManager getInstance() {
		if (instance == null) {
			instance = new CommandManager();
		}
		return instance;
	}
	
	/**
	 * This method takes request from user and calls corresponding
	 * command from command map.
	 * @param request - request in String format, written by user.
	 */
	public void doRequest(String request) {
		
		logger.info("Поступила команда '" + request + "'");
		
		Command command;
		if (commands.containsKey(request)) {
			command = commands.get(request);
		} else {
			command = null;
		}
		if (command == null) {
			System.out.println("Нет такой команды.");
			logger.info("Команды '" + request + "' не существует");
		} else {
			logger.info("Команда '" + request + "' выполняется");
			command.execute();
		}
	}
}