#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
typedef struct node {
	char dir;
	int time;
}node;

int main()//10875
{
	int L,N, i;
	scanf("%d", &L);
	scanf("%d", &N);
	for (i = 0; i < N; i++)
	{
		node temp;
		scanf("%d %c", &temp.time, temp.dir);
	}
}