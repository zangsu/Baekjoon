#define CRT_SECURE_NO_WARNINGS	
#include <stdio.h>
#include <stdlib.h>

int main()
{
	int n, t, c, p;
	scanf("%d %d %d %d", &n, &t, &c, &p);
	printf("%d", ((n - 1) / t) * c * p);
}