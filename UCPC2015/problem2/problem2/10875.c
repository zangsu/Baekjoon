#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
int L, die = 0;
typedef struct node {
	char dir;
	int x_axis;
	int y_axis;
}node;
char changedir(char, node *);
int go(node *, int, int, int);
int move(node* now, int);
int main()//10875
{
	int N, a,i, time, sum = 1, grat[200][200] = { 0 };
	char direction;
	node now;
	now.x_axis = 100;
	now.y_axis = 100;
	now.dir = 'R';
	grat[100][100] = 1;
	scanf("%d", &L);
	scanf("%d", &N);
	for (i = 0; i < N; i++)
	{
		scanf("%d %c", &time, &direction);
		a = go(&now, time, sum, grat);
		sum = a;
		if (die == 1)
			break;
		changedir(direction, &now);
	}
	printf("%d", sum);
	
}
char changedir(char change, node * now)
{
	if (change == 'L')
	{
		switch (now->dir)
		{
		case 'U': now->dir = 'L';
			break;
		case 'L': now->dir = 'D';
			break;
		case 'D': now->dir = 'R';
			break;
		case 'R': now->dir = 'U';
			break;
		}
	}
	else
	{
		switch (now->dir)
		{
		case 'U': now->dir = 'R';
			break;
		case 'L': now->dir = 'U';
			break;
		case 'D': now->dir = 'L';
			break;
		case 'R': now->dir = 'D';
			break;
		}
	}
}
int go(node * now, int time, int sum, int grat[][200])
{
	int i;
	for (i = 0; i < time; i++)
	{
		if (move(now, grat) < 0)
		{
			die = 1;
			return sum;
		}
		else sum += 1;
	}
	return sum;
}
int move(node * now, int grat[][200])
{
	switch (now->dir)
	{
	case 'U':
		if (grat[now->y_axis-1][now->x_axis] == 1 || now->y_axis -1 < 100-L)
			return -1;
		else
		{
			grat[now->y_axis-1][now->x_axis] = 1;
			now->y_axis -= 1;
			return 1;
		}
	case 'L':
		if (grat[now->y_axis][now->x_axis-1] == 1 || now->x_axis < 100-L)
			return -1;
		else
		{			
			grat[now->y_axis][now->x_axis-1] = 1;
			now->x_axis -= 1;
			return 1;
		}
	case 'D':
		if (grat[now->y_axis + 1][now->x_axis] == 1 || now->y_axis + 1 > 100 + L)
			return -1;
		else
		{
			grat[now->y_axis + 1][now->x_axis] = 1;
			now->y_axis += 1;
			return 1;
		}
	case 'R':
		if (grat[now->y_axis][now->x_axis+1] == 1 || now->x_axis +1 > 100+L)
			return -1;
		else
		{
			grat[now->y_axis][now->x_axis+1] = 1;
			now->x_axis += 1;
			return 1;
		}
	}
}