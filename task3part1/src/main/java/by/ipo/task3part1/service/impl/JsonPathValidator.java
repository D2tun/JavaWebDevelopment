package by.ipo.task3part1.service.impl;

/**
 * This class provides method to validate json-file's full name.
 * @author Pavel Isidovich
 *
 */
public class JsonPathValidator {

	protected static boolean validate(String path) {
		if (path.matches("([A-Za-z]{1}:{1}\\\\{1}){0,1}([^|?/:\"<>*]*\\\\{1})*"
				+ "[^|?/:\\\"<>*]{1,}(\\.json){1}")) {
			return true;
		} else {
			return false;
		}
	}
}
