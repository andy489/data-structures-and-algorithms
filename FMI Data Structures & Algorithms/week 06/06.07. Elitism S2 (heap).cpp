// github.com/andy489

// https://www.hackerrank.com/contests/practice-6-sda/challenges/elitism

#include <stdio.h>
#include <queue>

using namespace std;

int main() {
    priority_queue<int, vector<int>, greater<int>> minHeap;
    priority_queue<int> maxHeap;
    int N, a;

    scanf("%d", &N);
    while (N--) {
        scanf("%d", &a);
        maxHeap.push(a);
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.push(maxHeap.top()), maxHeap.pop();
        else if (!minHeap.empty() && maxHeap.top() > minHeap.top()) {
            maxHeap.push(minHeap.top()), minHeap.pop();
            minHeap.push(maxHeap.top()), maxHeap.pop();
        }
        if (maxHeap.size() > minHeap.size())
            printf("%d.0\n", maxHeap.top());
        else {
            a = maxHeap.top() + minHeap.top();
            printf("%d.%d\n", a / 2, (a & 1) ? 5 : 0);
        }
    }
    return 0;
}
