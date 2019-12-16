#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<vector<int>> adj;
vector<int>visited;

vector<int> regions;

void dfs(int s, int& count)
{
	visited[s] = true;
	count++;
	for (const auto& child : adj[s])
	{
		if (!visited[child])
		{
			dfs(child, count);
		}
	}
}

int main()
{
	int q, V, E, c_road, c_lib, i, a, b, numCitiesInComp(0);
	long long ans1(0), ans2(0);
	cin >> q;
	while (q--)
	{
		cin >> V >> E >> c_lib >> c_road;

		adj.assign(V + 1, vector<int>());
		visited.assign(V + 1, 0);
		regions.clear();

		for (i = 0;i < E;++i)
		{
			cin >> a >> b;
			adj[a].push_back(b);
			adj[b].push_back(a);
		}

		for (i = 1; i <= V; ++i)
		{
			if (!visited[i])
			{
				dfs(i, numCitiesInComp);
				regions.push_back(numCitiesInComp);
				numCitiesInComp = 0;
			}
		}

		for (const auto& x : regions)
		{
			ans1 += c_lib + (x - 1) * c_road;
			ans2 += x * c_lib;
		}
		cout << min(ans1, ans2) << '\n';
		ans1 = 0;
		ans2 = 0;
	}
	return 0;
}
