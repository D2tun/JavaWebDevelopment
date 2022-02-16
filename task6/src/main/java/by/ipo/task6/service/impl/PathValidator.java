package by.ipo.task6.service.impl;

/**
 * This class validates path (full name) to file.
 * @author Pavel Isidovich
 *
 */
public class PathValidator {

	/**
	 * This method validates full txt-file name.
	 * @param path - path to file (full file's name)
	 * @return true if path is correct, else - false
	 */
	public static boolean validate(String path) {
		return path.matches("([A-Za-z]{1}:{1}\\\\{1}){1}([^|?/:\"<>*]*\\\\{1})*"
						   + "[^|?/:\\\"<>*]{1,}(\\.[^|?/:\\\\\\\"<>*]{1,}){1}");
	}
	
}
