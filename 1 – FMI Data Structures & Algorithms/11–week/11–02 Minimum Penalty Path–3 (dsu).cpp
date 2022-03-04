// https://www.hackerrank.com/contests/101hack34/challenges/beautiful-path/problem

#include<iostream>
#include<vector>

using namespace std;
const int MAX = 1024;

vector<pair<int, int>> weights[MAX];
int par[MAX];

int find_set(int a) {
    return a == par[a] ? a : par[a] = find_set(par[a]);
}

void unite_sets(int a, int b) {
    par[find_set(a)] = find_set(b);
}

int main() {
    int n, m;
    cin >> n >> m;
    
    int u, v, w;
    while (m--) {
        cin >> u >> v >> w;
        weights[w].emplace_back(u, v);
    }

    int s, e;
    cin >> s >> e;

    int result = -1;
    for (int i = 1; i <= MAX; ++i) {
        for (int j = 1; j <= n; ++j) {
            par[j] = j;
        }

        for (int j = 1; j <= i; ++j) {
            if ((j | i) == i) {
                for (const auto &edge : weights[j]) {
                    unite_sets(edge.first, edge.second);
                }
            }
        }

        if (find_set(s) == find_set(e)) {
            result = i;
            break;
        }
    }

    cout << result;

    return 0;
}
