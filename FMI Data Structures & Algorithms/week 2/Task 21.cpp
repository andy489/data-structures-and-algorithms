#include <iostream>
#include <algorithm>
using namespace std;

const int SIZE = 100001;

int n; // shoes
int q; // queries
int money;

//Shoe prices
int a[SIZE];

int prefixSum[SIZE];

void input() 
{
	cin >> n >> q;

	for (int i = 0; i < n; i++) 
	{
		cin >> a[i];
	}
}

int findLast(int num) 
{
	int res = -1;
	int r = num;
	int l = 0;

	// Find the first shoe we can not afford.
	// It will be at position "res".
	//
	// -1 [0 1 2...i i+1 i+2... j j+1 j+2... n-1]
	//  |          |  |------------|
	// in case     |        |      |
	// we can      | (our interval)|
	// buy all     |               |
	// the shoes.  |               |
	//            res             num
	//             |
	//      the first shoe we can't buy
	//      if the most expensive one is
	//      at positon num = j+1

	while (l <= r) 
	{
		int mid = (l + r) >> 1;

		// the money we need to pay for the shoes from
		// index "mid" to index "num"
		int intervalSum = prefixSum[num] - prefixSum[mid] + a[mid];

		// if we can't afford them we store the result
		// because the last time we can't afford the shoes
		// we will be one index off the needed position
		if (intervalSum > money) 
		{
			res = mid;
			l = mid + 1;
		}
		else {
			r = mid - 1;
		}
	}

	return num - res;
}

// find the most expensive shoe
// we are willing to buy
int findFirst(int num) 
{
	int l = 0, r = n - 1;

	while (l <= r) 
	{
		int mid = (l + r) >> 1;

		if (a[mid] <= num) 
		{
			l = mid + 1;
		}
		else 
		{
			r = mid - 1;
		}
	}

	return l - 1;
}

void solve() 
{
	sort(a, a + n);

	prefixSum[0] = a[0];
	for (int i = 1; i < n; i++) 
	{
		prefixSum[i] = prefixSum[i - 1] + a[i];
	}

	for (int i = 0; i < q; i++) {
		int maxMoney;
		cin >> money >> maxMoney;

		// the position of the most expensive shoe is the
		// upper bound of the interval we search in
		//                        |
		//              |-------------------|
		cout << findLast(findFirst(maxMoney)) << "\n";
	}
}

int main() 
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);

	input();
	solve();

	return 0;
}
