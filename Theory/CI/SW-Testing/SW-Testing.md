# SW-Testing

## Testing과 Debugging의 차이

- Testing은 예방 차원이다. -> 결함을 발견하는데 초점
- Debugging은 테크니컬 레벨이다. -> 결함을 수정하는데 초점


## Testing이란

Testing은 개발자의 애티튜드와 연관되어 있다. 
	- 프로그램에 대한 애정도
	- 얼마나 결함 없이 잘 만드는지

Test는 인프라, 시스템, 사람과 직접적인 영향이 있다.


영향도 분석툴은 중요한 요소이다. (하나를 고치면 여러개를 고쳐야 하기 때문에...)

ㅋㅍ은 AB테스트로 수십개씩 릴리즈가 나타난다고함...?


##Testing의 SW Process

Testing을 횡적으로 놓고, 프로세스로 본다고 가정하면 크게 검증(Verification)과 확인(Validation)으로 나눌 수 있다.
이는 문서(정적 부분) 프로그래밍(동적 부분)으로 나눌 수 있다. (스태틱과 다이나믹)

		계획 -> 분석/설계 -> 구현/실행 -> 완료 평가/결과 -> 종료 활동