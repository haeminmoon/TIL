import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*Check circles whether to intersect*/
public class IntersectCircles {
	public static void main(String[] args) {
		int num;
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		
		List<Circle> circleList = getInputCircle(num);

		printIntersectCircles(circleList);
	}
	
	public static void printIntersectCircles(List<Circle> cl) {
		Comparator<Circle> listSort = new Comparator<Circle>() {
			public int compare(Circle c1, Circle c2) {
				return c1.getId().compareToIgnoreCase(c2.getId());
			}
		};
		
		Collections.sort(cl, listSort);
		
		for(int i=0; i<cl.size(); i++) {
			for(int j=i+1; j<cl.size(); j++) {
				cl.get(i).print(cl.get(i), cl.get(j));
			}
		}
	}
	
	public static List<Circle> getInputCircle(int num) {
		List<Circle> cl = new ArrayList<>();
		
		String id;
		float centerX;
		float centerY;
		float radius;
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<num ; i++) {
			id = sc.next();
			centerX = sc.nextFloat();
			centerY = sc.nextFloat();
			radius = sc.nextFloat();
			
			cl.add(new Circle(id, centerX, centerY, radius));
		}
		return cl;
	}
}

class Circle {
	String id;
	float centerX;
	float centerY;
	float radius;
	
	public Circle(String id, float centerX, float centerY, float radius) {
		this.id = id;
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
	}
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	
	public boolean check(Circle c1, Circle c2) {
		float twoDistance;
		float twoRadius;

		float xdiff = c2.centerX - c1.centerX;
		float ydiff = c2.centerY - c1.centerY;

		twoDistance = (float) Math.sqrt(xdiff * xdiff + ydiff * ydiff);
		twoRadius = c1.radius + c2.radius;
		
		if(twoDistance < twoRadius)
			return true;
		else
			return false;
	}
	
	public void print(Circle c1, Circle c2) {
		if(check(c1, c2)) {
			System.out.println(c1.id + " " + c2.id);
		}
	}
}