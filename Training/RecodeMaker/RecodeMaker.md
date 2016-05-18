# 사원번호와 성적을 출력하는 프로그램

## NTS

**설명 : "사원번호공백점수"형태로 count 개의 줄이 출력되어야 합니다.**

조건) 

- 사원번호에서 NT는 바뀔 수 없고, 뒤의 다섯 자리는 random 숫자. random 값이 99999 이하면 0으로 채움.(30이라면 NT00030)

- 사원번호 중복 안됨.

- score는 0점 이상 100점 미만. random.


	input : 3
	output : 
		NT00002 80
		NT11206 85
		NT01321 15


**issue**

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

- containskey를 사용해서 key 중복을 비교하면 시간효율이 안좋을것 같음 (set의 중복 제거) << count에 대한 사원리스트만 생성하면 되니까?
- Employee 클래스는 향후 사원 정보들이 늘어날때 확장성을 위해 만들면 됨! 문제의 요구사항에 부합되는 최적효율을 위해서 Employee 클래스는 배제!