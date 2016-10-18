import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*Check circles whether to intersect*/
public class P0008 {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		List<List<Circle>> inputList = generateInputList(T);
		
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			StringBuilder resultBuilder = new StringBuilder();
			
			resultBuilder.append(getIntersectCircles(inputList.get(test_case-1)));

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(resultBuilder);
		}
	}
	
	public static List<List<Circle>> generateInputList(int T) {
		List<List<Circle>> list = new ArrayList<>();
		for(int i = 1; i <= T; i++) {
			Scanner scan = new Scanner(System.in);
			int n = scan.nextInt();
			List<Circle> circleList = getInputCircle(n);
			list.add(circleList);
		}
		return list;
	}

	public static int getUserInput() {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		return input;
	}

	public static String getIntersectCircles(List<Circle> cl) {
		StringBuilder strBuilder = new StringBuilder();
		
		Comparator<Circle> listSort = new Comparator<Circle>() {
			public int compare(Circle c1, Circle c2) {
				return c1.getId() < c2.getId() ? -1 : (c1.getId() == c2.getId() ? 0 : 1);
			}
		};
		
		Collections.sort(cl, listSort);
		
		for(int i=0; i<cl.size(); i++) {
			for(int j=i+1; j<cl.size(); j++) {
				Circle c1 = cl.get(i);
				Circle c2 = cl.get(j);
			
				if(c1.check(c1, c2))
					strBuilder.append(c1.id + " " + c2.id + "\n");
			}
		}
		return strBuilder.toString();
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