package by.ipo.task1.bean;

import java.io.Serializable;

/**
 * This class represents expression of type |a * x * x + b * x + c|
 * @author Pavel Isidovich
 *
 */
public class SquareExpressionAbs implements Serializable {
	
	/** Parameter field*/
	private double a;
	/** Parameter field*/
	private double b;
	/** Parameter field*/
	private double c;
	/** Parameter field*/
	private double x;
	
	public SquareExpressionAbs() {
		
	}
	
	/**
	 * This constructor takes parameters and creates new expression object.
	 * @param a - expression's parameter
	 * @param b - expression's parameter
	 * @param c - expression's parameter
	 * @param x - expression's parameter
	 */
	public SquareExpressionAbs(double a, double b, double c, double x) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.x = x;
	}
	
	/**
	 * This method calculate given expression.
	 * @return result of calculation
	 */
	public double getResult() {
		return StrictMath.abs(a * x * x + b * x + c);	
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(a);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(b);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(c);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(x);
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
		SquareExpressionAbs other = (SquareExpressionAbs) obj;
		if (Double.doubleToLongBits(a) != Double.doubleToLongBits(other.a))
			return false;
		if (Double.doubleToLongBits(b) != Double.doubleToLongBits(other.b))
			return false;
		if (Double.doubleToLongBits(c) != Double.doubleToLongBits(other.c))
			return false;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SquareExpressionAbs [a=" + a + ", b=" + b + ", c=" + c + ", x=" 
									+ x + "]";
	}
}
