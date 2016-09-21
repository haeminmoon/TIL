# RemoveString

## 문제

This is apple 이라는 문자열을 입력 받은 후, 제거할 문자열 is를 입력 받는다.

Th apple 문자열만 남게끔 해서 출력하라.

## Issue

문자열 유틸 메소드인 replace("This is apple", "is", " "); 이런식으로 구현해야함. 겹치는 메소드라면 공백으로 채운다.

- sol1은 StringBuilder의 indexOf와 SubString을 활용해서 풀었음
- sol2는 브루트 뽈스 방식으로 아무것도 사용하지 않고 품.

