// https://www.hackerrank.com/contests/daa-2020-2021-winter-test2/challenges/1-290

#include <cstdio>
#include <climits>
#include <algorithm>

using namespace std;

int n, m, dist[560][560];
long long num_paths[560][560];
const int mod = 1e9 + 21;

void init() {
    int from, to, weight;

    scanf("%d %d", &n, &m);

    for (int i = 0; i <= n; ++i) {
        fill(dist[i], dist[i] + n + 1, INT_MAX / 5);
    }

    for (int i = 0; i < m; ++i) {
        scanf("%d %d %d", &from, &to, &weight);

        dist[from][to] = weight;
        dist[to][from] = weight;

        num_paths[from][to] = 1;
        num_paths[to][from] = 1;
    }

    for (int i = 0; i <= n; i++) {
        dist[i][i] = 0;
    }
}

void floyd() {
    for (int k = 1; k <= n; ++k) {
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                int new_dist = dist[i][k] + dist[k][j];

                if (dist[i][j] < new_dist) {
                    continue;
                }
                
                if (dist[i][j] == new_dist) {
                    num_paths[i][j] = (num_paths[i][j] + num_paths[i][k] * num_paths[k][j]) % mod;
                } else {
                    dist[i][j] = new_dist;
                    num_paths[i][j] = (num_paths[i][k] * num_paths[k][j]) % mod;
                }
            }
        }
    }
}

void readQs() {
    int q, from, to;

    scanf("%d", &q);

    scanf("%d %d", &from, &to);
    printf("%d", num_paths[from][to]);

    for (int i = 1; i < q; i++) {
        scanf("%d %d", &from, &to);
        printf(" %d", num_paths[from][to]);
    }

    printf("\n");
}

int main() {
    init();

    floyd();

    readQs();
    
    return 0;
}
