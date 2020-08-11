// github.com/andy489

// https://www.hackerrank.com/contests/sda-2019-2020-test4/challenges/challenge-2273

#include <stdio.h>
#include <queue>

using namespace std;

int main() {
    priority_queue<int, vector<int>, greater<int>> minHeap;
    int n, i(0), a, curr;
    scanf("%d", &n);
    for (; i <= n; ++i) {
        scanf("%d", &a);
        if (a == -1 && !minHeap.empty())
            printf("%d ", minHeap.top()), minHeap.pop();
        else if (a != -1) minHeap.push(a);
    }
    return 0;
}
