#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include <stdlib.h>
#include<string.h>>

int main()
{
	int n;
	char * fruit = NULL;
	scanf("%d", &n);
	fruit = (char*)malloc(sizeof(char) * n);
	scanf("%s", fruit);
	printf("%s", fruit);

}