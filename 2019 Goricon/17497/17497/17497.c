#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
int abs(int);
int main()
{
	long long n, x = 0;
	int k = 0, i;
	char op[99];

	scanf("%lld", &n);
	while (x != n && k <= 99)
	{
		if (x == 0)
		{
			x += 2;
			op[k] = '+';
			k++;
		}
		/*
		else if (x < n)
		{

		}
		if (x / 2 > n)
		{
			x /= 2;
			op[k] = '/';
			k++;
		}
		else if (x > n)
		{
			while (x != n && k <= 99)
			{
				x -= 2;
				op[k] = '-';
				k++;
			}
			break;
		}*/
		if (x < n)
		{
			if (abs(n - x * 2) < abs(n - x))
			{
				x *= 2;
				op[k] = '*';
				k++;
			}
			else
			{
				while (x != n && k <= 99)
				{
					x += 2;
					op[k] = '+';
					k++;
				}
				break;
			}
		}
		else
		{

		}
		if (k == -1)
			printf("-1");
		else
		{
			printf("%d\n", k);
			for (i = 0; i < k; i++)
				printf("[%c] ", op[i]);
		}
	}
}
int abs(int a)
{
	if (a >= 0)
		return a;
	else
		return -a;
}