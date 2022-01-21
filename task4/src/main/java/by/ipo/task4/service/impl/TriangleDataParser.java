package by.ipo.task4.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import by.ipo.task4.bean.Point;
import by.ipo.task4.bean.Triangle;

/**
 * This class provides methods to parse triangle's data.
 * @author Pavel Isidovich
 * @see Triangle
 */
public class TriangleDataParser {
	
	private static org.apache.logging.log4j
					.Logger logger = LogManager.getFormatterLogger();

	/**
	 * This method parses data from txt-file.
	 * @param data - triangle's data
	 * @return list of correct triangles
	 */
	public static List<Triangle> parseTxt(List<String> data) {
		logger.trace("Данные получены");
		
		List<Triangle> triangles = new ArrayList<Triangle>();
		final int TRIANGLE_POINTS = 3;
		Point[] points = new Point[TRIANGLE_POINTS];
		final int POINT_COORDINATES = 2;
		
		for (int i = 0; i < data.size(); ++i) {
			String[] unparsedPoints = data.get(i).split(",");
			if (unparsedPoints.length != TRIANGLE_POINTS) {
				logger.error("Повреждённые данные: строка " + i);
				continue;
			}
			for (int j = 0; j < unparsedPoints.length; ++j) {
				String[] coordinates = unparsedPoints[j].split(" ");

				if (coordinates.length != POINT_COORDINATES) {
					logger.error("Повреждённые данные: строка " + i 
								+ " точка " + j);
					continue;
				}
				try {
					points[j] = new Point(Double.parseDouble(coordinates[0]), 
										Double.parseDouble(coordinates[1]));
				} catch (NumberFormatException e) {
					points[j] = null;
					continue;
				}
			}

			if ((points[0] == null) || (points[1] == null)
					|| (points[2] == null) 
					|| (((points[0].getX() == points[1].getX()) 
					& (points[1].getX() == points[2].getX())) 
					|| ((points[0].getY() == points[1].getY()) 
					& (points[1].getY() == points[2].getY())))) {
				logger.error("Повреждённые данные: строка " + i);
				continue;
			}
			triangles.add(new Triangle(points[0], points[1], points[2]));
		}
		
		logger.trace("Ответ отправлен");
		
		return triangles;
	}
	
	/**
	 * This method parses data from json-file.
	 * @param je - file's content in json-element format
	 * @return list of correct triangles
	 */
	public static List<Triangle> parseJson(JsonElement je) {
		logger.trace("Данные получены");
		
		JsonArray jTriangles = je.getAsJsonObject().get("triangles")
													.getAsJsonArray();
		List<Triangle> triangles = new ArrayList<Triangle>();
		final int TRIANGLE_POINTS = 3;
		Point[] points = new Point[TRIANGLE_POINTS];

		for (int i = 0; i < jTriangles.size(); ++i) {
			for (int j = 0; j < points.length; ++j) {
				try {
					if (jTriangles.get(i).getAsJsonObject().get("points")
													.getAsJsonArray().size() 
							!= TRIANGLE_POINTS) {
						logger.error("Повреждённые данные: 'triangles' элемент " 
									+ i);
						continue;
					}
					points[j] = new Point(jTriangles.get(i).getAsJsonObject()
															.get("points")
															.getAsJsonArray()
															.get(j)
															.getAsJsonObject()
															.get("x")
															.getAsDouble(), 
										  jTriangles.get(i).getAsJsonObject()
															.get("points")
															.getAsJsonArray()
															.get(j)
															.getAsJsonObject()
															.get("y")
															.getAsDouble());
				} catch (ClassCastException | IllegalStateException
							| NumberFormatException | NullPointerException e1) {
					logger.error("Повреждённые данные: 'triangles' элемент " 
								+ i + " 'points' элемент " + j);
					points[j] = null;
					continue;
				}
			}

			if ((points[0] == null) || (points[1] == null)
					|| (points[2] == null) 
					|| (((points[0].getX() == points[1].getX()) 
					& (points[1].getX() == points[2].getX())) 
					|| ((points[0].getY() == points[1].getY()) 
					& (points[1].getY() == points[2].getY())))) {
				logger.error("Повреждённые данные: 'triangles' элемент" + i);
				continue;
			}

			triangles.add(new Triangle(points[0], points[1], points[2]));
		}

		return triangles;	
	}
}
