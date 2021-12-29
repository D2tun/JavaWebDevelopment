package by.ipo.task3part2.service;

import by.ipo.task3part2.bean.ArtExhibition;
import by.ipo.task3part2.service.exception.ServiceException;

/**
 * This interface is imlemented by classes, operating with 
 * ArtExhibition
 * @author Pavel Isidovich
 * @see ArtExhibition
 */
public interface ExhibitionReader {
	
	public ArtExhibition[] read(String path) throws ServiceException;

}
