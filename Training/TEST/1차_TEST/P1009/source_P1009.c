#include<stdio.h>
#include<string.h>

#define DEBUG 0

char map[10][10];

typedef struct testcase{
	int size;
	char map[10][10];
}st_testcase;

st_testcase st_testcases;

int checkMap(st_testcase* testcase)
{
	int x_num = 0;
	int y_num = 0;
	int one = 0;
	int two = 0;
	int three =0;
	int sum =0;

	for( y_num =0; y_num < testcase->size; y_num ++)
	{
		for( x_num = 0; x_num < testcase->size; x_num++)
		{
			one = 0;
			two = 0;
			three = 0;
			switch(testcase->map[y_num][x_num])
			{
				case '1':
					if(y_num > 0)
					{
						if(testcase->map[y_num-1][x_num] == '2')
							two++;
						if(testcase->map[y_num-1][x_num] == '3')
							three++;
					}
					if(y_num < testcase->size -1)
					{
						if(testcase->map[y_num+1][x_num] == '2')
							two++;
						if(testcase->map[y_num+1][x_num] == '3')
							three++;
					}
					if(x_num >0)
					{
						if(testcase->map[y_num][x_num-1] == '2')
							two++;
						if(testcase->map[y_num][x_num-1] == '3')
							three++;
					}
					if(x_num < testcase->size -1)
					{
						if(testcase->map[y_num][x_num+1] == '2')
							two++;
						if(testcase->map[y_num][x_num+1] == '3')
							three++;
					}
					sum = sum + two*three;
					break;
				case '2':
					if(y_num > 0)
					{
						if(testcase->map[y_num-1][x_num] == '1')
							one++;
						if(testcase->map[y_num-1][x_num] == '3')
							three++;
					}
					if(y_num < testcase->size -1)
					{
						if(testcase->map[y_num+1][x_num] == '1')
							one++;
						if(testcase->map[y_num+1][x_num] == '3')
							three++;
					}
					if(x_num >0)
					{
						if(testcase->map[y_num][x_num-1] == '1')
							one++;
						if(testcase->map[y_num][x_num-1] == '3')
							three++;
					}
					if(x_num < testcase->size -1)
					{
						if(testcase->map[y_num][x_num+1] == '1')
							one++;
						if(testcase->map[y_num][x_num+1] == '3')
							three++;
					}
					sum = sum + one*three;
					break;
				case '3':
					if(y_num > 0)
					{
						if(testcase->map[y_num-1][x_num] == '1')
							one++;
						if(testcase->map[y_num-1][x_num] == '2')
							two++;
					}
					if(y_num < testcase->size -1)
					{
						if(testcase->map[y_num+1][x_num] == '1')
							one++;
						if(testcase->map[y_num+1][x_num] == '2')
							two++;
					}
					if(x_num >0)
					{
						if(testcase->map[y_num][x_num-1] == '1')
							one++;
						if(testcase->map[y_num][x_num-1] == '2')
							two++;
					}
					if(x_num < testcase->size -1)
					{
						if(testcase->map[y_num][x_num+1] == '1')
							one++;
						if(testcase->map[y_num][x_num+1] == '2')
							two++;
					}
					sum = sum + one*two;
					break;
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
		memset(&st_testcases, 0x00, sizeof(st_testcases));
		scanf("%d", &st_testcases.size);

		for(idx = 0; idx < st_testcases.size; idx++)
		{
			scanf("%s", st_testcases.map[idx]);
		}

		printf("Case #%d\n%d\n",testidx+1,checkMap(&st_testcases));	
	}

	return 0;
}

