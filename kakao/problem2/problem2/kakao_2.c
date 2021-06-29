#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
float stddev(int, int*);
float getvari(int, int, int*, float);
float pow(float, int);
int main() //15954 ÀÎÇü
{
	int N, K, i, min;
	float dev, vari;
	int num[500] = { -1 };
	scanf("%d %d", &N, &K);
	for (i = 0; i < N; i++)
		scanf("%d", &num[i]);
	dev = stddev(N, num);

	min = getvari(0, K, num, dev);

	for (i = 0; i < N - K; i++)
	{
		vari = getvari(i, K, num, dev);
		if (vari < min)
			min = vari;
	}
	printf("%lf", min);
}
float stddev(int max, int* num)
{
	int sum = 0, i = 0;
	while (num[i] >= 0)
		sum += num[i++];
	return sum / max;
}
float getvari(int start, int max, int* num, float dev)
{
	float sum = 0;
	for (int i = start; i < max; i++)
		sum += pow(num[i++] - dev, 2);

	return sum / max;
}
float pow(float a, int b)
{
	float c = a;
	for (int i = 0; i < b; i++)
		c *= a;
	return c;
}