#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
typedef long long ll;
typedef vector<ll> vll;
#define sz(x) ((ll)x.size())
#define F(i,k,n) for(ll i=k;i<n;i++)

long long max(ll a, ll b)
{
	return a > b ? a : b;
}

bool validatingAnswer(ll mid, const vll& huts, int K)
{
	int N = sz(huts);
	ll position = huts[0];

	int cows = 1;
	for (int i = 1; i < N; i++)
	{
		if (huts[i] - position >= mid)
		{
			position = huts[i];
			cows++;

			if (cows == K) return true;
		}
	}
	return false;
}

ll binSearchOnAnswer(const vll& huts, int K)
{
	int N = sz(huts);
	ll ans(-1);
	ll begin(huts[0]), end(huts[N - 1]);
	while (begin < end)
	{
		ll mid = (begin + end) / 2;
		if (validatingAnswer(mid, huts, K))
		{
			ans = max(ans, mid);
			begin = mid + 1;
		}
		else end = mid;
	}
	return ans;
}

int main()
{
	size_t N, K;
	cin >> N >> K;
	vll huts(N);
	F(i, 0, N) cin >> huts[i];
	sort(huts.begin(), huts.end());

	cout << binSearchOnAnswer(huts, K);

	return 0;
}
