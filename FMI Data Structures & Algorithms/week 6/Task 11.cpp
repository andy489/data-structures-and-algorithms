#include <list>
#include <unordered_map>
#include <unordered_set>

using namespace std;

class Graph
{
	unordered_map<int, list<int>> adj;
public:
	Graph() {}
	void addEdge(int v, int w)
	{
		adj[v].push_back(w);
		adj[w].push_back(v);
	}

	void bfs(int s)
	{
		unordered_set<int> visited;

		list<int> Q;
		visited.insert(s);
		Q.push_back(s);

		list<int>::iterator i;
		int level(0), sum(0);

		while (!Q.empty())
		{
			int SIZE = (int)Q.size();
			while (SIZE--)
			{
				s = Q.front(), Q.pop_front();
				sum += level;
				//if (level == 3) printf("%d ", s);;				
				for (i = adj[s].begin(); i != adj[s].end();++i)
				{
					if (visited.find(*i) == visited.end())
					{
						visited.insert(*i);
						Q.push_back(*i);
					}
				}
			}
			level++;
		}
		printf("%d", sum);
	}
};

int main()
{	
	Graph g;
	int n, i, a, b;
	scanf("%d", &n);
	for (i = 0; i < n; ++i)
	{
		scanf("%d %d", &a, &b);
		g.addEdge(a, b);
	}
	g.bfs(0);

	return 0;
}
