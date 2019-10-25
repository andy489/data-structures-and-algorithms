## Task 20. - Search Upper/Lower Bound
Write a program, which finds the smallest integer bigger than or equal to <img src="https://latex.codecogs.com/svg.latex?\Large&space;X"> in a sorted array of integers with time complexity <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(log(N))">. If there is no such element return an appropriate message.

#### Input
- serached integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;-10^{16}<X<=10^{16}">
#### Output
- upper bound (*if there exist such integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;X"> - return it, if not return the smallest integer bigger than <img src="https://latex.codecogs.com/svg.latex?\Large&space;X"> in the array, or an appropriate message if there is no such element*)

<img src="https://latex.codecogs.com/svg.latex?\Large&space;\underline{Do{\;}{\;}the{\;}{\;}same{\;}{\;}for{\;}{\;}lower{\;}{\;}bound}">

```cpp
#include <iostream>
#include <vector>
#include <ctime>
#include <algorithm>
using namespace std;
typedef vector<int> vi;
#define sz(x) ((int)x.size())

int upper_bound(const vi& vec, int l, int r, int target)
{
	while (l < r)
	{
		int mid = (l + r) / 2;

		if (target > vec[mid]) l = mid + 1;

		else r = mid;
	}
	if (vec[l] >= target) return l;

	else return -1;
}

int lower_bound(const vi& vec, int l, int r, int target)
{
	while (l < r)
	{
		int mid = (l + r + 1) / 2;

		if (target >= vec[mid]) l = mid;

		else r = mid-1;
	}
	if (vec[l] <= target) return l;

	else return -1;
}

int main()
{
	srand((size_t)time(0));

	vi vec = { 2,14,5,3,18,7,99,15,16,8,-10,67,55,45,-5,67,8,34,4,23,29,9,46,39,13,22 };

	sort(vec.begin(), vec.end(), less<int>());

	for (const auto& el : vec) cout << el << ' ';
	cout << '\n';

	int K;
	cout << "Enter integer to search:\n";
	cin >> K;

	int upper = upper_bound(vec, 0, sz(vec) - 1, K);
	int lower = lower_bound(vec, 0, sz(vec) - 1, K);

	cout << "Smallest integer bigger than or equal to searched:\n";
	if (upper == -1) cout << "no such element\n";
	else cout << vec[upper] << '\n';

	cout << "Biggest integer smaller than or equal to searched:\n";
	if (lower == -1) cout << "no such element\n";
	else cout << vec[lower] << '\n';

	return 0;
}
```
