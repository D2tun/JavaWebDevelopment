package by.ipo.task7.bean;

import java.io.Serializable;

/**
 * This class represents appointment.
 * @author Pavel Isidovich
 *
 */
public class Appointment implements Serializable {
	
	/**Data fields*/
	private String content;
	private String comment;
	private int rating;
	private String creationDate;
	private String status;
	
	/**
	 * Use nested builder class instead of this constructor.
	 */
	private Appointment() {
		
	}

	/**
	 * Use this class to create new appointment.
	 * @author Pavel Isidovich
	 *
	 */
	public static class Builder {
		
		/**Data field*/
		private Appointment appointment;
		
		public Builder() {
			this.appointment = new Appointment();
		}
		
		public Builder withContent(String content) {
			this.appointment.content = content;
			return this;
		}
		
		public Builder withComment(String comment) {
			this.appointment.comment = comment;
			return this;
		}
		
		public Builder withRating(int rating) {
			this.appointment.rating = rating;
			return this;
		}
		
		public Builder withCreationDate(String creationDate) {
			this.appointment.creationDate = creationDate;
			return this;
		}
		
		public Builder withStatus(String status) {
			this.appointment.status = status;
			return this;
		}
		
		public Appointment build() {
			return this.appointment;
		}
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
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
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result
				+ ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + rating;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Appointment other = (Appointment) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
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
		if (rating != other.rating)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Appointment [content=" + content + ", comment=" + comment
				+ ", rating=" + rating + ", creationDate=" + creationDate
				+ ", status=" + status + "]";
	}
}
