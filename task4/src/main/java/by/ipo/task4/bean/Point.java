package by.ipo.task4.bean;

import java.io.Serializable;

/**
 * This class represents point on XY-plane.
 * @author Pavel Isidovich
 *
 */
public class Point implements Serializable {
	
	/**Coordinate fields*/
	private double x;
	private double y;
	
	/**
	 * This constructor creates new point-object with given 
	 * coordinates.
	 * @param x - x-axis coordinate
	 * @param y - y-axis coordinate
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	private Point() {
		
	}
	
	/**
	 * This method returns x-axis coordinate.
	 * @return x-axis coordinate
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * This method returns y-axis coordinate.
	 * @return y-axis coordinate
	 */
	public double getY() {
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Point other = (Point) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
}
