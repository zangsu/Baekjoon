#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
typedef struct frac {
	long long son;
	long long mom;
}frac;
int main()
{
	int n, i;
	frac ans;
	int * num = NULL;
	scanf("%d", &n);
	num = (int*)malloc(sizeof(int) * n);
	for (i = 0; i < n; i++)
		scanf("%d", &num[i]);
	ans.mom = num[--i];
	ans.son = 1;
	for (--i; i >= 0; i--)
	{
		long long temp = ans.mom;
		ans.mom = ans.son + ans.mom * num[i];
		ans.son = temp;
	}
	free(num);
	printf("%lld %lld", ans.mom - ans.son, ans.mom);

}