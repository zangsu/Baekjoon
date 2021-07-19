#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main() 
{
	int f, r, n, i;
	char* line = NULL;
	scanf("%d", &n);
	f = 0;
	r = n;
	line = (char*)malloc(sizeof(char) * n);
	getchar();
	for (i = 0; i < n; i++)
		scanf("%c", &line[i]);
	for (i = 0; i < n; i++)
	{
		if (line[i] == '?')
		{
			if (line[n - i-1] == '?')
			{
				line[i] = 'a';
				line[n - i-1] = 'a';
			}
			else
				line[i] = line[n - i-1];
		}
	}
	for (i = 0; i < n; i++)
		printf("%c", line[i]);
	free(line);
}