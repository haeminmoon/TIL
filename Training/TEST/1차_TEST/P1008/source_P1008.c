#include<stdio.h>
#include<string.h>

typedef struct testcase{
	int num[6];
}st_testcase;

st_testcase st_testcases;

int check(st_testcase* testcase)
{
	int sum = 0;
	int idx = 0;
	int iidx = 0;
	int iiidx = 0;
	int sum_check = 0;

	for(idx = 0; idx < 6; idx++)
	{
		sum_check += testcase->num[idx];
	}

	for(idx = 0; idx <6; idx++)
	{
		for(iidx=idx+1; iidx<6; iidx++)
		{
			for(iiidx=iidx+1; iiidx<6; iiidx++)
			{
				if((testcase->num[idx]+testcase->num[iidx]+testcase->num[iiidx])*2 > sum_check)
					sum++;
			}
		}
	}

	return sum;
}

int main(void)
{
	int iTestcase = 0;
	int testidx = 0;
	int idx = 0;
	double tmp = 0;

	scanf("%d", &iTestcase);


	//테스트 케이스만큼 입력받음
	for(testidx = 0; testidx < iTestcase; testidx++)
	{

		scanf("%d %d %d %d %d %d", &st_testcases.num[0], &st_testcases.num[1], &st_testcases.num[2], &st_testcases.num[3], &st_testcases.num[4], &st_testcases.num[5]);

		printf("Case #%d\n%d\n",testidx+1,check(&st_testcases));	
	}

	return 0;
}

