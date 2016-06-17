#Atoi

##atoi 함수 구현

	int atoi(char * cTarget)
	{
		int iChangeValue = 0;

		while(*cTarget != '\0' && (*cTarget >= '0' && *cTarget <= '9'))
		{
			// 현재 문자 변환시켜 기존에 있는 숫자에 더해준다.
			iChangeValue = (iChangeValue * 10) + ((int)*cTarget - (int)'0');  
			cTarget++;   // 다음 문자로 이동
		}
		return iChangeValue;
	}

위에서 ((int)*cTarget - (int)'0') 는 문자의 아스키 값을 숫자로 변환 했을때의 값을 계산하여
숫자로 치환 한것이다. 즉, *cTarget 값이 '1'이라면 '1'은 아스키 값이 49 이고 '0'은 아스키값이 48 이므로
49 -48을 하게되면 1이 반환된다.

(10 * iChangeValue) 이 부분은 기존 값을 한자리씩 앞으로  옮기는 역활을 담당한다.
즉, 현재 값이 2 이고 기존에 1이 있다면 (1 * 10) + 2 가 되므로 12를 반환하게된다.