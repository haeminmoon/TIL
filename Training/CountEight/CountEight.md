# CountEight

## 문제 

1~10000에서 8이 몇번 나오는지 갯수를 세는 문제. (88은 2번, 8808은 3번....)


## Issue

- 1~10을 10으로 나눈 나머지는 1,2,3,4,5,6,7,8,9,0 이다. 이 특성을 활용하여 if(temp % 10 == 8) 구문을 이용하여 갯수를 counting한다.
- while구문은 temp/=10으로 빠져나와야 함. 몫이 0이 될때 빠져나옴.
- 18의 경우 10으로 나누면 나머지는 8, 83의 경우 10으로 나누면 몫이 8이니까 한 번더 10으로 나누면 나머지는 8


	10000에서 8이 출현하는 갯수는 4000번임.