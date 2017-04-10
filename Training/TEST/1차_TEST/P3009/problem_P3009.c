#include <stdio.h>
#define DEBUG 0

char map[10][10];

typedef struct testcase{
	int size;
	char map[10+1][10+1];
}st_testcase;

st_testcase st_testcases;

int checkMap(st_testcase* testcase)
{
	int x_num = 0;
	int y_num = 0;
	int x_check = 0;
	int y_check = 0;
	int sensored = 0;
	int x_max = 0;
	int y_max = 0;
	int now_detect_cnt = 0;
	int max_detect_cnt = 0;
	int sensor_cnt = 0;

	while(1)
	{
		max_detect_cnt = 0;
		for( y_num =0; y_num < testcase->size; y_num ++)
		{
			for( x_num = 0; x_num < testcase->size; x_num++)
			{
				if(testcase->map[y_num][x_num] == '#' || testcase->map[y_num][x_num] == 'S')
				{
					continue;
				}
				else
				{
					sensored = 0;
					now_detect_cnt = 1;
					for(x_check = x_num, y_check = y_num; x_check >= 0&& y_check >=0 ; --x_check, --y_check)
					{
						if(testcase->map[y_check][x_check] == '0'){
							now_detect_cnt++;
							continue;
						}else if(testcase->map[y_check][x_check] == '#'){
							break;
						}else if(testcase->map[y_check][x_check] == 'S'){
							now_detect_cnt = 0;
							sensored = 1;
							break;
						}
					}

					if(sensored)
						continue;

					for(x_check = x_num, y_check = y_num; x_check < testcase->size && y_check < testcase->size ; ++x_check, ++y_check)
					{
						if(testcase->map[y_check][x_check] == '0'){
							now_detect_cnt++;
							continue;
						}else if(testcase->map[y_check][x_check] == '#'){
							break;
						}else if(testcase->map[y_check][x_check] == 'S'){
							now_detect_cnt = 0;
							sensored = 1;
							break;
						}
					}
					
					if(sensored)
						continue;
	
					for(x_check = x_num, y_check = y_num; x_check < testcase->size && y_check >= 0 ; ++x_check, --y_check)
					{
						if(testcase->map[y_check][x_check] == '0'){
							now_detect_cnt++;
							continue;
						}else if(testcase->map[y_check][x_check] == '#'){
							
							break;
						}else if(testcase->map[y_check][x_check] == 'S'){
							now_detect_cnt = 0;
							sensored = 1;
							break;
						}
					}
					
					if(sensored)
						continue;
	
					for(x_check = x_num, y_check = y_num; x_check >= 0 && y_check < testcase->size ; --x_check, ++y_check)
					{
						if(testcase->map[y_check][x_check] == '0'){
							now_detect_cnt++;
							continue;
						}else if(testcase->map[y_check][x_check] == '#'){
							
							break;
						}else if(testcase->map[y_check][x_check] == 'S'){
							now_detect_cnt = 0;
							sensored = 1;
							break;
						}
					}

					if(sensored)
						continue;

					if(now_detect_cnt > max_detect_cnt)
					{
						x_max = x_num;
						y_max = y_num;
						max_detect_cnt = now_detect_cnt;
					}

				}
			}
		}

		if(max_detect_cnt ==0)
		{
			break;
		}
		else
		{
			testcase->map[y_max][x_max] = 'S';
			sensor_cnt++;
		}
	}
	return sensor_cnt;
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
		scanf("%d", &st_testcases.size);

		for(idx = 0; idx < st_testcases.size; idx++)
		{
			scanf("%s", st_testcases.map[idx]);
		}
		printf("Case #%d\n",testidx+1);		
		printf("%d\n",checkMap(&st_testcases));	
/*		
		for(idx = 0; idx < st_testcases.size; idx++)
		{
			printf("%s\n", st_testcases.map[idx]);
		}
*/		
	}
	return 0;
}

