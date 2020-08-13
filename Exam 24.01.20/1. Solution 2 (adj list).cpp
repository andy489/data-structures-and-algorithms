// github.com/andy489

// https://www.hackerrank.com/contests/sda-2019-2020-exam-2e3nr4rr/challenges/challenge-2353

#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

int main() {
    int N, M, K, a, b, w, cost(0);
    cin >> N >> M;
    vector<unordered_map<int, int>> adj(N, unordered_map<int, int>());
    while (M--) {
        cin >> a >> b >> w;
        adj[a][b] = w;
        adj[b][a] = w;
    }

    cin >> K;
    vector<int> path(K);

    for (w = 0; w < K; ++w)
        cin >> path[w];

    for (w = 0; w < K - 1; ++w) {
        if (adj[path[w]].count(path[w + 1]))
            cost += adj[path[w]][path[w + 1]];
        else
            return cout << "-1", 0;
    }
    return cout << cost, 0;
}
