package by.ipo.task7.bean;

import java.io.Serializable;

/**
 * This class represents user.
 * @author Pavel Isidovich
 *
 */
public class User implements Serializable {
	
	/**Data fields*/
	private String email;
	private String password;
	private String role;
	private String name;
	private String surname;
	private String registrationDate;
	
	/**
	 * Use nested builder class instead of this constructor.
	 */
	private User() {
		
	}
	
	/**
	 * Use this class to create new user
	 * @author Pavel Isidovich
	 *
	 */
	public static class Builder {
		
		/**Data field*/
		private User user;
		
		public Builder() {
			this.user = new User();
		}
		
		public Builder withEmail(String email) {
			this.user.email = email;
			return this;
		}
		
		public Builder withPassword(String password) {
			this.user.password = password;
			return this;
		}
		
		public Builder withRole(String role) {
			this.user.role = role;
			return this;
		}
		
		public Builder withName(String name) {
			this.user.name = name;
			return this;
		}
		
		public Builder withSurname(String surname) {
			this.user.surname = surname;
			return this;
		}
		
		public Builder withRegistrationDate(String registrationDate) {
			this.user.registrationDate = registrationDate;
			return this;
		}
		
		public User build() {
			return this.user;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((registrationDate == null) ? 0
				: registrationDate.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", role="
				+ role + ", name=" + name + ", surname=" + surname
				+ ", registrationDate=" + registrationDate + "]";
	}
}
