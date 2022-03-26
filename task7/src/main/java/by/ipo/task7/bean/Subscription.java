package by.ipo.task7.bean;

import java.io.Serializable;

/**
 * This class represents subscription.
 * @author Pavel Isidovich
 *
 */
public class Subscription implements Serializable {
	
	/**Data fields*/
	private int trainingsQuantity;
	private String paymentDate;
	private String expireDate;
	
	/**
	 * Use nested builder class instead of this constructor.
	 */
	private Subscription() {
		
	}
	
	/**
	 * Use this class to create new subscription
	 * @author Pavel Isidovich
	 *
	 */
	public static class Builder {
		
		/**Data field*/
		private Subscription subscription;
		
		public Builder() {
			this.subscription = new Subscription();
		}
		
		public Builder withTrainingsQuantity(int trainingsQuantity) {
			this.subscription.trainingsQuantity = trainingsQuantity;
			return this;
		}
		
		public Builder withPaymentDate(String paymentDate) {
			this.subscription.paymentDate = paymentDate;
			return this;
		}
		
		public Builder withExpireDate(String expireDate) {
			this.subscription.expireDate = expireDate;
			return this;
		}
		
		public Subscription build() {
			return this.subscription;
		}
	}

	public int getTrainingsQuantity() {
		return trainingsQuantity;
	}

	public void setTrainingsQuantity(int trainingsQuantity) {
		this.trainingsQuantity = trainingsQuantity;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((expireDate == null) ? 0 : expireDate.hashCode());
		result = prime * result
				+ ((paymentDate == null) ? 0 : paymentDate.hashCode());
		result = prime * result + trainingsQuantity;
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
		Subscription other = (Subscription) obj;
		if (expireDate == null) {
			if (other.expireDate != null)
				return false;
		} else if (!expireDate.equals(other.expireDate))
			return false;
		if (paymentDate == null) {
			if (other.paymentDate != null)
				return false;
		} else if (!paymentDate.equals(other.paymentDate))
			return false;
		if (trainingsQuantity != other.trainingsQuantity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subscription [trainingsQuantity=" + trainingsQuantity
				+ ", paymentDate=" + paymentDate + ", expireDate=" + expireDate
				+ "]";
	}
}
