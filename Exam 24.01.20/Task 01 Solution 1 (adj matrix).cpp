#include <iostream>
#include <vector>
using namespace std;

int main() {
    int N, M, K, a, b, w, c, cost(0), edge;
    cin >> N >> M;
    vector<vector<int>>adjMatrix;
    adjMatrix.assign(N, vector<int>(N, 0));
    while (M--) {
        cin >> a >> b >> w;
        adjMatrix[a][b] = w;
        adjMatrix[b][a] = w;
    }
    cin >> K;
    vector<int>path(K);
    for (a = 0;a < K;++a) {
        cin >> path[a];
    }
    for (a = 0;a < K - 1;++a) {
        edge = adjMatrix[path[a]][path[a + 1]];
        if (edge) {
            cost += edge;
        }
        else {
            cout << "-1";
            return 0;
        }
    }
    cout << cost;
    return 0;
}
