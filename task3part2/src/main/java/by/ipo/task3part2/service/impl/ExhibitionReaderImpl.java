package by.ipo.task3part2.service.impl;

import by.ipo.task3part2.bean.ArtExhibition;
import by.ipo.task3part2.dao.exception.DAOException;
import by.ipo.task3part2.dao.factory.DAOFactory;
import by.ipo.task3part2.service.ExhibitionReader;
import by.ipo.task3part2.service.exception.ServiceException;

/**
 * This class provides method to read exhibition's information from
 * file
 * @author Pavel Isidovich
 *
 */
public class ExhibitionReaderImpl implements ExhibitionReader {

	@Override
	public ArtExhibition[] read(String path) throws ServiceException {
		
		try {
			return DAOFactory.getInstance().getDataOperator().readData(path);
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}
}
