#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main()//Á¤·Ä + Å½»ö < ÀüÃ¼ Å½»ö?
{
	int n, m, i, j;
	int* a = NULL;
	int* list = NULL;

	scanf("%d", &n);
	a = (int*)malloc(sizeof(int) * n);
	for (i = 0; i < n; i++)
		scanf("%d", &a[i]);
	scanf("%d", &m);
	list = (int*)malloc(sizeof(int) * m);
	for (i = 0; i < m; i++)
		scanf("%d", &list[i]);

	for (i = 0; i < m; i++)
	{
		for (j = 0; j < n; j++)
		{
			if (list[i] == a[j])
			{
				printf("1\n");
				break;
			}
		}
		if (j == n)
			printf("0\n");
	}

	free(a);
	free(list);
}