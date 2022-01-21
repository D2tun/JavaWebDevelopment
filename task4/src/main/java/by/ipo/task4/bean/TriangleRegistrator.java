package by.ipo.task4.bean;

/**
 * This class storing perimeters and areas of triangles in repository.
 * Each registrator got same id as it's triangle
 * @author Pavel Isidovich
 * @see Triangle
 * @see TriangleRepository
 *
 */
public class TriangleRegistrator {
	
	private Integer id = 0;
	private double perimeter;
	private double area;
	
	private TriangleRegistrator() {
		
	}
	
	public TriangleRegistrator(double perimeter, double area) {
		this.area = area;
		this.perimeter = perimeter;
	}
	
	public TriangleRegistrator(double perimeter, double area, int id) {
		this.area = area;
		this.perimeter = perimeter;
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public double getPerimeter() {
		return perimeter;
	}
	
	public void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}
	
	public double getArea() {
		return area;
	}
	
	public void setArea(double area) {
		this.area = area;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(area);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		temp = Double.doubleToLongBits(perimeter);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		TriangleRegistrator other = (TriangleRegistrator) obj;
		if (Double.doubleToLongBits(area) 
				!= Double.doubleToLongBits(other.area))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(perimeter) 
				!= Double.doubleToLongBits(other.perimeter))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TriangleRegistrator [id=" + id + ", perimeter=" + perimeter 
				+ ", area=" + area + "]";
	}
}
