package by.ipo.task7.bean;

import java.io.Serializable;

/**
 * This class represents client of a gym.
 * @author Pavel Isidovich
 *
 */
public class Client implements Serializable {

	/**Data fields*/
	private User user;
	private Corporation corporation;
	private String status;
	
	/**
	 * Use nested builder class instead of this constructor.
	 */
	private Client() {
		
	}
	
	/**
	 * Use this class to create new client
	 * @author Pavel Isidovich
	 *
	 */
	public static class Builder {
		
		/**Data field*/
		private Client client;
		
		public Builder() {
			this.client = new Client();
		}
		
		public Builder withCorporation(Corporation corporation) {
			this.client.corporation = corporation;
			return this;
		}
		
		public Builder withUser(User user) {
			this.client.user = user;
			return this;
		}
		
		public Builder withStatus(String status) {
			this.client.status = status;
			return this;
		}
		
		public Client build() {
			return this.client;
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Corporation getCorporation() {
		return corporation;
	}

	public void setCorporation(Corporation corporation) {
		this.corporation = corporation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((corporation == null) ? 0 : corporation.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Client other = (Client) obj;
		if (corporation == null) {
			if (other.corporation != null)
				return false;
		} else if (!corporation.equals(other.corporation))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [user=" + user + ", corporation=" + corporation
				+ ", status=" + status + "]";
	}
}
