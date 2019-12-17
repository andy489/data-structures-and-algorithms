#include <iostream>
#include <vector>
#include <queue>
#include <set>
using namespace std;

vector<set<int>> adj;
queue<int> Q;
vector<int> mark;

int main()
{
	int V, E, a, b, i, ans(0);

	cin >> V >> E;

	adj.assign(V + 1, set<int>());
	mark.assign(V + 1, 0);

	for (i = 0;i < E;++i)
	{
		cin >> a >> b;
		adj[a].insert(b);
		adj[b].insert(a);
	}

	for (i = 1;i <= V;++i)
	{
		if (adj[i].size() < 2)
		{
			Q.push(i);
		}
	}

	while (!Q.empty())
	{
		a = Q.front(); Q.pop();

		if (adj[a].size() < 1) continue;

		b = *adj[a].begin();
		adj[b].erase(a);
		if (adj[b].size() < 2)
		{
			Q.push(b);
		}

		if (mark[a])
		{
			++ans;
		}
		else mark[b] ^= 1;
	}

	cout << ans << '\n';

	return 0;
}
