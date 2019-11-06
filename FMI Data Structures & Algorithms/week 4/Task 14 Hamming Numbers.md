## Hamming Numbers

*Hamming* numbers are numbers of the form <img src="https://latex.codecogs.com/svg.latex?\Large&space;H=2^i\times{3^j}\times{5^k}">, where <img src="https://latex.codecogs.com/svg.latex?\Large&space;i,j,k\ge{0}">

*Hamming* numbers   are also known as *ugly* numbers and also *5-smooth numbers* (numbers whose prime divisors are less or equal to 5).

#### Task

Generate the sequence of *Hamming* numbers, in increasing order.

#### Solution
```cpp
#include <iostream>
#include <queue>
using namespace std;
typedef long long ll;

ll getMin(ll a, ll b)
{
	return a > b ? b : a;
}

ll getMin(ll a, ll b, ll c)
{
	return getMin(a, b) > c ? c : getMin(a, b);
}

int main()
{
	int N;
	cin >> N;

	queue<ll>two, three, five;

	if (N == 0) return 0;
	else if (N == 1)
	{
		cout << 1 << ' \n';
		return 0;
	}
	else
	{
		two.push(2);
		three.push(3);
		five.push(5);
		cout << 1 << ", ";
		ll prevHamming(1);
		while (N > 0)
		{
			ll hamming = getMin(two.front(), three.front(), five.front());
			if (hamming == two.front())	two.pop();
			else if (hamming == three.front()) three.pop();
			else five.pop();
			if (hamming != prevHamming)
			{
				cout << hamming << ", ";
				two.push(hamming * 2);
				three.push(hamming * 3);
				five.push(hamming * 5);
				prevHamming = hamming;
				N--;
			}
		}
	}

	return 0;
}
```
