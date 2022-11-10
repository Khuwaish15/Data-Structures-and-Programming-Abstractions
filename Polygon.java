package CSE260;
import java.util.*;

public class Polygon {
	public static void main(SPoint[] args) {
		ArrayList<Point> points = new ArrayList<Point>();
		points.add(new Point(x: 1, y: 0));
		points.add(new Point(x: 0, y: 1));
		points.add(new Point(x: 1, y: 2));
		points.add(new Point(x: 2, y: 1));
		
		ArrayList<Line> lines = newArrayList<Line>();
		lines.add(getLine(points.get(points.size() -1), points.get(0)));
		for (int i =1; i < points.size(); i++) {
			lines.add(getLine(points.get(i), points.get(i-1)));
		}
		
		for(int i = 0; i < lines.size(); i++) {
			for(int j = i+1; j < lines.size(); j++) {
				Point point = intersects(lines.get(i), lines.get(j));
				
				if(point != null) {
					boolean intersectionIsOnPoint = false;
					for(int k =0; k < points.size(); k++) {
						if(point.x == points.get(k).x && point.y == points.get(k).y) {
							intersectionIsOnPoint = true;
							break;
						}
					}
					if(!intersectionIsOnPoint) {
						System.out.println("True");
						return;
					}
				}
			}
		}
		
		System.out.println("False");
	}
	
	public static Line getLine(Point point1, Point point2) {
		double slope = (point2.y - point1.y) / (point2.x - point1.x);
		double intercept = point1.y - slope * point1.x;
		return new Line(slope, intercept);
		}
	
	public static Point intersects(Line l1, Line l2) {
		if(l1.slope == l2.slope) return null;
		
		double x = (l1.intercept - l2.intercept)/(l2.slope - l1.slope);
		double y = l1.slope * x + l1.intercept;
		
		return new Point(x, y);
	}

}

class Point{
	double x;
	double y;
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
}

class Line{
	double slope;
	double intercept;
	public Line(double m, double b) {
		this.slope = m;
		this.intercept = b;
	}

}
