import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RecordMaker {
	final static int MAXEMPLOYEE = 6;
	final static int MAXSCORE = 101;
	
	public void start() {
		int inputCount = getUserInput();
		
		Map<String, Integer> employeeMap = makeEmployeeMap(inputCount);
		
		printEmployeeMap(employeeMap);
	}
	
	public void printEmployeeMap(Map<String, Integer> employeeMap) {
		Iterator<String> iterator = employeeMap.keySet().iterator();
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + " " + employeeMap.get(key));
		}
	}
	
	public Map<String, Integer> makeEmployeeMap(int count) {
		Map<String, Integer> employeeMap = new HashMap<>();
				
		while(true){
			String employeeNum = makeEmployeeNum();
			int employeeScore = makeEmployeeScore();
			
			employeeMap.put(employeeNum, employeeScore);
			
			if(employeeMap.size()==count)
				break;
		}
		
		return employeeMap;	
	}
	
	public String makeEmployeeNum() {
		StringBuilder employeeNum = new StringBuilder("NT00000");
		int random = (int)(Math.random() * MAXEMPLOYEE) + 1;
		
		StringBuilder randomBuffer = new StringBuilder(String.valueOf(random));
		
		employeeNum.replace(employeeNum.length() - (randomBuffer.length()), employeeNum.length(), String.valueOf(randomBuffer));
		
		return employeeNum.toString();
	}
	
	public int makeEmployeeScore() {
		int employeeScore=(int) (Math.random() * MAXSCORE);
		
		return employeeScore;
	}
	
	public int getUserInput() {	
		Scanner scan = new Scanner(System.in);
		
		System.out.print("input count : ");
		int count = scan.nextInt();
		
		if(count > MAXEMPLOYEE) {
			System.out.println("your input exceeded scope of input");
			System.exit(0);
		}
		
		return count;
	}
}
