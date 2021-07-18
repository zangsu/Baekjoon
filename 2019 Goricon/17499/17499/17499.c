#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main()
{
	int n, q, i, head = 0, num;
	int* seq = NULL;
	scanf("%d %d", &n, &q);
	seq = (int*)malloc(sizeof(int) * n);
	for (i = 0; i < n; i++)
		scanf("%d", &seq[i]);
	for (i = 0; i <q; i++)
	{
		int temp;
		scanf("%d", &temp);
		switch (temp)
		{
		case 1:
			scanf("%d %d", &temp, &num);
			seq[(head + temp-1) % n] += num;
			break;
		case 2:
			scanf("%d", &num);
			head = (head + n - num)%n;
			break;
		case 3:
			scanf("%d", &num);
			head = (head + num) % n;
			break;
		}		
	}
	for (i = 0; i < n; i++)
		printf("%d ", seq[(head + i) % n]);
	free(seq);
}