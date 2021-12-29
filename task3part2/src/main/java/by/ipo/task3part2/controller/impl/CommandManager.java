package by.ipo.task3part2.controller.impl;


import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;

import by.ipo.task3part2.controller.Command;
import by.ipo.task3part2.view.MessageViewer;

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
	private ResourceBundle rb = ResourceBundle.getBundle("view", 
			   											   Locale.getDefault());
	private static MessageViewer mw = MessageViewer.getInstance();
	
	/** 
	 * This constructor creates new CommandManager and initializes
	 * command map.
	 */
	private CommandManager() {
		this.commands.put(rb.getString("exitCommandRequest"), 
						  new ExitCommand());
		this.commands.put(rb.getString("showExhibitionCommandRequest"),
						  new ShowExhibitInfoCommand());
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
			mw.showInfo(rb.getString("noSuchCommand"));
			logger.info("Команда '" + request + "' отсутствует");
		} else {
			logger.info("Команда '" + request + "' выполняется");
			command.execute();
		}
	}
}