#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
int* sort(int*, int, int);
void temp();

int main()//���� + Ž�� < ��ü Ž��?
{
	temp();
	// int n, m, i, j;
	// int * a = NULL;
	// int * list = NULL;

	// scanf("%d", &n);
	// a = (int *)malloc(sizeof(int) * n);
	// for(i = 0; i<n; i++)
	// 	scanf("%d", &a[i]);
	// scanf("%d", &m);
	// list = (int *)malloc(sizeof(int)*m);
	// for(i = 0; i<m; i++)
	// 	scanf("%d", &list[i]);

	// a = sort(a, 0, n);


	// free(a);
	// free(list);
}
// int * sort(int * a, int front, int end)
// {
// 	int pivot = front;
// 	int head = front+1, tail = end;
// 	while(head < tail)
// 	{
// 		while(a[head] < a[pivot])
// 			head++;
// 		while(a[tail] > a[pivot])
// 			tail--;
// 		int temp = a[head];
// 		a[head] = a[tail];
// 		a[tail] = temp;
// 	}
// 	int temp = a[pivot];
// 	a[tail] = a[pivot];
// 	a[pivot] = temp;

// 	if(front ~~)
// 		a = sort(a);
// 	if(end ~~)
// 		a = sort(a);

// 	return a;

// }

void temp()
{
	int n, i, temp, a[100000] = { 0 };
	int* list = NULL;
	scanf("%d", &n);
	for (i = 0; i < n; i++)
	{
		scanf("%d", &temp);
		a[temp] = 1;
	}
	scanf("%d", &n);
	list = (int*)malloc(sizeof(int) * n);
	for (i = 0; i < n; i++)
		scanf("%d", &list[i]);
	for (i = 0; i < n; i++)
		printf("%d", a[list[i]]);
}