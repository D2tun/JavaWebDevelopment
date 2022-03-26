package by.ipo.task7.dao.impl;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

/**
 * This class provides method to validate xml-file via xsd-scheme.
 * @author Pavel Isidovich
 *
 */
public class XMLOrdersValidator {
	
	/**Data field*/
	private String schemaPath = getClass().getClassLoader()
												.getResource("xml/gym.xsd")
												.getPath();
	private SchemaFactory sf = SchemaFactory
									.newInstance(XMLConstants
													.W3C_XML_SCHEMA_NS_URI);
	
	/**
	 * This method validates xml-document via xsd-schema for Order objects.
	 * @param path - path to xml-file
	 * @return true if xml file is valid, false if xml file is invalid
	 * @throws IOException if file cannot be found
	 * @see Order
	 */
	public boolean validate(String path) throws IOException {
		try {
			this.sf.newSchema(new File(this.schemaPath))
												.newValidator()
												.validate(new StreamSource(
																new File(path))
														 );
		} catch (SAXException e) {
			return false;
		}
		return true;
	}

}
