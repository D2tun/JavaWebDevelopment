package by.ipo.task3part2.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * This class represents art exhibition. Contains inner class.
 * @author Pavel Isidovich
 * @see Picture
 */
public class ArtExhibition implements Serializable {
	
	private static ResourceBundle rb = ResourceBundle
										.getBundle("view", 
													Locale.getDefault());
	
	private String exhibitionDate;
	private List<Picture> pictures;
	
	public ArtExhibition() {
		this.pictures = new ArrayList<Picture>();
	}
	
	public ArtExhibition(String exhibitionDate) {
		this.exhibitionDate = exhibitionDate;
		this.pictures = new ArrayList<Picture>();
	}
	
	public String getExhibitionDate() {
		return exhibitionDate;
	}

	public void setExhibitionDate(String exhibitionDate) {
		this.exhibitionDate = exhibitionDate;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}
	
	public void addPicture(Picture picture) {
		this.pictures.add(picture);
	}
	
	public void addPicture(String name, String author) {
		this.pictures.add(new Picture(name, author));
	}
	
	public String formatToString() {
		String answer = this.exhibitionDate + ":\n";
		
		for (int i = 0; i < this.pictures.size(); ++i) {
			answer += rb.getString("picture") + ": \"" 
				   + this.pictures.get(i).getName() + "\", " 
				   + rb.getString("author") + ": " + this.pictures.get(i)
				   										.getAuthor() + "\n"; 
		}
		
		return answer;
	}
	
	/**
	 * This class represents picture and is inner class of art 
	 * exhibition.
	 * @author Pavel Isidovich
	 * @see ArtExhibition
	 */
	public class Picture implements Serializable {
		
		private String name;
		private String author;
		
		public Picture() {
			
		}
		
		public Picture(String name, String author) {
			this.name = name;
			this.author = author;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + ((author == null) ? 0 : author.hashCode());
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
			Picture other = (Picture) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (author == null) {
				if (other.author != null)
					return false;
			} else if (!author.equals(other.author))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		private ArtExhibition getEnclosingInstance() {
			return ArtExhibition.this;
		}

		@Override
		public String toString() {
			return "Picture [name=" + name + ", author=" + author + "]";
		}
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exhibitionDate == null) ? 0 : exhibitionDate.hashCode());
		result = prime * result + ((pictures == null) ? 0 : pictures.hashCode());
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
		ArtExhibition other = (ArtExhibition) obj;
		if (exhibitionDate == null) {
			if (other.exhibitionDate != null)
				return false;
		} else if (!exhibitionDate.equals(other.exhibitionDate))
			return false;
		if (pictures == null) {
			if (other.pictures != null)
				return false;
		} else if (!pictures.equals(other.pictures))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ArtExhibition [exhibitionDate=" + exhibitionDate + ", pictures=" + pictures + "]";
	}

	
}
