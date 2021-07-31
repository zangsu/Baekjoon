#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
int main()
{
	int n, i = 0, l;
	float sum = 0;
	int* box = NULL;
	scanf("%d %d", &n, &l);
	box = (int*)malloc(sizeof(int) * n);
	for (i = 0; i < n; i++)
		scanf("%d", &box[i]);
	for (i = n - 1; i > 0; i--)
	{
		sum += box[i];
		if (sum / (n - i) >= box[i - 1] + l || sum / (n - i) <= box[i - 1] - l)
			break;
	}
	if (i == 0)
		printf("stable");
	else
		printf("unstable");
	free(box);
}//테스트케이스는 전부 통과

