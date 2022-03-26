package by.ipo.task7.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {
	
	/**Data fields*/
	private String content;
	private String creationDate;
	private String paymentDate;
	private Subscription subscription;
	private Client client;
	private Coach coach;
	private List<Appointment> appointments = new ArrayList<>();
	
	/**
	 * Use nested builder class instead of this constructor.
	 */
	private Order() {
		
	}

	/**
	 * Use this class to create new order.
	 * @author Pavel Isidovich
	 *
	 */
	public static class Builder {
		
		/**Data field*/
		private Order order;
		
		public Builder() {
			this.order = new Order();
		}
		
		public Builder withContent(String content) {
			this.order.content = content;
			return this;
		}
		
		public Builder withCreationDate(String creationDate) {
			this.order.creationDate = creationDate;
			return this;
		}
		
		public Builder withPaymentDate(String paymentDate) {
			this.order.paymentDate = paymentDate;
			return this;
		}
		
		public Builder withSubscription(Subscription subscription) {
			this.order.subscription = subscription;
			return this;
		}
		
		public Builder withClient(Client client) {
			this.order.client = client;
			return this;
		}
		
		public Builder withCoach(Coach coach) {
			this.order.coach = coach;
			return this;
		}
		
		public Builder withAppointments(ArrayList<Appointment> appointments) {
			this.order.appointments = appointments;
			return this;
		}
		
		public Order build() {
			return this.order;
		}
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Coach getCoach() {
		return coach;
	}

	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	
	public void addAppointment(Appointment appointment) {
		this.appointments.add(appointment);
	}
	
	public void removeAppointment(Appointment appointment) {
		this.appointments.remove(appointment);
	}
	
	public int getAppointmentQuantity() {
		return this.appointments.size();
	}
	
	public Appointment getAppointment(int index) {
		return this.appointments.get(index);
	}
	
	public void addAll(List<Appointment> appointments) {
		this.appointments.addAll(appointments);
	}
	
	public List<Appointment> getAppointments() {
		return appointments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((appointments == null) ? 0 : appointments.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((coach == null) ? 0 : coach.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result
				+ ((paymentDate == null) ? 0 : paymentDate.hashCode());
		result = prime * result
				+ ((subscription == null) ? 0 : subscription.hashCode());
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
		Order other = (Order) obj;
		if (appointments == null) {
			if (other.appointments != null)
				return false;
		} else if (!appointments.equals(other.appointments))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (coach == null) {
			if (other.coach != null)
				return false;
		} else if (!coach.equals(other.coach))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (creationDate == null) {
			if (other.creationDate != null)
				return false;
		} else if (!creationDate.equals(other.creationDate))
			return false;
		if (paymentDate == null) {
			if (other.paymentDate != null)
				return false;
		} else if (!paymentDate.equals(other.paymentDate))
			return false;
		if (subscription == null) {
			if (other.subscription != null)
				return false;
		} else if (!subscription.equals(other.subscription))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [content=" + content + ", creationDate=" + creationDate
				+ ", paymentDate=" + paymentDate + ", subscription="
				+ subscription + ", client=" + client + ", coach=" + coach
				+ ", appointments=" + appointments + "]";
	}
}
