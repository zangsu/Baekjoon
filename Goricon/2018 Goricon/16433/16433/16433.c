#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
int main()
{
	int n, r, c, check, i, j;
	scanf("%d %d %d", &n, &r, &c);
	check = (r + c) % 2;
	for (i = 0; i < n; i++)
	{
		for (j = 0; j < n; j++)
		{
			if ((i + j) % 2 == check)
				printf("v");
			else
				printf(".");
		}
		printf("\n");
	}

}