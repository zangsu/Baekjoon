#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
int* findans(int, int**);
int main()
{
	int N, i, j, det = 0;
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
	//ans = findans(N, a);
	for (i = 0; i < N; i++)
		ans[i] = 0;
	while (det == 0)
	{
		int check = 1;
		for (i = 0; i < N-1; i++)
		{
			for (j = i + 1; j < N; j++)
			{
				if (a[i][ans[i]] == a[j][ans[j]])
				{
					check = 0;
					break;
				}
			}
			if (check == 0)
				break;
		}
		if (check == 1)
			det = 1;
	}
	free(a);
	if(det == 0)
		printf("-1");
	else
		for (i = 0; i < N; i++)
			printf("%d\n", a[i][ans[i]]);

}
//int* findans(int N, int** a)
//{
//	int i, j, k;
//	int* ans = NULL;
//	ans = malloc(sizeof(int) * N);
//	for (i = 0; i < N; i++)
//		ans[i] = 0;//i-1번째 원소가 i번째 날의 떡 위치
//	while()
//	//while (1)
//	//{
//	//	for (i = 0; i < N; i++)
//	//	{
//	//		int det = 0;
//	//		for (j = i + 1; j < N; j++)
//	//		{
//	//			if (a[i][ans[i]] == a[j][ans[j]])
//	//			{
//	//				det = 1;
//	//				break;
//	//			}
//	//		}
//	//		if (det == 0)
//	//		{
//	//			//한자리씩 올려야하는데 for문 써야할듯
//	//		}
//	//	}
//	//}
//
//	ans[0] = -1;
//	return ans;
//}
