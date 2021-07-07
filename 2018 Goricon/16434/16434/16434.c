#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
typedef struct room* link;
typedef struct room{
	int t;
	int a;
	int h;
	int roomMax;
	int Max;
	int heal;
}room;
typedef struct man {
	int atk;
	int maxhp;
	int nowhp;
}man;
int Rhp(int, int, int);
int main()
{
	int n, Hatk, i;
	man hero;
	link rooms = NULL;
	rooms = (link)malloc(sizeof(room) * n);
	scanf("%d %d", &n, &hero.atk);
	for (i = 0; i < n; i++)
	{
		scanf("%d %d %d", &rooms[i].t, &rooms[i].a, &rooms[i].h);
		if (rooms[i].t == 1)
		{
			rooms[i].roomMax = Rhp(rooms[i].h, rooms[i].a, hero.atk);
			if (!(i - 1))
				rooms[i].Max = rooms[i].roomMax;
			else
			{
				if (rooms[i - 1].t == 1)
				{
					rooms[i].Max = rooms[i].roomMax + rooms[i - 1].Max;
				}
			}
		}
		else
		{
			hero.atk += rooms[i].a;
		}
	}

	free(rooms);
}
int Rhp(int Mhp, int Matk, int Hatk)
{
	if (Mhp % Hatk == 0)
		return (((Mhp / Hatk) - 1) * Matk) + 1;
	else
		return ((Mhp / Hatk) * Matk) + 1;
}