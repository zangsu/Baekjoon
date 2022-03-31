#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
void sort(int, int*);
int main()
{
	int num, len, i;
	int* fruit = NULL;
	scanf("%d %d", &num, &len);
	fruit = (int*)malloc(sizeof(int) * num);
	for (i = 0; i < num; i++)
		scanf("%d", &fruit[i]);
	sort(num, fruit);
	for (i = 0; i < num; i++)
		if (len + i < fruit[i])
			break;
	printf("%d", len + i);
	free(fruit);
}
void sort(int n, int* list)
{
	int i = 0, j;
	for (i = 0; i < n; i++)
	{
		int min = i, temp;
		for (j = i + 1; j < n; j++)
			if (list[j] < list[min])
				min = j;
		if (min == i)
			continue;
		else
		{
			temp = list[min];
			list[min] = list[i];
			list[i] = temp;
		}
	}
}