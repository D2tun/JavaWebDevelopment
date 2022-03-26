package by.ipo.task7.dao.exception;

/**
 * This exception thrown if xml-file doesn't cord to xsd-scheme.
 * @author Pavel Isidovich
 *
 */
public class XMLValidationException extends Exception {

	public XMLValidationException() {
		super("XML file is invalid");
	}
	
}
