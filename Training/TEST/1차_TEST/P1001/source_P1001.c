#include<stdio.h>
#include<math.h>
#define DEBUG 0

typedef struct ball{
	int x;
	int v;
	int r;
}st_ball;

typedef struct testcase{
	int time;
	st_ball leftBall;
	st_ball rightBall;
}st_testcase;

st_testcase st_testcases;

int checkCollision(st_testcase* testcase)
{
	int idx = 0;
	double distance = 0.0;
	double tmp = 0.0;
	int time_x1 = 0;
	int time_x2 = 0;
	
	// 충돌시 두 공의 원점 사이 거리 측정
	if(testcase->leftBall.r > testcase->rightBall.r)
	{
		tmp = (testcase->leftBall.r + testcase->rightBall.r) * (testcase->leftBall.r + testcase->rightBall.r) - (testcase->leftBall.r - testcase->rightBall.r) * (testcase->leftBall.r - testcase->rightBall.r);
		distance = sqrt(tmp);
	}
	else if(testcase->rightBall.r > testcase->leftBall.r)
	{
		tmp = (testcase->leftBall.r + testcase->rightBall.r) * (testcase->leftBall.r + testcase->rightBall.r) - (testcase->rightBall.r - testcase->leftBall.r) * (testcase->rightBall.r - testcase->leftBall.r);
		distance = sqrt(tmp);

	}
	else
	{
		distance = testcase->leftBall.r + testcase->rightBall.r;
	}

	time_x1 = testcase->leftBall.x + testcase->leftBall.v * testcase->time;
	time_x2 = testcase->rightBall.x - testcase->rightBall.v * testcase->time;

	if((time_x2 - time_x1) > distance)
	{
		return -1;
	}
	else if((time_x2 - time_x1) < distance)
	{
		return 1;
	}
	else 
	{
		return 0;
	}
	
}


int main(void)
{
	int iTestcase = 0;
	int testidx = 0;
	int idx = 0;
	double tmp = 0;

	scanf("%d", &iTestcase);

	if(iTestcase < 1 || iTestcase > 100)
	{
		return -1;
	}

	//테스트 케이스만큼 입력받음
	for(testidx = 0; testidx < iTestcase; testidx++)
	{
		scanf("%d %d %d", &st_testcases.leftBall.r, &st_testcases.leftBall.v, &st_testcases.leftBall.x);
		scanf("%d %d %d", &st_testcases.rightBall.r, &st_testcases.rightBall.v, &st_testcases.rightBall.x);
		scanf("%d", &st_testcases.time);
		
		
		switch(checkCollision(&st_testcases))
		{
			case 1:
				printf("Case #%d\nafter\n",testidx+1);
				break;
			case 0:
				printf("Case #%d\nboom\n",testidx+1);
				break;
			case -1:
				printf("Case #%d\nbefore\n",testidx+1);
				break;
		}
	}

	return 1;
}

