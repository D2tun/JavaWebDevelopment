package by.epam.task1.ipo.bean;

import java.io.Serializable;

public class Triangle implements Serializable {
	
	private double side1;
	private double side2;
	private double side3;
	
	public Triangle() {
		
	}
	
	public Triangle(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	public boolean isEquilateral() {
		if ((side1 == side2) && (side1 == side3)) {
			return true;
		} else {
			return false;
		}
	}

	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) {
		this.side1 = side1;
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) {
		this.side2 = side2;
	}

	public double getSide3() {
		return side3;
	}

	public void setSide3(double side3) {
		this.side3 = side3;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(side1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(side2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(side3);
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
		Triangle other = (Triangle) obj;
		if (Double.doubleToLongBits(side1) 
				!= Double.doubleToLongBits(other.side1))
			return false;
		if (Double.doubleToLongBits(side2) 
				!= Double.doubleToLongBits(other.side2))
			return false;
		if (Double.doubleToLongBits(side3) 
				!= Double.doubleToLongBits(other.side3))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Triangle [side1=" + side1 + ", side2=" + side2 + ", side3="
				+ side3 + "]";
	}
	
}
