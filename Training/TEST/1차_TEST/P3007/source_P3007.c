#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct testcase{
	char nums[6];
}st_testcase;

st_testcase st_testcases;

int getMax(st_testcase* testcase)
{
	int idx = 0;
	int iidx = 0;
	char tmp;
	for(idx = 0; idx < 5; idx ++)
	{
		for(iidx = 0; iidx < 5; iidx++)
		{
			if(testcase->nums[idx] < testcase->nums[iidx])
			{
				tmp = testcase->nums[idx];
				testcase->nums[idx] = testcase->nums[iidx];
				testcase->nums[iidx] = tmp;
			}
		}
	}

	return atoi(testcase->nums);
}

int getMin(st_testcase* testcase)
{
	int idx = 0;
	int iidx = 0;
	char tmp;
	for(idx = 0; idx < 5; idx ++)
	{
		for(iidx = 0; iidx < 5; iidx++)
		{
			if(testcase->nums[idx] > testcase->nums[iidx])
			{
				tmp = testcase->nums[idx];
				testcase->nums[idx] = testcase->nums[iidx];
				testcase->nums[iidx] = tmp;
			}
		}
	}

	return atoi(testcase->nums);
}

int check(st_testcase* testcase)
{
	return getMax(testcase) + getMin(testcase);
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
		//초기화
		memset(&st_testcases, 0x00, sizeof(st_testcases));

		scanf("%s", st_testcases.nums);
		printf("Case #%d\n%d\n",testidx+1,check(&st_testcases));	
	}
	return 0;
}

