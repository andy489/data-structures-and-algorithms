// github.com/andy489

// https://www.hackerrank.com/contests/practice-6-sda/challenges/94/problem

#include <stdio.h>
#include <set>
#include <queue>

using namespace std;

struct Stop {
    int pos, scope, l, r;

    Stop(int pos = 0, int scope = 0) : pos(pos), scope(scope) {
        l = pos - scope, r = pos + scope;
    }

    bool operator>(const Stop &s) const {
        return this->r > s.r;
    }
};

int main() {
    int n, k, i(0), pos, scope, c(0);
    Stop curr;
    scanf("%d %d", &n, &k);

    multiset<int> students;
    multiset<int>::iterator it;

    priority_queue<Stop, vector<Stop>, greater<Stop>> stops;

    for (; i < n; ++i) {
        scanf("%d", &pos);
        students.insert(pos);
    }

    for (i = 0; i < k; ++i) {
        scanf("%d %d", &pos, &scope);
        stops.emplace(pos, scope);
    }

    while (!students.empty() && !stops.empty()) {
        curr = stops.top(), stops.pop();
        it = students.lower_bound(curr.l);
        if (it != students.end() && *it <= curr.r) {
            ++c;
            students.erase(it);
        }// O(n * log(n))
    }
    return printf("%d", c), 0;
}
