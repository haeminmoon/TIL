#include<stdio.h>
#include<string.h>
#include<math.h>

typedef struct balpan{
	int x;
	int y;
	double distance;
}st_balpan;

typedef struct testcase{
	int iJump;
	int iBalpanNumber;
	st_balpan st_balpans[20];
}st_testcase;

st_testcase st_testcases;

void swapBalpan(st_balpan* balpan1, st_balpan* balpan2)
{
	int tmp_x;
	int tmp_y;
	double tmp_distance;

	tmp_x = balpan1->x;
	balpan1->x = balpan2->x;
	balpan2->x = tmp_x;

	tmp_y = balpan1->y;
	balpan1->y = balpan2->y;
	balpan2->y = tmp_y;

	tmp_distance = balpan1->distance;
	balpan1->distance = balpan2->distance;
	balpan2->distance = tmp_distance;
}

int sortBalpan()
{
	int testidx =0;
	int idx = 0;
	int iidx = 0;

		for(idx = 0; idx < st_testcases.iBalpanNumber; idx++)
		{
			for(iidx = idx; iidx < st_testcases.iBalpanNumber; iidx++)
			{
				if(st_testcases.st_balpans[idx].distance < st_testcases.st_balpans[iidx].distance)
				{
					swapBalpan(&st_testcases.st_balpans[idx], &st_testcases.st_balpans[iidx]);
				}
			}
		}
	return 1;
}


int checkBalpan(st_balpan* balpan, int step )
{
	int idx = 0;
	double dBetween = 0.0;

	if(step <= 0)
		return 0;
	else if(step == 1 && balpan->distance <= st_testcases.iJump)
		return 1;
	
	for( idx = 0; idx < st_testcases.iBalpanNumber; idx ++)
	{
		dBetween = balpan->distance - st_testcases.st_balpans[idx].distance;
		if(dBetween < 0 || dBetween >step * st_testcases.iJump)
		{
			continue;
		}
		else
		{
			if(checkBalpan(&st_testcases.st_balpans[idx], step -1))
				return 1;
		}
	}
	
	return 0;
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
		scanf("%d %d", &st_testcases.iJump, &st_testcases.iBalpanNumber);

		for(idx = 0; idx < st_testcases.iBalpanNumber; idx++)
		{
			scanf("%d %d", &st_testcases.st_balpans[idx].x, &st_testcases.st_balpans[idx].y);
		}
	
		for(idx = 0; idx < st_testcases.iBalpanNumber; idx++)
		{
			tmp = st_testcases.st_balpans[idx].x*st_testcases.st_balpans[idx].x + st_testcases.st_balpans[idx].y*st_testcases.st_balpans[idx].y;
			st_testcases.st_balpans[idx].distance = sqrt(tmp);
		}

		sortBalpan();

		printf("Case #%d\n",testidx+1);
		for(idx = 0; idx <st_testcases.iBalpanNumber; idx++)
		{
			if(checkBalpan(&st_testcases.st_balpans[idx], 3))
			{
				printf("%d %d\n",st_testcases.st_balpans[idx].x, st_testcases.st_balpans[idx].y); 
				break;
			}
		
		}
		if(idx == st_testcases.iBalpanNumber )
			printf("0 0\n");
	}


	return 0;


}

