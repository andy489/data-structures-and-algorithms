// https://www.hackerrank.com/challenges/rust-murderer/problem

#include <iostream>
#include <vector>
#include <queue>
#include <unordered_set>

using namespace std;

vector<unordered_set<int>> main_roads;
vector<int> shortest_paths;

void bfs(int u) {
    const int SIZE = main_roads.size();

    queue<int> q;
    q.push(u);

    shortest_paths[u] = 0;
    int cnt_visited = 1;

    while (!q.empty() && cnt_visited != SIZE) {
        int curr = q.front();
        q.pop();

        for (int i = 0; i < SIZE; ++i) {
            if (i != curr && !main_roads[curr].count(i) && shortest_paths[i] == -1) {
                q.push(i);
                shortest_paths[i] = shortest_paths[curr] + 1;
                ++cnt_visited;
            }
        }
    }
}

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;

        main_roads.assign(n, unordered_set<int>());

        int u, v;
        while (m--) {
            cin >> u >> v;
            --u;
            --v;
            main_roads[u].insert(v);
            main_roads[v].insert(u);
        }
        int s;
        cin >> s;
        --s;

        shortest_paths.assign(n, -1);

        bfs(s);

        for (int i = 0; i < n; ++i) {
            if (i != s) {
                cout << shortest_paths[i] << ' ';
            }
        }

        cout << endl;
    }

    return 0;
}