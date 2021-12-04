package by.epam.task1.ipo.bean;

import java.io.Serializable;

/**
 * Rectangle presentation class.
 * @author Pavel Isidovich
 */

public class Rectangle implements Serializable {

	/** Length field */
	private double length;
	/** Width field */
	private double width;
	/** Area field */
	private double area;
	
	public Rectangle() {
		
	}
	
	/** 
	 * This constructor takes length value and creates new rectangle
	 * object with width = length / 2, area = width * length. Field's
	 * values can be read by standard get-methods.
	 * @param length - rectangle's length
	 * @see Rectangle#Rectangle(double)
	 */
	
	public Rectangle(double length) {
		this.length = length;
		this.width = length / 2;
		this.area = this.length * this.width;
	}
	
	public void setLength(double length) {
		this.length = length;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public void setArea(double area) {
		this.area = area;
	}
	
	public double getLength() {
		return this.length;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double getArea() {
		return this.area;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(area);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(length);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(width);
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
		Rectangle other = (Rectangle) obj;
		if (Double.doubleToLongBits(area) != Double.doubleToLongBits(other.area))
			return false;
		if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
			return false;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Quadrangle [length=" + length + ", width=" + width + ", area=" + area + "]";
	}

}
