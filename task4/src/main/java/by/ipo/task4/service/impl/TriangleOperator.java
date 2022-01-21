package by.ipo.task4.service.impl;

import by.ipo.task4.bean.Triangle;

/**
 * This class provides method for triangle calculations.
 * @author Pavel Isidovich
 * @see Triangle
 */
public class TriangleOperator {
	
	private static double[] calculateSides(Triangle triangle) {
		double side1 = StrictMath.sqrt(StrictMath
										.pow(triangle.getPoints()[0].getX() 
										 - triangle.getPoints()[1].getX(), 2) 
										 + StrictMath.pow(triangle
												 			.getPoints()[0]
												 			.getY() 
										 - triangle.getPoints()[1].getY(), 2));
		double side2 = StrictMath.sqrt(StrictMath
										.pow(triangle.getPoints()[1].getX() 
										 - triangle.getPoints()[2].getX(), 2) 
										 + StrictMath.pow(triangle
												 			.getPoints()[1]
												 			.getY() 
										 - triangle.getPoints()[2].getY(), 2));
		double side3 = StrictMath.sqrt(StrictMath
										.pow(triangle.getPoints()[2].getX() 
										 - triangle.getPoints()[0].getX(), 2) 
										 + StrictMath.pow(triangle
												 			.getPoints()[2]
												 			.getY() 
										 - triangle.getPoints()[0].getY(), 2));
		return new double[] {side1, side2, side3};
	}
	
	/**
	 * This method calculates perimeter of given triangle.
	 * @param triangle - given triangle
	 * @return perimeter value
	 */
	public static double calculatePerimeter(Triangle triangle) {
		double[] sides = calculateSides(triangle);
		return sides[0] + sides[1] + sides[2];
	}
	
	/**
	 * This method calculates area of given triangle.
	 * @param triangle
	 * @return area value
	 */
	public static double calculateArea(Triangle triangle) {
		double[] sides = calculateSides(triangle);
		double perimeter = calculatePerimeter(triangle);
		
		return StrictMath.sqrt((calculatePerimeter(triangle) / 2) 
				 				* ((perimeter / 2) - sides[0]) 
				 				* ((perimeter / 2) - sides[1]) 
				 				* ((perimeter / 2) - sides[2]));
	}

	/**
	 * This method checks if triangle is equilateral.
	 * @param triangle - triangle to check
	 * @return true if triangle is equilateral, else false
	 */
	public static boolean isEquilateral(Triangle triangle) {
		double[] sides = calculateSides(triangle);
		return (sides[0] == sides[1]) && (sides[1] == sides[2]);
	}
	
	/**
	 * This method checks if triangle is isosceles.
	 * @param triangle - triangle to check
	 * @return true if triangle is isosceles, else false
	 */
	public static boolean isIsosceles(Triangle triangle) {
		double[] sides = calculateSides(triangle);
		return (sides[0] == sides[1]) || (sides[0] == sides[2]) 
					|| (sides[2] == sides[1]) || (sides[2] == sides[0]);
	}
	
	private static double[] calculateAngles(Triangle triangle) {
		double[] sides = calculateSides(triangle);
		double[] angles = new double[3];
		
		angles[0] = StrictMath.acos((sides[0] * sides[0] + sides[1] * sides[1] 
					- sides[2] * sides[2]) / (2 * sides[0] * sides[1]));
		angles[1] = StrictMath.acos((sides[0] * sides[0] + sides[2] * sides[2] 
				- sides[1] * sides[1]) / (2 * sides[0] * sides[2]));
		angles[2] = StrictMath.acos((sides[1] * sides[1] + sides[2] * sides[2] 
					- sides[0] * sides[0]) / (2 * sides[1] * sides[2]));
		
		return angles;
	}
	
	/**
	 * This method checks if given triangle is right triangle, obtuse
	 * or acute.
	 * @param triangle - triangle to be checked
	 * @return "right" if triangle is right triangle, "obtuse" if 
	 * triangle is obtuse, "acute" if triangle is acute
	 */
	public static String defineTriangle(Triangle triangle) {
		double angles[] = calculateAngles(triangle);
		
		for (int i = 0; i < angles.length; ++i) {
			if (angles[i] == 1.5707963267948968) {
				return "right";
			} else if (angles[i] > 1.5707963267948968) {
				return "obtuse";
			}
		}
		
		return "acute";
	}
}
