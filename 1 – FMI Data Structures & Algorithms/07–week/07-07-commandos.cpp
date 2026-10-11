// https://www.hackerrank.com/contests/sda-2019-2020-test4/challenges/challenge-2273

#include <cstdio>
#include <queue>

using namespace std;

int main() {
    priority_queue<int, vector<int>, greater<int>> min_heap;

    int n;
    scanf("%d", &n);

    int a;
    for (int i = 0; i <= n; ++i) {
        scanf("%d", &a);
        if (a == -1 && !min_heap.empty()) {
            printf("%d ", min_heap.top());
            min_heap.pop();
        } else if (a != -1) {
            min_heap.push(a);
        }
    }

    return 0;
}
