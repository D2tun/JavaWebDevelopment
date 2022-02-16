package by.ipo.task6.service.factory;

import by.ipo.task6.service.TextOperation;
import by.ipo.task6.service.impl.SortParagraphsService;
import by.ipo.task6.service.impl.SortSentenceWordsService;
import by.ipo.task6.service.impl.SortTextLexemesService;
import by.ipo.task6.service.impl.TextRecoverService;

/**
 * This class represents factory of service.
 * @author Pavel Isidovich
 */
public class ServiceFactory {
	
	private static final ServiceFactory instance = new ServiceFactory();
	
	private final TextOperation sp = new SortParagraphsService();
	private final TextOperation ssw = new SortSentenceWordsService();
	private final TextOperation stl = new SortTextLexemesService();
	private final TextOperation tr = new TextRecoverService();
	
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
	public TextOperation getSortParagraphsService() {
		return sp;
	}
	
	/**
	 * This method returns link on existing object of 
	 * FileCreatingService class.
	 * @return <strong>instance</strong> of object.
	 */
	public TextOperation getSortSentenceWordsService() {
		return ssw;
	}
	
	/**
	 * This method returns link on existing object of 
	 * FileCreatingService class.
	 * @return <strong>instance</strong> of object.
	 */
	public TextOperation getSortTextLexemesService() {
		return stl;
	}

	/**
	 * This method returns link on existing object of 
	 * FileCreatingService class.
	 * @return <strong>instance</strong> of object.
	 */
	public TextOperation getTextRecoverService() {
		return tr;
	}
}
