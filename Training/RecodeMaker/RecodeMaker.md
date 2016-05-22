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

- containskey를 사용해서 key 중복(사원번호)을 비교하면, makeEmployeeNum()을 더 수행해줘야 하기때문에 코드 로직이 더 길어지게됨. 그래서 set의 중복키를 허용하지 않는 점을 이용(내부적으로는 중복키가 존재할 시 update)해서 count에 대한 사원리스트가 같아질때까지 생성 루프를 돌게함.

- Employee 클래스는 향후 사원 정보들이 늘어날때 확장성을 위해 만들면 됨! 문제의 요구사항에 부합되는 최적효율을 위해서 Employee 클래스는 배제!

- 사원번호가 생성되는 방식이 더 다양해 질 수도 있기 때문에, interface를 적용(팩토리 메서드 패턴)하면 확장성을 고려할 수 있지 않을까...?? [나중에 한번 연습해보기!]