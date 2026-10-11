// https://www.hackerrank.com/contests/sda-exam-27-01-19-/challenges/-1-12/problem

#include <iostream>
#include <vector>
#include <list>

using namespace std;

vector <list<int>> adj;

vector<bool> temp_mark;
vector<bool> perm_mark;

bool is_acyclic(int u) { // O(n)
    if (perm_mark[u]) {
        return true;
    }

    if (temp_mark[u]) {
        return false;
    }

    temp_mark[u] = true;

    for (int child : adj[u]) {
        if (is_acyclic(child)) {
            continue;
        }

        return false;
    }
    
    perm_mark[u] = true;
    temp_mark[u] = false;
    return true;
}


int main() {
    int q;
    cin >> q;

    int n, m;
    while (q--) {
        cin >> n >> m;

        adj.assign(n, list<int>());
        temp_mark.assign(n, false);
        perm_mark.assign(n, false);
        
        int xi, yi, wi;
        while (m--) {
            cin >> xi >> yi >> wi; // for detecting a cycle "wi" is not needed!
            adj[xi - 1].push_back(yi - 1);
        }

        bool cycle = false;
        
        for (int i = 0; i < n; ++i) {
            if(!is_acyclic(i)){
                cycle = true;
                break;
            }
        }

        cout << (cycle ? "true " : "false ");
    }
    
    return 0;
}