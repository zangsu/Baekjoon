#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>

int main()
{
	int N, i, j, stu[100] = {0 };
	scanf("%d", &N);
	for (i = 0; i < N; i++)
	{
		for (j = 0; j < 10; j++)
		{
			int temp;
			scanf("%d", &temp);
			if (temp != j % 5 + 1)
				stu[i] = 1;
		}
	}

	for (i = 0; i < N; i++)
		if (stu[i] == 0)
			printf("%d\n", i+1);
}