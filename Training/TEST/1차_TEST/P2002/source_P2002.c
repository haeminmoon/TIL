#include<stdio.h>
#include<string.h>

typedef struct testcase{
	char str1[20+1];
	char str2[20+1];
}st_testcase;

st_testcase st_testcases;

void sort(char* str, int len)
{
	int i = 0;
	int j = 0;
	char tmp;
	for(i = 0; i < len ; i++)
	{
		for(j = i; j < len; j++)
		{
			if(str[i] > str[j])
			{
				tmp = str[i];
				str[i] = str[j];
				str[j] = tmp;
			}
		}
	}
}

int check(st_testcase* testcase)
{
	int check = 0;
	int idx = 0;
	int str1_len = strlen(testcase->str1);
	int str2_len = strlen(testcase->str2);

	if(str1_len != str2_len)
		return 0;

	sort(testcase->str1, str1_len);
	sort(testcase->str2, str2_len);

	if(strcmp(testcase->str1, testcase->str2)==0)
		return 1;
	else
		return 0;
}

int main(void)
{
	int iTestcase = 0;
	int testidx = 0;
	int idx = 0;
	double tmp = 0;

	scanf("%d", &iTestcase);


	for(testidx = 0; testidx < iTestcase; testidx++)
	{
		memset(&st_testcases, 0x00, sizeof(st_testcases));
		
		scanf("%s", st_testcases.str1);
		scanf("%s", st_testcases.str2);

		printf("Case #%d\n",testidx+1);
		printf("%s\n",check(&st_testcases)?"true":"false");	

	}

	return 0;
}
