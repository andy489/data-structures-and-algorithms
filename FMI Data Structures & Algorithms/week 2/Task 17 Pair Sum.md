## Task 17.
Дадени са два масива <img src="https://latex.codecogs.com/svg.latex?\Large&space;a"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;b"> с дължини съответно <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;M">. Да се намерят по колко начина може да се образува сумата <img src="https://latex.codecogs.com/svg.latex?\Large&space;S"> като сбор от два елемента по един от всеки масив: <img src="https://latex.codecogs.com/svg.latex?\Large&space;S=a_i+b_j">.

#### Ограничения
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;N,M\le{10^6}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{S}<10^5">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{a_i,b_j}\le{10^6},i=\overline{0,N},j=\overline{0,M}">

Примерен вход|Oчакван изход
-|-
3<br>3 1 5<br>3<br>2 4 6<br>7|3
9<br>2 4 9 6 7 14 5 5 189284<br>8<br>334 15 6 4 2 1 89 100000<br>19|3

#### Solution 
```cpp
#include <iostream>
#include <vector>
using namespace std;
typedef vector<int> vi;
#define sz(x) ((int)x.size())

unsigned count_pairs(const vi& a, const vi& b, int sum)
{
	unsigned answer(0);

	const int max = 1000000;
	const int min = 0;
	const int range = max - min;
	vi buffer_b(range, 0);

	for (const auto& el : b)
	{
		buffer_b[el]++;
	}

	for (const auto& el : a)
	{
		if (sum - el >= 0 && buffer_b[sum - el] > 0)
		{
			answer += buffer_b[sum - el];
		}
	}
	return answer;
}

int main()
{
	int N, M;
	cin >> N;
	vi a (N);
	for (int i = 0; i < N; i++)	cin >> a[i];

	cin >> M;
	vi b(M);
	for (int i = 0; i < M; i++)	cin >> b[i];
	
	int sum;
	cin >> sum;

	std::cout << count_pairs(a, b, sum) << '\n';

	return 0;
}
```
