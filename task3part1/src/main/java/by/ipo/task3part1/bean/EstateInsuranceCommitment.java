package by.ipo.task3part1.bean;

import java.io.IOException;
import java.io.Serializable;

/**
 * This class represents estate insurance commitment.
 * @author Pavel Isidovich
 * @see Commitment
 */
public class EstateInsuranceCommitment extends Commitment 
				implements Serializable {
	
	public EstateInsuranceCommitment() {
		super();
	}
	
	public EstateInsuranceCommitment (int cost, double risk) throws IOException {
		super(cost, risk);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EstateInsuranceCommitment []";
	}
}
