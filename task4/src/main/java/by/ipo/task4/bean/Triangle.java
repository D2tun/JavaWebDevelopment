package by.ipo.task4.bean;

import java.io.Serializable;
import java.util.Arrays;

/**
 * This class represents triangle.
 * @author Pavel Isidovich
 *
 */
public class Triangle implements Serializable {

	/**Triangle's points field*/
	private Point[] points = new Point[3];
	/**Triangle's id field*/
	private Integer id = 0;
	
	private Triangle() {
		
	}
	
	/**
	 * This constructor creates new triangle-object with given points.
	 * @param point1 - point on XY-plane
	 * @param point2 - point on XY-plane
	 * @param point3 - point on XY-plane
	 * @see Point
	 */
	public Triangle(Point point1, Point point2, Point point3) {
		this.points[0] = point1;
		this.points[1] = point2;
		this.points[2] = point3;
	}

	/**
	 * This method returns points of triangle.
	 * @return array of points
	 * @see Point
	 */
	public Point[] getPoints() {
		Point[] points = this.points.clone();
		return points;
	}

	/**
	 * This method changes target point to entered one.
	 * @param point - entered point
	 * @param index - index of target point
	 */
	public void setPoint(Point point, int index) {
		this.points[index] = point;
	}
	
	/**
	 * This method returns point cording to index.
	 * @param index - index of target point
	 * @return point cording to index
	 */
	public Point getPoint(int index) {
		return this.points[index];
	}
	
	/**
	 * This method returns id-field's value. If id-field is empty,
	 * returns null.
	 * @return value of id-field
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * This method sets id-field's value. 
	 * @param id - value of id
	 */
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(points);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		if (!Arrays.equals(points, other.points))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Triangle [points=" + Arrays.toString(points) + "id=" + id + "]";
	}
}
