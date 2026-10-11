// https://www.hackerrank.com/contests/practice-4-sda/challenges/optimal-teams

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

auto read_input(int n) {
    vector<int> v;
    vector<pair<int, int>> pos;

    for (int i = 0; i < n; ++i) {
        int t;
        cin >> t;

        v.push_back(t);
        pos.emplace_back(t, i);
    }

    return make_pair(v, pos);
}

void choose_at(vector<int> &v, vector<pair<int, int>> &pos, int k, int ind, int team) {
    auto choose_helper_lambda = [&v, &pos, team](int i) {
        pos[v[i] - 1].first = 0;
        v[i] = -team;
    };

    choose_helper_lambda(ind);
    int c = 0;

    for (int i = ind - 1; i >= 0 && c < k; --i) {
        if (v[i] < 0) {
            continue;
        }

        choose_helper_lambda(i);
        ++c;
    }

    c = 0;
    for (int i = ind + 1; i < v.size() && c < k; ++i) {
        if (v[i] < 0) {
            continue;
        }

        choose_helper_lambda(i);
        ++c;
    }
}

void solve(vector<int> &v, vector<pair<int, int>> &pos, int k) {
    int team = 1, i;
    for (i = pos.size() - 1; i >= 0; --i)
        if (pos[i].first) {
            choose_at(v, pos, k, pos[i].second, team);
            team ^= 3;
        }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;
    auto p = read_input(n);

    sort(p.second.begin(), p.second.end());
    solve(p.first, p.second, k);

    for (int x: p.first) {
        cout << -x;
    }

    cout << endl;
}
