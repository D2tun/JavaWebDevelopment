package by.ipo.task3part2.service.factory;

import by.ipo.task3part2.service.ExhibitionReader;
import by.ipo.task3part2.service.impl.ExhibitionReaderImpl;

/**
 * This class represents factory of service.
 * @author Pavel Isidovich
 */
public class ServiceFactory {
	
	private static final ServiceFactory instance = new ServiceFactory();
	
	private final ExhibitionReader er = new ExhibitionReaderImpl();
	
	/**
	 * This method returns link on existing object of this class.
	 * @return <strong>instance</strong> of object.
	 */
	public static ServiceFactory getInstance() {
		return instance;
	}
	
	/**
	 * This method returns link on existing object of 
	 * FileCreatingService class.
	 * @return <strong>instance</strong> of object.
	 */
	public ExhibitionReader getExhibitionReader() {
		return er;
	}
}
