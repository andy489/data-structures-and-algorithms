// github.com/andy489

#include <iostream>
#include <vector>
#include <queue>
using namespace std;
#define INF 100000

void djk(const vector<vector<pair<int, int>>>& adj, int s){
	vector<bool> visited(adj.size());
	vector<int> paths(adj.size(), INF);
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> q;
	q.push({ 0, s });
	paths[s] = 0;

	while (!q.empty()){
		pair<int, int> curr = q.top(); q.pop();

		visited[curr.second] = true;

		for (const auto& x : adj[curr.second]){
			if (!visited[x.second]){
				if (paths[curr.second] + x.first < paths[x.second]){
					paths[x.second] = paths[curr.second] + x.first;
					q.push({ paths[x.second], x.second });
				}
			}
		}
	}

	for (int i = 1; i < paths.size(); ++i){
		if (i != s){
			if (paths[i] == INF){
				cout << -1 << ' ';
			}
			else{
				cout << paths[i] << ' ';
			}
		}
	}
}

int main(){
	int n, m, u, v, w, i, s;
	cin >> n >> m;

	vector<vector<pair<int, int>>> adj(n + 1);

	for (i = 0; i < m; ++i){
		cin >> u >> v >> w;
		adj[u].emplace_back(w, v);
		adj[v].emplace_back(w, u);
	}

	cin >> s;

	djk(adj, s);

	return 0;
}

/*
9 9
3 8 7
3 6 2
1 3 1
8 7 1
2 7 10
6 7 1
5 7 2
4 8 4
4 5 1
3

1 13 6 5 2 3 4 -1
*/
