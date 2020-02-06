#include <iostream>
#include <vector>
#include <unordered_set>
#include <queue>
using namespace std;
#define MAXN 1000001

vector<unordered_set<int>>adj;
vector<int>dist;

void addEdge(int a, int b)
{
	adj[a].insert(b);
}

void runonce()
{
	int i, j;
	for (i = 0;i < MAXN;++i)
	{
		addEdge(i, i + 1);
		for (j = 2;j <= i && i * j < MAXN;++j)
		{
			addEdge(i,i*j);
		}
	}
}

void bfs(int start)
{
	queue<int>q;
	q.push(start);
	dist[start] = 0;
	while (!q.empty())
	{
		int cur = q.front();
		q.pop();
		for (const int& child : adj[cur])
		{
			if (dist[child] == -1)
			{
				dist[child] = dist[cur] + 1;
				q.push(child);
			}
		}
	}
}

int main()
{
	adj.resize(MAXN);
	dist.assign(MAXN,-1);
	runonce();
	bfs(0);
	int q,n;
	cin >> q;
	while (q--)
	{
		cin >> n;
		cout << dist[n] << '\n';
	}
	return 0;
}
