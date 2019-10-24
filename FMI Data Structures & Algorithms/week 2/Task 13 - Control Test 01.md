### Задача

Подредете в намаляващ ред подаден масив. За тази задача не се позволява използването на вградени функции за сортиране.

#### Входен формат

<img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> - брой на елементите на масива <img src="https://latex.codecogs.com/svg.latex?\Large&space;X_1,X_2,...,X_N"> - елементите на масива разделени с интервал
#### Ограничения

<img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> - ще нараства във всеки тест, като ще стигне до <img src="https://latex.codecogs.com/svg.latex?\Large&space;10,000,000">

<img src="https://latex.codecogs.com/svg.latex?\Large&space;0<X_i<100,000">

#### Изходен формат

Сортираните елементи на масива в низходящ ред, разделени с интервал

Примерен тест|Очакван изход
10<br>9 2 6 8 9 9 8 0 3 9|9 9 9 9 8 8 6 3 2 0 

### Решение

```cpp
#include <iostream>
#include <vector>
using namespace std;
typedef vector<int> vi;
#define sz(x) ((int)x.size())
#define F(i,k,n) for(int i=k;i<n;i++)

void cs(vi& v)
{
	int N = sz(v);

	int range = 100000;
	vi count(range, 0);
	F(i, 0, N) count[v[i]]++;	
	F(i, 0, range - 1) count[i + 1] += count[i];
	vi sorted(N);
	for (int i = N - 1; i >= 0;i--)
	{
		sorted[count[v[i]] - 1] = v[i];
		count[v[i]]--;
	}
	F(i, 0, N) v[N - i - 1] = sorted[i];
}

int main()
{
	ios::sync_with_stdio(false);
	int N; cin >> N;
	vi col(N);
	F(i, 0, N) cin >> col[i];
	cs(col);
	for (const auto& el : col) cout << el << ' ';
	return 0;
}
```
