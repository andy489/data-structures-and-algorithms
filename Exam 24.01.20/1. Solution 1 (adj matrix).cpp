// github.com/andy489

// https://www.hackerrank.com/contests/sda-2019-2020-exam-2e3nr4rr/challenges/challenge-2353

#include <iostream>
#include <vector>

using namespace std;

int main() {
    int N, M, K, a, b, w, cost(0), edge;
    cin >> N >> M;
    vector<vector<int>> adjMatrix;
    adjMatrix.assign(N, vector<int>(N, 0));
    while (M--) {
        cin >> a >> b >> w;
        adjMatrix[a][b] = w;
        adjMatrix[b][a] = w;
    }
    cin >> K;
    vector<int> path(K);
    for (a = 0; a < K; ++a)
        cin >> path[a];
    for (a = 0; a < K - 1; ++a) {
        edge = adjMatrix[path[a]][path[a + 1]];
        if (edge)
            cost += edge;
        else
            return cout << "-1", 0;
    }
    return cout << cost, 0;
}
