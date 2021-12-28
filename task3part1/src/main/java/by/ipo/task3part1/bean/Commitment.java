package by.ipo.task3part1.bean;

import java.io.IOException;
import java.io.Serializable;

/**
 * This class represents commitment.
 * @author Pavel Isidovich
 *
 */
public class Commitment implements Serializable {
	
	private int cost;
	private double riskCoefficient;
	
	public Commitment() {
		
	}
	
	public Commitment(int cost, double riskCoefficient) throws IOException {
		if (cost < 0 || riskCoefficient < 0) {
			throw new IOException();
		} else {
			this.cost = cost;
			this.riskCoefficient = riskCoefficient;
		}	
	}
	
	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) throws IOException {
		if (cost < 0) {
			throw new IOException();
		} else {
			this.cost = cost;
		}
	}
	
	public double getRiskCoefficient() {
		return riskCoefficient;
	}
	
	public void setRiskCoefficient(double riskCoefficient) throws IOException {
		if (riskCoefficient < 0) {
			throw new IOException();
		} else {
			this.riskCoefficient = riskCoefficient;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cost;
		long temp;
		temp = Double.doubleToLongBits(riskCoefficient);
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
		Commitment other = (Commitment) obj;
		if (cost != other.cost)
			return false;
		if (Double.doubleToLongBits(riskCoefficient) != Double.doubleToLongBits(other.riskCoefficient))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Commitment [cost=" + cost + ", riskCoefficient=" + riskCoefficient + "]";
	}


}
