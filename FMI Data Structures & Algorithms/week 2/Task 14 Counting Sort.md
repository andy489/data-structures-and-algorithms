## Counting Sort
Напишете алгоритъм, който сортира реални числа от интервала <img src="https://latex.codecogs.com/svg.latex?\Large&space;[2.00,4.00]"> с максимум две числа след десетичната запетая. Алгоритъма да е с времева сложност <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(N)">

```cpp
#include <iostream>
#include <vector>
using namespace std;
typedef vector<int> vi;
typedef vector<double> vd;
#define sz(x) ((int)x.size())
#define F(i,k,n) for(int i=k;i<n;i++)

void cs(vi& v)
{
	int N = v.size();
	int min(v[0]), max(v[0]);
	F(i, 0, N)
	{
		if (min > v[i]) min = v[i];
		if (max < v[i]) max = v[i];
	}
	int range = max - min + 1;
	vi count(range, 0);
	F(i, 0, N)
	{
		count[v[i] - min]++;
	}
	F(i, 0, range - 1)
	{
		count[i + 1] += count[i];
	}
	vi sorted(N);
	for (int i = N - 1; i >= 0;i--)
	{
		sorted[count[v[i] - min] - 1] = v[i];
		count[v[i] - min]--;
	}
	F(i, 0, N) v[i] = sorted[i];
	//F(i, 0, N) v[N - i - 1] = sorted[i];
}

int main()
{	// [2.00, 4.00]
	vd v = { 2.22, 3.12, 2.00, 2.65, 3.14, 3.40, 2.12, 4.00 };
	vi vec(v.size());
	F(i, 0, v.size())vec[i] = 100 * v[i];
	cs(vec);
	F(i, 0, v.size())v[i] = vec[i] / 100.0;
	cout.setf(ios::fixed);
	cout.precision(2);
	for (const auto& el : v) cout << el << ' ';
	return 0;
}
```
