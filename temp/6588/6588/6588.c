#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include <stdlib.h>
void gold(int);
int main()
{
	int num;
	while (scanf("%d", &num))
	{
		if (num == 0)
			break;
		else
			gold(num);
	}
}
void gold(int a)
{
	int i, j;
	for (i = 3; i <= a / 2; i += 2)
	{
		int check = 0;
		for(j = 3; j<i && check == 0; j+= 2)
			if (i % j == 0)
				check = 1;
		for(j = 3; j<(a-i) && check == 0; j+= 2)
			if ((a - i) % j == 0)
				check = 1;
		if (check == 1)
			continue;
		else
		{
			printf("%d = %d + %d\n", a, i, a - i);
			return;
		}
	}
	printf("Goldbach's conjecture is wrong.");
}