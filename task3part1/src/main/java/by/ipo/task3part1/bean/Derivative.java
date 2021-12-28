package by.ipo.task3part1.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents derivative (list of commitments).
 * @author Pavel Isidovich
 *
 */
public class Derivative implements Serializable {
	
	private List<Commitment> derivative;
	
	public Derivative() {
		this.derivative = new ArrayList<Commitment>();
	}
	
	public Commitment getCommitment(int index) {
		return this.derivative.get(index);
	}
	
	public void addCommitment (Commitment commitment) {
		this.derivative.add(commitment);
	}
	
	public void deleteCommitment(int index) {
		this.derivative.remove(index);
	}
	
	public List<Commitment> getDerivative() {
		return this.derivative;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((derivative == null) ? 0 : derivative.hashCode());
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
		Derivative other = (Derivative) obj;
		if (derivative == null) {
			if (other.derivative != null)
				return false;
		} else if (!derivative.equals(other.derivative))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Derivative [derivative=" + derivative + "]";
	}
}
