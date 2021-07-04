#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
int findpage(int, int);
int finddig(int);
int difdig(int, int);
int pow(int, int);
int main()//10876 / 시간초과
{
	int i, T, A, B;

	scanf("%d", &T);
	for (i = 0; i < T; i++)
	{
		scanf("%d %d", &A, &B);
		printf("%d\n", findpage(A, B));
	}
}
int findpage(int A, int B)
{
	int dig_A = finddig(A), dig_B = finddig(B);
	if(dig_A == dig_B)
		return (B - A) + 1;
	else
	{
		if (A / pow(10,dig_A) < B / pow(10,dig_B))
		{
			int result = 1;
			while (dig_B > dig_A)
			{
				result += findpage(pow(10, dig_B - 1), B);
				dig_B--;
				B /= 10;
			}
			result += findpage(A, B);
			return result;
		}
		else
		{
			int result = 1;
			while (dig_A+1 < dig_B)
			{
				result += findpage(pow(10, dig_A), (A * pow(10, dig_A) - 1));
				dig_A++;
			}
			result += findpage(pow(10, dig_A), B);
			return result;
		}
	}
}
int finddig(int A)
{
	int i;

	for (i = 1; A >= 10; A /= 10)
		i++;
	return i;
}
int pow(int a, int b)
{
	if (b == 1)
		return a;
	else
		return a * pow(a, b - 1);
}