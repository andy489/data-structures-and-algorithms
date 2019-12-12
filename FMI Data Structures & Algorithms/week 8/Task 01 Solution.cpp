#include <iostream>
#include <unordered_map>
#include <unordered_set>
#include <climits>
#include <algorithm>
using namespace std;

int visitComponent(int e,
	const unordered_map<int, unordered_set<int>>& adj,
	unordered_set<int>& visited)
{
	visited.insert(e);
	int to = 0;

	for (const auto& x : adj.find(e)->second)
	{
		if (visited.find(x) == visited.end())
			to += visitComponent(x, adj, visited);
	}
	return to + 1;
}

int main()
{
	unordered_map<int, unordered_set<int>> adj;
	unordered_set<int> visited;

	int n, a, b, mini(INT_MAX), maxi(INT_MIN);
	cin >> n;

	while (n--)
	{
		cin >> a >> b;
		adj[a].insert(b);
		adj[b].insert(a);
	}

	for (const auto& kvp : adj)
	{
		if (visited.find(kvp.first) == visited.end())
		{
			int v = visitComponent(kvp.first, adj, visited);
			mini = min(mini, v);
			maxi = max(maxi, v);
		}
	}
	cout << mini << ' ' << maxi << '\n';
	return 0;
}
