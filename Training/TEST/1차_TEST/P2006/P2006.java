import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*Check circles whether to intersect*/
public class P2006 {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		List<List<Circle>> inputList = generateInputList(T, sc);
		
		for(test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			StringBuilder resultBuilder = new StringBuilder();
			
			resultBuilder.append(getIntersectCircles(inputList.get(test_case-1)));

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(resultBuilder);
			
		}
	}
	
	public static List<List<Circle>> generateInputList(int T, Scanner sc) {
		List<List<Circle>> list = new ArrayList<>();
		for(int i = 1; i <= T; i++) {
			int n = sc.nextInt();
			List<Circle> circleList = getInputCircle(n, sc);
			list.add(circleList);
		}
		return list;
	}

	public static String getIntersectCircles(List<Circle> cl) {
		StringBuilder strBuilder = new StringBuilder();
		Set<Integer> set = new HashSet<>();
		
		for(int i=0; i<cl.size(); i++) {
			for(int j=i+1; j<cl.size(); j++) {
				Circle c1 = cl.get(i);
				Circle c2 = cl.get(j);
			
				if(c1.check(c1, c2)) {
					set.add(c1.getId());
					set.add(c2.getId());
				}
					
			}
		}
		strBuilder.append(set.size());
		return strBuilder.toString();
	}
	
	public static List<Circle> getInputCircle(int num, Scanner sc) {
		List<Circle> cl = new ArrayList<>();
		
		int id=0;
		float centerX;
		float centerY;
		float radius;
				
		for(int i=0; i<num ; i++) {
			centerX = sc.nextFloat();
			centerY = sc.nextFloat();
			radius = sc.nextFloat();
			
			cl.add(new Circle(id++, centerX, centerY, radius));
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