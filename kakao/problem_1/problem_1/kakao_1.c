#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>

int main()//No. 15953
{
	int prize17[6] = { 500, 300, 200, 50, 30, 10 };
	int man17[6] = { 1, 2, 3, 4, 5, 6 };
	int prize18[5] = { 512, 256, 128, 64, 32 };
	int man18[5] = { 1, 2,4, 8, 16 };
	int max17 = 21, max18 = 31;
	int T, a, b, pa, pb, i, j, prize[1000] = { -1 };


	scanf("%d", &T);
	for (i = 0; i < T; i++)
	{
		scanf("%d %d", &a, &b);
		if (a > max17 || a == 0)
			pa = 0;
		else
		{
			j = 0;
			while (a > 0)
				a -= man17[j++];
			pa = prize17[j - 1];
		}
		if (b > max18 || b == 0)
			pb = 0;
		else
		{
			j = 0;
			while (b > 0)
				b -= man18[j++];
			pb = prize18[j - 1];
		}
		prize[i] = (pa + pb) * 10000;
	}

	for (i = 0; i < T; i++)
	{

		printf("%d", prize[i]);
		if (prize[i + 1] >= 0)
			printf("\n");
	}
}