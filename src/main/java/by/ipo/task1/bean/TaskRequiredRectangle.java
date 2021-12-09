package by.ipo.task1.bean;

import java.io.Serializable;

/**
 * Rectangle presentation class.
 * @author Pavel Isidovich
 */

public class TaskRequiredRectangle implements Serializable {

	/** Length field */
	private double length;
	/** Width field */
	private double width;
	
	public TaskRequiredRectangle() {
		
	}
	
	/** 
	 * This constructor takes length value and creates new rectangle
	 * object with width = length / 2, area = width * length. Field's
	 * values can be read by standard get-methods.
	 * @param length - rectangle's length
	 * @see TaskRequiredRectangle#Rectangle(double)
	 */
	public TaskRequiredRectangle(double length) {
		this.length = length;
		this.width = length / 2;
	}
	
	public void setLength(double length) {
		this.length = length;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getLength() {
		return this.length;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double getArea() {
		return this.length * this.width;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
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
		TaskRequiredRectangle other = (TaskRequiredRectangle) obj;
		if (Double.doubleToLongBits(length) != Double.doubleToLongBits(other.length))
			return false;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Quadrangle [length=" + length + ", width=" + width + "]";
	}
}
