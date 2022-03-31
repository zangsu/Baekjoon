#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
typedef struct room* link;
typedef struct room{
	int t;
	int a;
	int h;
	int lose;
}room;
typedef struct man {
	int atk;
	int maxhp;
	int nowhp;
}man;
int Lhp(int, int, int);
int main()
{
	int n=0, i, rm, cnt = 0, sum = 1;
	//int* req=NULL;
	man hero;
	link rooms = NULL;
	scanf("%d %d", &n, &hero.atk);
	rooms = (link)malloc(sizeof(room) * n);
	//req = (int*)malloc(sizeof(int) * n);
	//if (rooms == NULL || req == NULL)
		//return 0;
	/*for (i = 0; i < n; i++)
		req[i] = 0;*/
	for (i = 0; i < n; i++)
	{
		scanf("%d %d %d", &rooms[i].t, &rooms[i].a, &rooms[i].h);
		//if(i == 0)
		//	rm = rooms[0].t;
		//if (rooms[i].t == 1)//몬스터가 있는 방
		//{
		//	rooms[i].lose = Lhp(rooms[i].h, rooms[i].a, hero.atk);
		//}
		//else//포션이 있는방
		//{
		//	hero.atk += rooms[i].a;
		//	rooms[i].lose = (-1) * rooms[i].h;
		//}
		//if (rooms[i].t != rm)//연속된 포션방, 몬스터방을 하나로 합침
		//{
		//	if (rm == 1)
		//		rm = 2;
		//	else
		//		rm = 1;
		//	cnt++;
		//}
		//req[cnt] += rooms[i].lose;
	}
	/*for (i = 0; i < cnt; i++)
	{
		if (req[i] < 0)
		{
			if (req[i] * (-1) > req[i + 1])
			{
				i++;
				break;
			}
			else
			{
				sum += (req[i] + req[i + 1]);
				i++;
				break;
			}
		}
		sum += req[i];
	}
	free(rooms);
	free(req);
	printf("%d", sum);*/
}
int Lhp(int Mhp, int Matk, int Hatk)//각 방에서 잃는 체력
{
	if (Mhp % Hatk == 0)
		return (((Mhp / Hatk) - 1) * Matk);
	else
		return ((Mhp / Hatk) * Matk);
}