// github.com/andy489

// https://www.hackerrank.com/contests/practice-6-sda/challenges/94

#include <iostream>
#include <utility>
#include <algorithm>
#include <queue>

#define x first
#define y second

using namespace std;
typedef pair<int, int> pii;
const int mxN = 2 * 1e6 + 5;

int n, m, i, j, ans, A[mxN];
pii B[mxN], C[mxN];

priority_queue<int, vector<int>, greater<int>> Q;

int main() {
    cin >> n >> m;

    for (; i < n; ++i)
        cin >> A[i];

    for (i = 0; i < n; ++i) {
        cin >> B[i].x >> B[i].y;
        C[i] = {B[i].x - B[i].y, B[i].x + B[i].y};
    }

    sort(A, A + n);
    sort(C, C + m);

    for (i = 0; i < n; ++i) {
        while (j < m && A[i] >= C[j].x)
            Q.push(C[j++].y);
        while (!Q.empty() && Q.top() < A[i])
            Q.pop();
        if (!Q.empty())
            Q.pop(), ++ans;
    }
    return cout << ans, 0;
}
