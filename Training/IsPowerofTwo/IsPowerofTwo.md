#IsPowerofTwo

##효율적으로 2의 승수 체크하기.

2의 승수의 특징을 살펴보자면

00000001 = 1
00000010 = 2
00000100 = 4
00001000 = 8
00010000 = 16
00100000 = 32

2의 승수에서는 비트중 하나의 지수만 1을 가지고 있다.

이것을 잘이용하면

	bool IsPowerOfTwo(int value) {
		return ((value & (value - 1))==0) && (value != 0);
	}

00001000 (8) 
00000111 (7) 을 & 연산 처리하면

00000000 (0) 의 값을 도출할 수 있다. 

즉 ((value & (value - 1))==0) 가 만족하면 2의 승수인 것이다. [0은 예외 처리]

00000111 (7)
00000110 (6) &

00000110 (6) 으로 조건에 부합하지 않게 된다.