// https://www.hackerrank.com/contests/sda-exam-27-01-19-/challenges/-1-12/problem

#include <iostream>
#include <vector>
#include <list>
#include <queue>

using namespace std;

int main() {
    int q;
    cin >> q;

    vector<list<int>> in;
    vector<list<int>> out;

    int n, m;
    while (q--) {
        cin >> n >> m;
        // O(n)
        in.assign(n, list<int>());
        out.assign(n, list<int>());

        int xi, yi, wi;
        while (m--) {
            cin >> xi >> yi >> wi; // for detecting a cycle "wi" is not needed!
            --xi, --yi;
            in[xi].push_back(yi);
            out[yi].push_back(xi);
        }

        queue<int> sources;

        for (int i = 0; i < n; ++i) { // O(n + m)
            if (in[i].empty()) {
                sources.push(i);
            }
        }

        while (!sources.empty()) {
            int curr = sources.front();
            sources.pop();

            for (int v : out[curr]) {
                in[v].pop_back();
                if (in[v].empty()) {
                    sources.push(v);
                }
            }
        }

        bool cycle = false;
        for (const auto &e : in) {
            if (!e.empty()) { // at least one cycle
                cycle = true;
                break;
            }
        }

        cout << (cycle ? "true " : "false ");
    }

    return 0;
}