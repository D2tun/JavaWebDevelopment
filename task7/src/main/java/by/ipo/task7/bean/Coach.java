package by.ipo.task7.bean;

import java.io.Serializable;

/**
 * This class represents coach of a gym.
 * @author Pavel Isidovich
 *
 */
public class Coach implements Serializable {

	/**Data fields*/
	private User user;
	private String coachInfo;
	
	/**
	 * Use nested builder class instead of this constructor.
	 */
	private Coach() {
		
	}
	
	/**
	 * Use this class to create new coach
	 * @author Pavel Isidovich
	 *
	 */
	public static class Builder {
		
		/**Data field*/
		private Coach coach;
		
		public Builder() {
			this.coach = new Coach();
		}
		
		public Builder withUser(User user) {
			this.coach.user = user;
			return this;
		}
		
		public Builder withCoachInfo(String coachInfo) {
			this.coach.coachInfo = coachInfo;
			return this;
		}
		
		public Coach build() {
			return this.coach;
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCoachInfo() {
		return coachInfo;
	}

	public void setCoachInfo(String coachInfo) {
		this.coachInfo = coachInfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coachInfo == null) ? 0 : coachInfo.hashCode());
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
		Coach other = (Coach) obj;
		if (coachInfo == null) {
			if (other.coachInfo != null)
				return false;
		} else if (!coachInfo.equals(other.coachInfo))
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
		return "Coach [user=" + user + ", coachInfo=" + coachInfo + "]";
	}
}
