#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#define SIZE 1000
char direc[4] = { 'L', 'U', 'R', 'D' };
int L, die = 0, sum = 1;
typedef struct node* Link;
typedef struct node {
	int dir;
	int x_axis;
	int y_axis;
	Link link;
}node;
Link move(Link);
node findnext(Link);
Link changedir(Link, char);
/*char changedir(char, node *);
int go(node *, int, int, int[][2*SIZE]);
int move(node* now, int[][2* SIZE]);*/
int main()//10875
{
	/*int N, a,i, time, sum = 1, grat[2*SIZE][2*SIZE] = { 0 };
	char direction;
	node now;
	now.x_axis = SIZE;
	now.y_axis = SIZE;
	now.dir = 'R';
	grat[SIZE][SIZE] = 1;
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
	printf("%d", sum);*/
	//배열을 이용한 해결 방법이 메모리 소모가 너무 커서 리스트로 변경
	int N, i, time, direction, j;
	Link trace = NULL;
	trace = (Link)malloc(sizeof(node));
	trace->dir = 2;
	trace->x_axis = 0;
	trace->y_axis = 0;
	trace->link = NULL;

	scanf("%d %d", &L, &N);
	for (i = 0; i < N; i++)
	{
		scanf("%d %c", &time, &direction);
		for (j = 0; j < time; j++)
		{
			if (die == 1)
				break;
			trace = move(trace);
		}
		if (die == 1)
			break;
		else
			trace = changedir(trace, direction);
	}
	printf("%d", sum);
}
Link move(Link trace)
{
	int i;
	node next = findnext(trace);
	Link now = trace;
	while (now->link != NULL)
	{
		if (next.x_axis == now->x_axis && next.y_axis == now->y_axis)
		{
			die = 1;
			return;
		}
		else if (next.x_axis > L || next.y_axis > L || next.x_axis < -L || next.y_axis < -L)
		{
			die = 1;
			return;
		}
		now = now->link;
	}
	now->link = &next;
	sum++;
	return trace;
}
node findnext(Link now)
{
	while (now->link != NULL)
		now = now->link;
	node next = *now;
	next.link = NULL;
	switch (now->dir)
	{
	case 1:
		next.y_axis++;
		break;
	case 3:
		next.y_axis--;
		break;
	case 2:
		next.x_axis++;
		break;
	case 0:
		next.x_axis--;
		break;
	}
	return next;
}
Link changedir(Link trace, char dir)
{
	Link now = trace;
	while (now->link != NULL)
		now = now->link;
	if (dir == 'L')
		now->dir = (now->dir + 3) % 4;
	else
		now->dir = (now->dir + 1) % 4;
	return trace;
}
//char changedir(char change, node * now)
//{
//	if (change == 'L')
//	{
//		switch (now->dir)
//		{
//		case 'U': now->dir = 'L';
//			break;
//		case 'L': now->dir = 'D';
//			break;
//		case 'D': now->dir = 'R';
//			break;
//		case 'R': now->dir = 'U';
//			break;
//		}
//	}
//	else
//	{
//		switch (now->dir)
//		{
//		case 'U': now->dir = 'R';
//			break;
//		case 'L': now->dir = 'U';
//			break;
//		case 'D': now->dir = 'L';
//			break;
//		case 'R': now->dir = 'D';
//			break;
//		}
//	}
//}
//int go(node * now, int time, int sum, int grat[][2*SIZE])
//{
//	int i;
//	for (i = 0; i < time; i++)
//	{
//		if (move(now, grat) < 0)
//		{
//			die = 1;
//			return sum;
//		}
//		else sum += 1;
//	}
//	return sum;
//}
//int move(node * now, int grat[][2*SIZE])
//{
//	switch (now->dir)
//	{
//	case 'U':
//		if (grat[now->y_axis-1][now->x_axis] == 1 || now->y_axis -1 < SIZE -L)
//			return -1;
//		else
//		{
//			grat[now->y_axis-1][now->x_axis] = 1;
//			now->y_axis -= 1;
//			return 1;
//		}
//	case 'L':
//		if (grat[now->y_axis][now->x_axis-1] == 1 || now->x_axis < SIZE -L)
//			return -1;
//		else
//		{			
//			grat[now->y_axis][now->x_axis-1] = 1;
//			now->x_axis -= 1;
//			return 1;
//		}
//	case 'D':
//		if (grat[now->y_axis + 1][now->x_axis] == 1 || now->y_axis + 1 > SIZE + L)
//			return -1;
//		else
//		{
//			grat[now->y_axis + 1][now->x_axis] = 1;
//			now->y_axis += 1;
//			return 1;
//		}
//	case 'R':
//		if (grat[now->y_axis][now->x_axis+1] == 1 || now->x_axis +1 > SIZE +L)
//			return -1;
//		else
//		{
//			grat[now->y_axis][now->x_axis+1] = 1;
//			now->x_axis += 1;
//			return 1;
//		}
//	}
//}
