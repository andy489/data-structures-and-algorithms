## Задача 19. Принтери в офис

Офис на строителна фирма разполага с два принтера <img src="https://latex.codecogs.com/svg.latex?\Large&space;p1"> и <img src="https://latex.codecogs.com/svg.latex?\Large&space;p2">. <img src="https://latex.codecogs.com/svg.latex?\Large&space;p1"> принтира една архитектурна скица за <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> минути, а <img src="https://latex.codecogs.com/svg.latex?\Large&space;p2"> за <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> минути. По дадени <img src="https://latex.codecogs.com/svg.latex?\Large&space;N"> на брой скици да се изведе минималното време необходимо за принтирането на скиците в офиса.

#### Ограничения
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1<N\le{10^{18}}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1<l_1,l_2\le{1000}">

#### Решение
```cpp
#include <iostream>
#include <cmath>
using namespace std;
typedef unsigned long long ull;

ull max(ull l1, ull l2)
{
	return l1 > l2 ? l1 : l2;
}

ull func(int l1, int l2, ull t)
{	// return num of lists printed by both printers for time t
	return (ull)(floor(t / l1) + floor(t / l2));
}

int bS_on_answer(int l1, int l2, ull N)
{
START:
	ull left(0), right(N * max(l1, l2));

	ull ans(0);

	while (left <= right)
	{
		ull mid = left + (right - left) / 2;
		ull f = func(l1, l2, mid);

		if (f == N)
		{
			ans = mid;
			right = mid - 1;
		}
		else if (f < N)
		{
			left = mid + 1;
		}
		else
		{
			right = mid - 1;
		}
	}
	if (ans == 0)
	{
		N++;
		goto START;
	}
	else return ans;	
}

int main()
{
	int l1, l2;
	cout << "1st printer time for page: ";
	cin >> l1;
	cout << "2nd printer time for page: ";
	cin >> l2;
	cout << "Number of pages: ";
	ull N;
	cin >> N;

	cout << "Minimum time for printing " << N
		<< " lists is: " << bS_on_answer(l1, l2, N) << '\n';

	return 0;
}
```
