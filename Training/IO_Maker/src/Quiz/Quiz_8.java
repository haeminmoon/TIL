package Quiz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*Check circles whether to intersect*/
public class Quiz_8 {
	public static void main(String[] args) {
		int num = getUserInput();
		List<Circle> circleList = getInputCircle(num);

		printIntersectCircles(circleList);
	}
	
	public static int getUserInput() {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		return input;
	}

	public static void printIntersectCircles(List<Circle> cl) {
		Comparator<Circle> listSort = new Comparator<Circle>() {
			public int compare(Circle c1, Circle c2) {
				return c1.getId() < c2.getId() ? -1 : (c1.getId() == c2.getId() ? 0 : 1);
			}
		};
		
		Collections.sort(cl, listSort);
		
		for(int i=0; i<cl.size(); i++) {
			for(int j=i+1; j<cl.size(); j++) {
				print(cl.get(i), cl.get(j));
			}
		}
	}
	
	public static void print(Circle c1, Circle c2) {
		if(c1.check(c1, c2)) {
			System.out.println(c1.id + " " + c2.id);
		}
	}
	
	public static List<Circle> getInputCircle(int num) {
		List<Circle> cl = new ArrayList<>();
		
		int id;
		float centerX;
		float centerY;
		float radius;
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<num ; i++) {
			id = sc.nextInt();
			centerX = sc.nextFloat();
			centerY = sc.nextFloat();
			radius = sc.nextFloat();
			
			cl.add(new Circle(id, centerX, centerY, radius));
		}
		return cl;
	}
}

class Circle {
	int id;
	float centerX;
	float centerY;
	float radius;
	
	public Circle(int id, float centerX, float centerY, float radius) {
		this.id = id;
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
	}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
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
}