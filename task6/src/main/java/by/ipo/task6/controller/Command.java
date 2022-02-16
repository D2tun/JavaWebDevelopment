package by.ipo.task6.controller;

/**
 * This interface represents command class pattern. CommandManager
 * class also use this interface for generalization of command classes.
 * @author Pavel Isidovich
 *
 */
public interface Command {
	
	/**
	 * All classes than implement this interface must determine this
	 * method. This method determines the execution of command class.
	 */
	public void execute();	
}
