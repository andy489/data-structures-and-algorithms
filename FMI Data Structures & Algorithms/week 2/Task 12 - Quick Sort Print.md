## Визуализиране на сортиране с централна точка

Реализирайте *"бързо"* сортиране, което да изкарва *детайлна информация за колекцията от елементи след всяко разделяне* направено от алгоритъма спрямо избраната централна точка т.е. всеки път след избиране на пивотната/централна точка трябва да принтирате колекцията след като са се разпределили спрямо нея. За пивотна точка изберете *средата* на колекцията. (Рекурсивното обхождане се дефинира да е е от по-малък индекс към по-голям.)

## Входен формат

<img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> - големина на масив за сортиране <img src="https://latex.codecogs.com/svg.latex?\Large&space;x_1,x_2,...,x_N"> - елементите на масива

## Ограничения

<img src="https://latex.codecogs.com/svg.latex?\Large&space;0<N<100000"><br>
<img src="https://latex.codecogs.com/svg.latex?\Large&space;0<x_i<1000000">

## Изходен формат

Масива след подреждането му спрямо всеки избран пивот, като принтирате само числа с интервал след всяко едно (включително интервал след последното число!)

Примерен вход|Очакван изход
-|-
5<br>4 3 1 5 2|<img src="https://latex.codecogs.com/svg.latex?\Large&space;\square{1}"> 3 2 5 4<br>1 3 ***2*** 4 5<br>1 2 4 ***3*** 5<br>1 2 3 ***4*** 5

```cpp
#include <iostream>
#include <vector>
using namespace std;
typedef vector<int> vi;

int partition(vi& col, int start, int end)
{
	int pivIndx = (start + end+ 1) / 2 ;
	//int pivIndx = (start + end) / 2;
	swap(col[pivIndx], col[end]);
	int pivot = col[end];
	pivIndx = start;
	for (int i = start; i < end; i++)
	{
		if (col[i] < pivot)
		{
			swap(col[i], col[pivIndx++]);
		}
	}
	swap(col[pivIndx], col[end]);
	for (auto el : col) cout << el << ' ';
	std::cout << '\n';
	return pivIndx;
}

void quickSort(vi& col, int start, int end)
{
	if (start >= end) return;
	int pivot = partition(col, start, end);
	quickSort(col, start, pivot - 1);
	quickSort(col, pivot + 1, end);
}

int main()
{
	int N;cin >> N;
	vi col(N);
	for (int i = 0; i < N; i++) cin >> col[i];
	for (auto el : col) cout << el << ' ';
	cout << '\n';
	quickSort(col, 0, N - 1);
}
```
