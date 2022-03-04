// https://www.hackerrank.com/contests/practice-8-sda/challenges/bdz

#include <iostream>
#include <vector>
#include <list>

using namespace std;

const int MOD = 1e9 + 7;

vector<int> memo;
vector<list<int>> adj;

int dfs_dp_memo(int s) {
    if (memo[s] != -1) {
        return memo[s];
    }
    
    int sum = 0;

    for (int n: adj[s]) {
        sum += dfs_dp_memo(n);
        sum %= MOD;
    }

    memo[s] = sum % MOD;

    return memo[s];
}

int main() {
    int n, m;
    cin >> n >> m;

    adj.resize(n + 1);
    memo.resize(n + 1);

    fill(memo.begin(), memo.end(), -1);

    int u, v;
    while(m--){
        cin >> u >> v;
        adj[u].push_back(v);
    }

    int s, e;
    cin >> s >> e;

    memo[e] = 1;

    cout << dfs_dp_memo(s);

    return 0;
}
