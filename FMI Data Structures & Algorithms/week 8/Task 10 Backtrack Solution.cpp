#include <iostream>
#include <vector>
#include <list>
#include <unordered_map>
using namespace std;

vector<list<pair<int, int>>> G;
vector<bool> visited;

unordered_map<int, int> M;

int k;

void dfs(int v, int length, int cost) 
{
	if (length == k) 
	{
		M[cost]++;
		return;
	}

	visited[v] = true;

	for (const pair<int, int>& p : G[v]) 
	{
		int child = p.first;
		int weight = p.second;

		if (!visited[child]) 
		{
			dfs(child, length + 1, cost + weight);
		}
	}

	visited[v] = false;
}
int main() 
{
	int V, E, u, v, w, i;
	cin >> V >> E;

	G.resize(V);
	visited.resize(V);
	
	while (E--) 
	{
		cin >> u >> v >> w;
		G[u - 1].push_back({ v - 1, w });
	}

	cin >> k;

	for (i = 0; i < V; ++i) 
	{
		dfs(i, 0, 0);
	}

	int cost(-1), times(0);

	for (const pair<int, int>& kvp : M) 
	{
		int cur_cost = kvp.first;
		int cur_times = kvp.second;

		if (cur_times > times || (cur_times == times && cur_cost > cost)) 
		{
			cost = cur_cost;
			times = cur_times;
		}
	}

	cout << cost;

	return 0;
}
