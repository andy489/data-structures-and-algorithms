// https://www.hackerrank.com/contests/daa-2020-2021-winter-test1/challenges/challenge-2870

#include <cstdio>
#include <vector>
#include <map>

using namespace std;

int used[int(1e5) * 3], n, m, num_of_nodes;
vector<int> gr[int(1e5) * 3];
map<int, int> nodeNums;

void init() {
    int from, to;
    scanf("%d %d", &n, &m);

    for (int i = 0; i < m; ++i) {
        scanf("%d %d", &from, &to);

        if (!nodeNums.count(from)) {
            nodeNums[from] = num_of_nodes++;
        }
        if (!nodeNums.count(to)) {
            nodeNums[to] = num_of_nodes++;
        }

        from = nodeNums[from];
        to = nodeNums[to];

        gr[from].push_back(to);
        gr[to].push_back(from);
    }
}

void dfs(int node) {
    if (used[node]) {
        return;
    }

    used[node] = 1;

    for (int next_node:gr[node]) {
        dfs(next_node);
    }
}

void solve() {
    int components = 0;

    for (int i = 0; i < num_of_nodes; ++i) {
        if (used[i]) {
            continue;
        }

        dfs(i);
        ++components;
    }

    printf("%d\n", n - num_of_nodes + components);
}

int main() {
    init();

    solve();
}

