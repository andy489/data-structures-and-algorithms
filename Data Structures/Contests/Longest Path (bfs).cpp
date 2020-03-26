// github.com/andy489

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int>c;
vector<vector<int>>adj;

int ans(0);

int bfs(int s) {
	int a[3]{ 0,0,0 };
	for (const auto& child : adj[s]) {
		a[0] = bfs(child);
		sort(a, a + 3);
	}
	if (c[s]) {
		ans = max(ans, 1 + a[1] + a[2]);
		return 1 + a[2];
	}
	else return 0;
}

int main() {
	int n, i, p;
	cin >> n;
	c.resize(n);
	adj.resize(n);
	for (i = 0;i < n;++i) {
		cin >> c[i];
	}
	for (i = 1;i < n;++i) {
		cin >> p;--p;
		adj[p].push_back(i);
	}

	bfs(0);
	cout << ans;
	return 0;
}
