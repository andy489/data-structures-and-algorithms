// github.com/andy489

// https://www.hackerrank.com/contests/practice-8-sda/challenges/bdz

#include <iostream>
#include <vector>
#include <list>

using namespace std;

vector<int> memo;
vector<list<int>> graph;
const int MOD = 1e9 + 7;

int counter(int s) {
    if (memo[s] != -1)
        return memo[s];
    int sum = 0;
    for (int n: graph[s]) {
        sum += counter(n);
        sum %= MOD;
    }

    memo[s] = sum % MOD;
    return memo[s];
}

int main() {
    int n, m, i(0);
    cin >> n >> m;
    graph.resize(n + 1);
    memo.resize(n + 1);
    fill(memo.begin(), memo.end(), -1);
    int u, v;
    for (; i < m; ++i) {
        cin >> u >> v;
        graph[u].push_back(v);
    }
    int s, e;
    cin >> s >> e;
    memo[e] = 1;
    return cout << counter(s), 0;
}
