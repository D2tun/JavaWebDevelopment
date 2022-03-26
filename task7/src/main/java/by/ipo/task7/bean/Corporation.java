package by.ipo.task7.bean;

import java.io.Serializable;

/**
 * This class represents client's corporation
 * @author Pavel Isidovich
 *
 */
public class Corporation implements Serializable {
	
	/**Data fields*/
	private String name;
	private String corporationInfo;
	
	/**
	 * Use nested builder class instead of this constructor.
	 */
	private Corporation() {
		
	}
	
	/**
	 * Use this class to create new corporation
	 * @author Pavel Isidovich
	 *
	 */
	public static class Builder {
		
		/**Data field*/
		private Corporation corporation;
		
		public Builder() {
			this.corporation = new Corporation();
		}
		
		public Builder withName(String name) {
			this.corporation.name = name;
			return this;
		}
		
		public Builder withCorporationInfo(String corporationInfo) {
			this.corporation.corporationInfo = corporationInfo;
			return this;
		}
		
		public Corporation build() {
			return this.corporation;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCorporationInfo() {
		return corporationInfo;
	}

	public void setCorporationInfo(String corporationInfo) {
		this.corporationInfo = corporationInfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((corporationInfo == null) ? 0 : corporationInfo.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Corporation other = (Corporation) obj;
		if (corporationInfo == null) {
			if (other.corporationInfo != null)
				return false;
		} else if (!corporationInfo.equals(other.corporationInfo))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Corporation [name=" + name + ", corporationInfo="
				+ corporationInfo + "]";
	}
}
