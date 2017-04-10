#include<stdio.h>
#include<string.h>

#define DEBUG 0

typedef struct testcase{
	char master[11];
	char newbie[101];
}st_testcase;

st_testcase st_testcases;

int check(st_testcase* testcase)
{
	int sum = 0;
	int master_len = strlen(testcase->master);
	int newbie_len = strlen(testcase->newbie);
	int idx = 0;
	int iidx = 0;
	int failcheck = 0;

	for(idx = 0; idx < newbie_len; idx = idx + master_len)
	{
		failcheck = 0;

		for(iidx = 0; iidx < master_len; iidx++)
		{
			if(testcase->master[iidx] == 'B' && testcase->newbie[idx+iidx] == 'S')
			{
				failcheck = 1;
				break;
			}
		}
		
		if(!failcheck)
			sum++;	
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
		//초기화
		memset(&st_testcases, 0x00, sizeof(st_testcases));
		scanf("%s", st_testcases.master);
		scanf("%s", st_testcases.newbie);
		printf("Case #%d\n",testidx+1);	
		printf("%d\n",check(&st_testcases));	
	}

	return 0;
}

