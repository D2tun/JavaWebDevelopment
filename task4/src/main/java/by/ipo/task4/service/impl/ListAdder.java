package by.ipo.task4.service.impl;

import java.util.List;

import by.ipo.task4.bean.Triangle;
import by.ipo.task4.service.Repository;

/**
 * This class provides method to add list of objects to repository.
 * @author Pavel Isidovich
 *
 */
public class ListAdder {
	
	/**
	 * This method adds lost of objects to repository.
	 * @param list - list of objects
	 */
	public static void addList(List<Triangle> list) {
		Repository<Triangle> rep = TriangleRepository.getInstance();
		
		for(int i = 0; i < list.size(); ++i) {
			rep.update(list.get(i));
		}
	}
}
