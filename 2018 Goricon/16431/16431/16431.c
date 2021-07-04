#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
typedef struct loc {
	int x;
	int y;
}loc;
int findb(loc, loc);
int finddif(int, int);
int findd(loc, loc);
int main()
{
	loc b, d, j;
	int btime, dtime;
	scanf("%d %d", &b.x, &b.y);
	scanf("%d %d", &d.x, &d.y);
	scanf("%d %d", &j.x, &j.y);
	btime = findb(b, j);
	dtime = findd(d, j);
	if (btime < dtime)
		printf("bessie");
	else if (btime == dtime)
		printf("tie");
	else
		printf("daisy");
}
int findd(loc d, loc j)
{
	return finddif(d.x, j.x) + finddif(d.y, j.y);
}
int findb(loc b, loc j)
{
	int difx = finddif(b.x, j.x);
	int dify = finddif(b.y, j.y);
	if (difx < dify)
		return dify;
	else
		return difx;
}
int finddif(int a, int b)
{
	int dif = a - b;
	if (dif < 0)
		return -dif;
	else
		return dif;
}