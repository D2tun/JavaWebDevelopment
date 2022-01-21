package by.ipo.task4.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.ipo.task4.bean.Point;
import by.ipo.task4.bean.Triangle;
import by.ipo.task4.bean.TriangleRegistrator;
import by.ipo.task4.service.Repository;

/**
 * This class represents repository of triangles.
 * @author Pavel Isidovich
 * @see Triangle
 */
public class TriangleRepository implements Repository<Triangle> {

	private static TriangleRepository instance = new TriangleRepository();
	
	private List<Triangle> triangles = new ArrayList<Triangle>();
	private List<TriangleRegistrator> registrators = 
							new ArrayList<TriangleRegistrator>();
	private int idCounter = 1;
	
	/**
	 * This method returns link on existing object of this class. If
	 * object doesn't exist, creates new object of this class.
	 * @return <strong>instance</strong> of the object.
	 */
	public static TriangleRepository getInstance() {
		return instance;
	}
	
	/**
	 * This method adds given triangle to the repository.
	 * @param triangle - triangle to add
	 * @see Triangle
	 */
	@Override
	public void update(Triangle triangle) {
		if (this.find(triangle.getPoints()) == null) {
			triangle.setId(this.idCounter);
			this.triangles.add(triangle);
			triangle.setId(this.idCounter);
			this.registrators
					.add(new TriangleRegistrator(TriangleOperator
													.calculatePerimeter(triangle), 
												 TriangleOperator
													.calculateArea(triangle),
												 this.idCounter));
			++this.idCounter;
		} else {
			triangle.setId(this.triangles.get(this.findPosition(triangle)).getId());
			this.triangles.set(this.findPosition(triangle), triangle);
			this.updateRegistrator(this.triangles
											.get(this.findPosition(triangle))
														.getId(), 
								   TriangleOperator.calculateArea(triangle), 
								   TriangleOperator
								   		.calculatePerimeter(triangle));
		}	
	}

	/**
	 * This method returns triangle, if it is in the repository. Else
	 * returns null.
	 * @param points - points of triangle
	 * @return triangle if it exists in list, else null
	 * @see Triangle
	 * @see Point
	 */
	@Override
	public Triangle find(Point[] points) {
		if (points.length != 3) {
			return null;
		}
		
		for(int i = 0; i < this.triangles.size(); ++i) {
			boolean got = false;
			for (int j = 0; j < points.length; ++j) {
				for (int k = 0; k < points.length; ++k) {
					if (triangles.get(i).getPoint(j).getX() == points[k].getX()
							&& triangles.get(i).getPoint(j).getY() 
							   == points[k].getY()) {
						got = true;
					} else {
						got = false;
					}
				}
				if (got == true) {
					return triangles.get(i);
				}
			}
		}
		
		return null;
	}

	/**
	 * This method returns triangle with given id.
	 * @param id - id of object
	 * @return triangle with given id
	 * @see Triangle
	 */
	@Override
	public Triangle find(int id) {
		for (int i = 0; i < this.triangles.size(); ++i) {
			if (this.triangles.get(i).getId() == id) {
				return this.triangles.get(i);
			}
		}
		return null;
	}

	/**
	 * This method deletes triangle with given id.
	 * @param id - id of object
	 * @see Triangle
	 */
	@Override
	public void delete(int id) {
		for (int i = 0; i < this.triangles.size(); ++i) {
			if (this.triangles.get(i).getId() == id) {
				this.triangles.remove(i);
				this.registrators.remove(i);
			}
		}
	}

	/**
	 * This method returns given triangle's position in repository's
	 * list, if it exists.
	 * @param t - target triangle
	 * @return position in list if object exists, else -1 
	 * @see Triangle
	 */
	@Override
	public int findPosition(Triangle triangle) {
		return this.triangles.indexOf(this.find(triangle.getPoints()));
	}
	
	/**
	 * This method returns registrator with given id.
	 * @param id - id of registrator
	 * @return registrator if it exists in list, else - null.
	 * @see TriangleRegistrator
	 */
	public TriangleRegistrator findRegistrator(int id) {
		for (int i = 0; i < this.registrators.size(); ++i) {
			if (this.registrators.get(i).getId().intValue() == id) {
				return this.registrators.get(i);
			}
		}
		
		return null;
	}
	
	/**
	 * This method updates registrator with given id if it exists.
	 * @param id - id of registrator
	 * @param area - new area value. If you don't need to change that
	 * parameter, enter value equal or less then 0.
	 * @param perimeter - new perimeter value. If you don't need to 
	 * change that parameter, enter value equal or less then 0.
	 */
	public void updateRegistrator(int id, double area, double perimeter) {
		if (area > 0) {
			this.findRegistrator(id).setArea(area);
		}
		if (perimeter > 0) {
			this.findRegistrator(id).setPerimeter(perimeter);
		}
	}
	
	/**
	 * This method returns list of repositorie's content.
	 * @return list of repositorie's content
	 */
	public List<Triangle> giveContent() {
		List<Triangle> content = new ArrayList<Triangle>(this.triangles);
		return content;
	}
}
