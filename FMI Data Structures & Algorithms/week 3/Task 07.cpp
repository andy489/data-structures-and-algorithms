#include <iostream>
#include <vector>
using namespace std;
typedef long long ll;
typedef vector<ll> vll;
#define sz(x) ((ll)x.size())
#define F(i,k,n) for(ll i=k;i<n;i++)

int upper_bound(const vll& vec, ll l, ll r, ll target)
{
	while (l < r)
	{
		ll mid = (l + r) / 2;

		if (target > vec[mid]) l = mid + 1;

		else r = mid;
	}
	if (vec[l] >= target) return l;

	else return -1;
}

int main()
{
	ll n;
	cin >> n;
	vll strawberries(n);
	F(i, 0, n) cin >> strawberries[i];
	int m, k;
	cin >> m;
	vll tasty(m);
	F(i, 0, m) cin >> tasty[i];

	vll utility(n);
	utility[0] = strawberries[0];
	F(i, 1, n) utility[i] = strawberries[i] + utility[i - 1];

	//for (const auto& el : utility) cout << el << ' ';

	F(i, 0, m)
	{
		ll currStrawberry = tasty[i];
		ll indx = upper_bound(utility, 0, n - 1, tasty[i]);
		cout << indx + 1 << '\n';
	}

	return 0;
}
