# ConvertDecimal

## 문제

n이라는 10진수를 입력했을 때, 2진수, 8진수, 16진수로 각각 출력하라.

ex) 233
	Convert Binary n : 11101001(2)
	Convert Octal n : 351(8)
	Convert Hexa n : E9(16)


## Issue

-나눗셈으로 와일 루프를 끝내야 함
-나머지를 구해서 각각 convertedDec에 추가해야함.
-마지막 몫을 루프가 끝난 뒤 추가해야함.

* 16진수의 경우 맵핑 테이블을 만들어 구현함.
* Why use Interface? 
 - 여러 기능들이 추가 될 수 있음. 
 	- 변환한 진법을 다시 십진법으로, 2진법을 8진법으로