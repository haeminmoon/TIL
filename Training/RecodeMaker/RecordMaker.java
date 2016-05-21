import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RecordMaker {
	final static int MAXEMPLOYEE = 99999;
	final static int MAXSCORE = 101;
	
	public void start() {
		int inputCount = getUserInput();
		Map<String, Integer> employeeMap = makeEmployeeMap(inputCount);
		printEmployeeMap(employeeMap);
	}
	
	public void printEmployeeMap(Map<String, Integer> employeeMap) {
		for(String key : employeeMap.keySet()) {
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
			System.out.println("최대 사원수 보다 입력값이 큽니다.");
			System.exit(0);
		}
		return count;
	}
}
