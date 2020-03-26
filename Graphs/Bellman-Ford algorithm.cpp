// github.com/andy489

#include <iostream>
#include <vector>
#include <queue>
using namespace std;
#define INF 100000

struct Edge{
	int u, v, w;
};

void bel(const vector<Edge>& adj, int n, int s){
	vector<int> paths(adj.size(), INF);
	paths[s] = 0;
	bool updated = false;;

	int i, j;

	for (i = 0; i < n; ++i)	{
		updated = false;
		for (j = 0; j < (int)adj.size(); ++j) {
			if (paths[adj[j].u] != INF && paths[adj[j].u] + adj[j].w < paths[adj[j].v]) {
				paths[adj[j].v] = paths[adj[j].u] + adj[j].w;
				updated = true;
			}
		}
		if (!updated) {
			break;
		}
	}
	if (updated && i == n) {
		cout << "no min path\n";
	}
	else {
		for (i = 1; i < (int)paths.size(); ++i) {
			if (i != s) {
				if (paths[i] == INF) {
					cout << i << " cannot reach\n";
				}
				else {
					cout << i << " " <<" path: "<< paths[i] << "\n";
				}
			}
		}
	}
}

int main() {
	int n, m, u, v, w, i, s;
	cin >> n >> m;

	vector<Edge> edges(m);

	for (i = 0; i < m; ++i) {
		cin >> u >> v >> w;
		edges[i] = { u,v,w };
	}

	cin >> s;

	bel(edges, m, s);

	return 0;
}

/*
7 10
3 1 2
3 4 2
4 1 -1
1 5 3
5 4 4
5 6 100
5 7 2
2 5 1
2 1 4
4 5 1
3
*/

/*
7 10
3 1 2
3 4 2
4 1 -1
1 5 -10
5 4 4
5 6 100
5 7 2
2 5 1
2 1 4
4 5 1
3
*/
