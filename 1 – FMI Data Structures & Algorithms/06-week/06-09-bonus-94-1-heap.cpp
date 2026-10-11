// https://www.hackerrank.com/contests/practice-6-sda/challenges/94

#include <iostream>
#include <utility>
#include <algorithm>
#include <queue>

using namespace std;

#define x first
#define y second

typedef pair<int, int> pii;

const int MAX = 2 * 1e6 + 5;

int A[MAX];
pii B[MAX], C[MAX];

int main() {
    int n, m;
    cin >> n >> m;

    for (int i = 0; i < n; ++i) {
        cin >> A[i];
    }

    for (int i = 0; i < n; ++i) {
        cin >> B[i].x >> B[i].y;
        C[i] = {B[i].x - B[i].y, B[i].x + B[i].y};
    }

    sort(A, A + n);
    sort(C, C + m);

    priority_queue<int, vector<int>, greater<int>> q;

    int j = 0, ans = 0;
    for (int i = 0; i < n; ++i) {
        while (j < m && A[i] >= C[j].x) {
            q.push(C[j++].y);
        }

        while (!q.empty() && q.top() < A[i]) {
            q.pop();
        }

        if (!q.empty()) {
            q.pop();
            ++ans;
        }
    }

    cout << ans;

    return 0;
}
