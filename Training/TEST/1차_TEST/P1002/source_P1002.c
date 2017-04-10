#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct testcase{
	char str1[100+1];
	char str2[101+1];
}st_testcase;

st_testcase st_testcases;

int check(st_testcase* testcase)
{
	int check = 0;
	int idx = 0;
	int stridx = 0;
	int strcnt = 0;
	int str1_len = strlen(testcase->str1);

	for(idx=0; idx <= str1_len; idx++)
	{

		if(stridx >= str1_len)
			return 0;
		
		if(idx==0)
		{
			testcase->str2[stridx] = testcase->str1[idx];
			stridx++;
			strcnt++;
		}
		else
		{
			if(testcase->str1[idx] == testcase->str1[idx-1])
			{
				strcnt++;
			}
			else
			{
				testcase->str2[stridx] = strcnt+48;
				stridx++;
				testcase->str2[stridx] = testcase->str1[idx];
				stridx++;
				strcnt = 1;
			}
		}
	}

	if(stridx >= str1_len)
		return 0;
	else
		return 1;
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
		
		scanf("%s", st_testcases.str1);
		printf("Case #%d\n%s\n",testidx+1, check(&st_testcases)?st_testcases.str2:st_testcases.str1);
	}

	return 0;
}

