//https://www.hackerrank.com/contests/sda-2019-2020-test4/challenges/challenge-2274

#include <iostream>
#include <vector>
#include <unordered_map>
#include <queue>
#include <algorithm>

using namespace std;

int main() {
    int n, q;
    cin >> n >> q;

    vector<pair<int, int>> a;

    int s, e;
    while (n--) {
        cin >> s >> e;
        a.emplace_back(s, -1);
        a.emplace_back(e, 1);
    }

    unordered_map<int, int> answer;
    queue<int> order;

    while (q--) {
        cin >> s;
        a.emplace_back(s, 0);
        order.push(s);
    }

    sort(a.begin(), a.end());

    e = a.size();
    int i = 0;

    for (s = 0; s < e; ++s) {
        if (a[s].second == -1) {
            ++i;
        } else if (a[s].second == 1) {
            --i;
        } else {
            answer[a[s].first] = i;
        }
    }

    while (!order.empty()) {
        int cur = order.front();
        cout << answer[cur] << ' ';
        order.pop();
    }

    return 0;
}
