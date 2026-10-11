// https://www.hackerrank.com/contests/practice-6-sda/challenges/94/problem

#include <iostream>
#include <set>
#include <queue>

using namespace std;

struct Stop {
    int l, r;

    explicit Stop(int pos = 0, int scope = 0) {
        l = pos - scope, r = pos + scope;
    }

    bool operator>(const Stop &s) const {
        return this->r > s.r;
    }
};

int main() {
    int n, k;
    Stop curr;
    cin >> n >> k;

    multiset<int> students;
    multiset<int>::iterator it;

    priority_queue<Stop, vector<Stop>, greater<Stop>> stops;

    int pos;
    for (int i = 0; i < n; ++i) {
        cin >> pos;
        students.insert(pos);
    }

    int scope;
    for (int i = 0; i < k; ++i) {
        cin >> pos >> scope;
        stops.emplace(pos, scope);
    }

    int res = 0;
    while (!students.empty() && !stops.empty()) {
        curr = stops.top();
        stops.pop();

        it = students.lower_bound(curr.l);

        if (it != students.end() && *it <= curr.r) {
            ++res;
            students.erase(it);
        }
    }

    cout << res;

    return 0;
}
