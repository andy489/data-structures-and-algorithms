## Binary Search iterative function O(log(N)) 
*Functions that return most left and most right indeces of searched element if exist, or -1 otherwise.*
```cpp
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
typedef vector<int> vi;
#define sz(x) ((int)x.size())

int bS_mostLeft(const vi& vec, int x)
{
	int begin(0), end(sz(vec) - 1), mid;

	int mostLeft(-1);

	while (begin <= end)
	{
		mid = begin + (end - begin) / 2;
		if (vec[mid] == x)
		{
			mostLeft = mid;
			end = mid - 1;
		}
		else if (vec[mid] > x)
		{
			end = mid - 1;
		}
		else
		{
			begin = mid + 1;
		}
	}
	return mostLeft;
}

int bS_mostRight(const vi& vec, int x)
{
	int begin(0), end(sz(vec) - 1), mid;

	int mostRight(-1);

	while (begin<=end)
	{
		mid = begin + (end - begin) / 2;
		if (vec[mid] == x)
		{
			mostRight = mid;
			begin = mid + 1;
		}
		else if (vec[mid] > x)
		{
			end = mid - 1;
		}
		else
		{
			begin = mid + 1;
		}
	}
	return mostRight;
}

int main()
{
	int searched;
	cin >> searched;
	vi vec = { 1,2,2,3,3,3,4,4,4,4,5,5,5,5,5,6,7,8,8,9 };
	int N = sz(vec);
	cout << "Most left position: " << bS_mostLeft(vec, searched)
		<< "\nMost right position: " << bS_mostRight(vec, searched);
	return 0;
}
```
## Binary Search recursive boolean function O(log(N))
```cpp
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
typedef vector<int> vi;
#define sz(x) ((int)x.size())

bool binarySearch(const vi& vec, int begin, int end, int x)
{
	if (begin <= end)
	{
		int mid = begin + (end - begin) / 2;

		if (vec[mid] == x)  return mid;

		if (vec[mid] > x) return binarySearch(vec, begin, mid - 1, x);

		return binarySearch(vec, mid + 1, end, x);
	}

	return false;
}

int main()
{
	int searched;
	cin >> searched;
	vi vec = { 1,2,2,3,3,3,4,4,4,4,5,5,5,5,5,6,7,8,8,9 };
	int N = sz(vec);
	binarySearch(vec, 0, N - 1, searched)?cout<<"exist\n":cout<<"not exist\n";

	return 0;
}
```
