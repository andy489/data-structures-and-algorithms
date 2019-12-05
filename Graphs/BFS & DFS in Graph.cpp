#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class Graph
{
	vector<vector<int>> adj;
	int v, e;

	void dfsUtil(int u, vector<bool>& visited)
	{
		cout << u << ' ';
		visited[u] = true;
		size_t size(adj[u].size()), i;
		for (i = 0; i < size; ++i)
		{
			if (!visited[adj[u][i]])
			{
				dfsUtil(adj[u][i], visited);
			}
		}
	}

	void bfsUtil(int start, vector<bool>& visited)
	{
		int curr, i, level(1);
		queue<int> q;
		q.push(start);
		while (!q.empty())
		{
			int SIZE = (int)q.size();
			while (SIZE--)
			{
				curr = q.front(), q.pop();
				visited[curr] = true;
				//if (level == 2)
				cout << curr << ' ';
				for (i = 0; i < (int)adj[curr].size(); ++i)
				{
					if (!visited[adj[curr][i]])
					{
						q.push(adj[curr][i]);
						visited[adj[curr][i]] = true;
					}
				}
			}
			level++;
		}
	}

public:
	Graph(int v = 0) :v(v), e(0)
	{
		adj.resize(v + 1);
	}

	void addEdge(int u, int w)
	{
		adj[u].push_back(w);
		adj[w].push_back(u);
		e++;
	}

	void dfs(int start)
	{
		vector<bool>visited(v + 1, 0);
		dfsUtil(start, visited);
	}

	void bfs(int start)
	{
		vector<bool>visited(v + 1, 0);
		bfsUtil(start, visited);
	}
};

int main()
{
	int v, e, i, u, w;
	cin >> v >> e;

	Graph G(v);

	for (i = 0; i < e; ++i)
	{
		cin >> u >> w;
		G.addEdge(u, w);
	}
	cout << "Depth First Search:\n";
	G.dfs(1);
	cout << "\nBreadth First Search:\n";
	G.bfs(1);
	return 0;
}

/*
8 7
1 2
3 6
2 3
1 4
5 3
4 3
7 8
*/
