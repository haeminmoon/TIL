package Quiz;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import IO_Class.BufferedStream;
import Interface.IQuiz;

/*Check circles whether to intersect*/
public class Quiz_8 extends BufferedStream implements IQuiz{
	List<Object> resultList = new ArrayList<>();
	List<Object> inputList = getInputList();
	
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

	@Override
	public void solve() {
		int T = Integer.parseInt(inputList.get(0).toString());
		for(int i = 1;i<=T;i++)
		{
			String str = inputList.get(i).toString();
			int n = Integer.parseInt(str);
			//resultList.add(checkPowerOfTwo(n));
		}
		setOutput(resultList);
		
		int num = getUserInput();
		List<Circle> circleList = getInputCircle(num);

		printIntersectCircles(circleList);
	}

	@Override
	public List<Object> getInputList() {
		List<Object> arrayList = new ArrayList<>();
		String string=null;
		
		try {
			br = new BufferedReader(new FileReader("Quiz8/input.txt"));
			do
			{
				string = br.readLine();
				
				if(string != null) {
					arrayList.add(string);
				}
			}while(string != null);
		}
		catch (Exception e) {
			System.out.println(e);
			
		}
		finally {
			try {br.close();}
			catch (Exception e) {System.out.println(e);}
		}
		return arrayList;
	}

	@Override
	public void setOutput(List<Object> resultList) {
		try {
			int caseNum = 1;
			bw = new BufferedWriter(new FileWriter("Quiz8/output.txt"));
			
			for(Object o: resultList) {
				bw.write("Case #" + (caseNum++));
				bw.newLine();
				bw.write(o.toString());
				bw.newLine();
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {bw.close();}
			catch (Exception e) {System.out.println(e);}
		}
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