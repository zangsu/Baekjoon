#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
int* findans(int, int**);
int main()
{
	int N, i, j;
	int** a = NULL;
	int* ans = NULL;
	scanf("%d", &N);
	a = malloc(sizeof(int) * N);
	ans = malloc(sizeof(int) * N);
	for (i = 0; i < N; i++)
	{
		int temp;
		scanf("%d", &temp);
		a[i] = malloc(sizeof(int) * temp+1);
		a[i][0] = temp;
		for (j = 0; j < temp; j++)
			scanf("%d", &a[i][j+1]);
	}
	ans = findans(N, a);
	free(a);
	if (ans[0] == -1)
		printf("-1");
	else
		for (i = 0; i < N; i++)
			printf("%d\n", a[i][ans[i]]);

}
int* findans(int N, int** a)
{
	int i, j, k;
	int* ans = NULL;
	ans = malloc(sizeof(int) * N);
	for (i = 0; i < N; i++)
		ans[i] = 0;
	while (1)
	{
		/*
		ans���� �� ���� ���° ������ ����
ans�� �����ϱ�

000�� �ȵǸ�
001
002
010
011
012
100
101
102


012->100���� �Ѿ�°�
2�� �� �ѱ� ���� ������ 2�� �ٽ� 0, 
1�� �� �ѱ� ���� ������ 1�� �ٽ� 0. 
0�� 1��.*/
		for (i = 0; i < N; i++)
		{
			for(j = i; j<N; j++)
				if(a[])
		}
	}
	ans[0] = -1;
	return ans;
}
