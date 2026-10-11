// https://www.hackerrank.com/contests/sda-2019-2020-exam-2e3nr4rr/challenges/challenge-2353

#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    vector<vector<int>> adj_matrix;

    adj_matrix.assign(n, vector<int>(n, 0));

    int u, v, w;
    while (m--) {
        cin >> u >> v >> w;
        adj_matrix[u][v] = w;
        adj_matrix[v][u] = w;
    }

    int k;
    cin >> k;

    vector<int> path(k);

    for (int i = 0; i < k; ++i) {
        cin >> path[i];
    }

    int cost = 0;
    for (int i = 0; i < k - 1; ++i) {
        int edge = adj_matrix[path[i]][path[i + 1]];
        if (edge) {
            cost += edge;
        } else {
            cost = -1;
            break;
        }
    }

    cout << cost;

    return 0;
}
