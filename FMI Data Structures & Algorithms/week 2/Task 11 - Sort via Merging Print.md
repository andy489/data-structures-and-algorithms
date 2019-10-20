## Визуализиране на сортиране, чрез сливане

Реализирайте сортиране чрез сливане, което да изкарва *детайлна информация за вътрешните сортировки* направени от алгоритъма т.е. всеки път след изпълнение на сливане на два масива принтирайте сортираният масив на стандартният изход. (Рекурсивното обхождане се дефинира да е е от по-малък индекс към по-голям.)

## Входен формат

<img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> - големина на масив за сортиране <img src="https://latex.codecogs.com/svg.latex?\Large&space;x_1,x_2,...,x_N"> - елементите на масива

## Ограничения

<img src="https://latex.codecogs.com/svg.latex?\Large&space;0<N<100000"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;0<x_i<1000000">

## Изходен формат

Всеки един сортиран подмасив, като принтирате само числа с интервал след всяко едно (включително интервал след последното число!)

Примерен вход|Очакван изход
-|-
4<br>1 5 2 4|1 5 1 5 2 4 2 4 1 2 4 5 

## Решение:

```cpp
#include<iostream>
#include <vector>
using namespace std;

void merge(vector<int>& col, vector<int>& L, vector<int>& R)
{
	size_t lCount(L.size()), rCount(R.size()), i(0), j(0), k(0);

	while (i < lCount && j < rCount)
	{
		if (L[i] < R[j]) col[k++] = L[i++];
		else col[k++] = R[j++];
	}
	while (i < lCount) col[k++] = L[i++];
	while (j < rCount) col[k++] = R[j++];
	for (auto el : col) cout << el << ' ';
}

void mergeSort(vector<int>& col)
{
	size_t n(col.size()), mid, i;
	if (n < 2)
	{
		cout << col[0] << ' ';
		return;
	}

	mid = (n + 1) / 2;
	//mid = n/2;

	vector<int>L(mid);
	vector<int>R(n - mid);

	for (i = 0;i < mid;i++) L[i] = col[i];
	for (i = mid;i < n;i++) R[i - mid] = col[i];

	mergeSort(L);
	mergeSort(R);
	merge(col, L, R);
}

int main()
{
	int N; cin >> N;
	vector<int> col(N);
	for (int i = 0; i < N; i++) cin >> col[i];
	mergeSort(col);
	//for (auto el : col)cout << el << ' ';
	return 0;
}
```

## За по-кратък запис може да направим следното

```cpp
#include<iostream>
#include <vector>
using namespace std;
#define FOR(k, n) for (int k = 0; k < n; k++)
typedef vector<int> vi;
void merge(vi& col, vi& L, vi& R)
{
	size_t lCount(L.size()), rCount(R.size()), i(0), j(0), k(0);
	while (i < lCount && j < rCount)
	{
		if (L[i] < R[j]) col[k++] = L[i++];
		else col[k++] = R[j++];
	}
	while (i < lCount) col[k++] = L[i++];	while (j < rCount) col[k++] = R[j++];
	for (auto el : col) cout << el << ' ';
}
void mergeSort(vi& col)
{
	size_t n(col.size()), mid, i;
	if (n < 2)
	{
		cout << col[0] << ' ';		return;
	}

	mid = (n + 1) / 2;	//mid = n/2;

	vi L(mid);	vi R(n - mid);

	FOR(i,mid) L[i] = col[i];	FOR(mid,n) R[i - mid] = col[i];

	mergeSort(L);	mergeSort(R);	merge(col, L, R);
}
int main()
{
	int N; cin >> N;	vi col(N);
	for (int i = 0; i < N; i++) cin >> col[i];
	mergeSort(col);
	//for (auto el : col)cout << el << ' ';
	return 0;
}
```
