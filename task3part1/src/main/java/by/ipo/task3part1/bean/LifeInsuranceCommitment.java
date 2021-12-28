package by.ipo.task3part1.bean;

import java.io.IOException;
import java.io.Serializable;

/**
 * This class represents life insurance commitment.
 * @author Pavel Isidovich
 * @see Commitment
 */
public class LifeInsuranceCommitment extends Commitment implements Serializable {
	
	public LifeInsuranceCommitment() {
		super();
	}
	
	public LifeInsuranceCommitment (int cost, double risk) throws IOException {
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
		return "LifeInsuranceCommitment []";
	}
}
