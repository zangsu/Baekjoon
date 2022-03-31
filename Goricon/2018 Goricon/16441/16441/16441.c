#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
int n, m;
void Wolf(int, int, char**, int**);
int main()
{
	int i, j;
	char** map;
	int** safe;
	scanf("%d %d\n", &n, &m);
	map = (char**)malloc(sizeof(char*) * n);
	safe = (int**)malloc(sizeof(int*) * n);
	for (i = 0; i < n; i++)
	{
		safe[i] = (int*)malloc(sizeof(int) * 100);
		map[i] = (char*)malloc(sizeof(char) * 100);
	}
	/*for(i = 0; i<n; i++)
		for (j = 0; j < m; j++)
		{
			char temp;
			scanf("%c", &temp);
			if (temp == '\n')
			{
				j--; 
				continue;
			}
			map[i][j] = temp;
		}*/
	for (i = 0; i < n; i++)
	{
		scanf("%s", &map[i]);
	}

	for (i = 0; i < n; i++)
	{
		printf("%s", map[i]);
		printf("\n");
	}
	for(i = 0; i<n; i++)
		for (j = 0; j < m; j++)
		{
			if (map[i][j] != '#')
				safe[i][j] = 0;
			else
				safe[i][j] = 1;
		}
	for(i = 0; i<n ;i++)
		for (j = 0; j < m; j++)
			if (map[i][j] == 'W')
				Wolf(i, j, map, safe);
	/*for (i = 0; i < n; i++)
	{
		for (j = 0; j < m; j++)
		{
			if (safe[i][j] == 1)
				printf("P");
			else
				printf("%c", map[i][j]);
		}
		printf("\n");
	}*/

}
void Wolf(int i, int j, char map[][100], int safe[][100])
{
	if (i != 0)
	{
		if (map[i - 1][j] != '+')
			safe[i - 1][j] = 0;
		else
		{
			int a = i - 1;
			while (map[a][j] == '+')
				a = a--;
			Wolf(a, j, map, safe);
		}
	}
	if (i != n)
	{
		if (map[i + 1][j] != '+')
			safe[i + 1][j] = 0;
		else
		{
			int a = i + 1;
			while (map[a][j] == '+')
				a = a++;
			Wolf(a, j, map, safe);
		}
	}
	if (j != 0)
	{
		if (map[i][j-1] != '+')
			safe[i][j-1] = 0;
		else
		{
			int a = j - 1;
			while (map[i][a] == '+')
				a = a--;
			Wolf(i,a, map, safe);
		}
	}
	if (j != m)
	{
		if (map[i][j + 1] != '+')
			safe[i][j + 1] = 0;
		else
		{
			int a = j + 1;
			while (map[i][a] == '+')
				a = a++;
			Wolf(i, a, map, safe);
		}
	}
}