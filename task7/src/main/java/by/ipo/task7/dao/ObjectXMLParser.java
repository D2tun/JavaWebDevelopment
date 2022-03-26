package by.ipo.task7.dao;

import java.util.List;

import by.ipo.task7.dao.exception.FileAccessException;
import by.ipo.task7.dao.exception.XMLValidationException;

/**
 * This interface is an instruction to create xml parser.
 * @author Pavel Isidovich
 * @param <T> - type of an object
 */
public interface ObjectXMLParser<T> {
	
	/**
	 * This method parses objects from xml via DOM-parser.
	 * @param path - path to file
	 * @return list of parsed objects
	 * @throws FileAccessException if file cannot be accessed
	 * @throws XMLValidationException if given xml doesn't correspond xsd
	 */
	public List<T> parseDOM(String path) throws XMLValidationException, 
												FileAccessException;
	
	/**
	 * This method parses objects from xml via SAX-parser.
	 * @param path - path to file
	 * @return list of parsed objects
	 * @throws FileAccessException if file cannot be accessed
	 * @throws XMLValidationException if given xml doesn't correspond xsd
	 */
	public List<T> parseSAX(String path) throws XMLValidationException, 
												FileAccessException;
	
	/**
	 * This method parses objects from xml via StAX-parser.
	 * @param path - path to file
	 * @return list of objects
	 * @throws FileAccessException if file cannot be accessed
	 * @throws XMLValidationException if given xml doesn't correspond xsd
	 */
	public List<T> parseStAX(String path) throws XMLValidationException, 
												 FileAccessException;
}
