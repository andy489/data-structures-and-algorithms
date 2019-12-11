#include <iostream>
#include <vector>
#include <cmath>
using namespace std;
typedef long long ll;
typedef vector<ll> vll;
#define F(i,k,n) for(ll i=k;i<n;++i)

struct Day
{
	ll baloon;
	ll bonbon;
	ll toMin;
	Day(ll baloon = 0, ll bonbon = 0) :baloon(baloon), bonbon(bonbon)
	{
		toMin = baloon * bonbon;
	};
};

bool validate(const vector<Day>& D, ll mid, ll M, ll N)
{
	F(i, 0, N)
	{
		if (D[i].toMin > mid)
		{
			M -= ceil((D[i].toMin - mid + D[i].bonbon - 1) / D[i].bonbon);
			if (M < 0) return false;
		}
	}
	return true;
}

ll search(const vector<Day>& D, ll l, ll r, ll M, ll N)
{
	while (l <= r)
	{
		ll mid = l + (r - l) / 2;
		if (validate(D, mid, M, N))    r = mid - 1;
		else l = mid + 1;
	}
	return l;
}

int main()
{
	ll N, M;
	cin >> N >> M;

	vll A(N);
	vll B(N);

	F(i, 0, N) cin >> A[i];
	F(i, 0, N) cin >> B[i];

	vector<Day> D;
	D.reserve(N);

	ll minBound(0), maxBound(0);

	F(i, 0, N)
	{
		D.emplace_back(A[i], B[i]);
		if (D[i].toMin > maxBound) maxBound = D[i].toMin;
	}

	cout << search(D, minBound, maxBound, M, N);

	return 0;
}
