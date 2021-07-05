#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
typedef struct room* link;
typedef struct room{
	int t;
	int a;
	int h;
}room;
typedef struct man {
	int atk;
	int maxhp;
	int nowhp;
}man;
int main()
{
	int n, Hatk, i;
	man hero;
	link rooms = NULL;
	rooms = (link)malloc(sizeof(room) * n);
	scanf("%d %d", &n, &hero.atk);


	free(rooms);
}