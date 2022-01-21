package by.ipo.task4.service.impl;

/**
 * This class provides method to validate file's path and define 
 * file's type.
 * @author Pavel Isidovich
 *
 */
public class PathDefiner {

	/**
	 * This method validates path and define if file has txt or json
	 * type.
	 * @param path - full file's name
	 * @return "txt" if file's type is txt, "json" if file's type is 
	 * json, "invalid" if path is invalid or file's type is different
	 * from txt or json.
	 */
	public static String definePath(String path) {
		final String JSON_PATH = "([A-Za-z]{1}:{1}\\\\{1}){0,1}([^|?/:\"<>*]*"
								 + "\\\\{1})*[^|?/:\\\"<>*]{1,}(\\.json){1}";
		final String TXT_PATH = "([A-Za-z]{1}:{1}\\\\{1}){0,1}([^|?/:\"<>*]*"
				 				+ "\\\\{1})*[^|?/:\\\"<>*]{1,}(\\.txt){1}";
		
		if (path.matches(TXT_PATH)) {
			return "txt";
		} else if (path.matches(JSON_PATH)) {
			return "json";
		} else {
			return "invalid";
		}
	}
}
