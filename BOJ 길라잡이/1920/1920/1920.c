#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main()//?
{
	int n, i, temp, a[100000] = { 0 };
	int * list = NULL;
	scanf("%d", &n);
	for (i = 0; i < n; i++)
	{
		scanf("%d", &temp);
		a[temp-1] = 1;
	}
	scanf("%d", &n);
	list = (int*)malloc(sizeof(int) * n);
	for (i = 0; i < n; i++)
		scanf("%d", &list[i]);
	for (i = 0; i < n; i++)
		printf("%d\n", a[list[i]-1]);
}