package by.ipo.task1.bean;

import java.io.Serializable;

/**
 * This class represents expression of type 
 * (a / c) * (b / d) - ((a * b - c) / (c * d))
 * @author Pavel Isidovich
 *
 */
public class FirstExpression implements Serializable {
	
	private double a;
	private double b;
	private double c;
	private double d;
	
	public FirstExpression() {
		
	}
	
	/**
	 * This constructor takes parameters and creates new expression object.
	 * @param a - expression's parameter
	 * @param b - expression's parameter
	 * @param c - expression's parameter
	 * @param d - expression's parameter
	 */
	public FirstExpression(double a, double b, double c, double d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}
	
	/**
	 * This method calculate given expression.
	 * @return result of calculation
	 */
	public double getResult() {
		return (a / c) * (b / d) - ((a * b - c) / (c * d));
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

	public double getD() {
		return d;
	}

	public void setD(double d) {
		this.d = d;
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
		temp = Double.doubleToLongBits(d);
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
		FirstExpression other = (FirstExpression) obj;
		if (Double.doubleToLongBits(a) != Double.doubleToLongBits(other.a))
			return false;
		if (Double.doubleToLongBits(b) != Double.doubleToLongBits(other.b))
			return false;
		if (Double.doubleToLongBits(c) != Double.doubleToLongBits(other.c))
			return false;
		if (Double.doubleToLongBits(d) != Double.doubleToLongBits(other.d))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FirstExpression [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + "]";
	}

}
