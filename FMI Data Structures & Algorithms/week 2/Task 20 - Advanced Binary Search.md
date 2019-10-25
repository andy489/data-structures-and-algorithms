Write a program, which finds the smallest element bigger than or equal to <img src="https://latex.codecogs.com/svg.latex?\Large&space;X"> in a sorted array of elements with time complexity <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(log(N))">. If there is no such element return an appropriate message.

```cpp
#include <iostream>
#include <vector>
#include <ctime>
#include <algorithm>
using namespace std;
typedef vector<int> vi;
#define sz(x) ((int)x.size())

int upper_bound(const vi& vec, int l, int r, int x)
{
	while (l < r)
	{
		int mid = (l + r) / 2;

		if (vec[mid] < x) l = mid + 1;

		else r = mid;
	}
	if (vec[l] >= x) return l;

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
	cout << "Enter element to search:\n";
	cin >> K;

	int indx = upper_bound(vec, 0, sz(vec)-1, K);

	cout << "Smallest element bigger than or equal to searched:\n";
	if (indx == -1) cout << "no such element\n";
	else cout << vec[indx] << '\n';

	return 0;
}

```
