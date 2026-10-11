// https://www.hackerrank.com/contests/practice-6-sda/challenges/elitism

#include <cstdio>
#include <queue>

using namespace std;

int main() {
    priority_queue<int, vector<int>, greater<int>> min_heap;
    priority_queue<int> max_heap;

    int n, a;

    scanf("%d", &n);
    while (n--) {
        scanf("%d", &a);
        max_heap.push(a);

        if (max_heap.size() > min_heap.size() + 1) {
            min_heap.push(max_heap.top());
            max_heap.pop();
        } else if (!min_heap.empty() && max_heap.top() > min_heap.top()) {
            max_heap.push(min_heap.top());

            min_heap.pop();
            min_heap.push(max_heap.top());

            max_heap.pop();
        }

        if (max_heap.size() > min_heap.size()) {
            printf("%d.0\n", max_heap.top());
        } else {
            a = max_heap.top() + min_heap.top();
            printf("%d.%d\n", a / 2, (a & 1) ? 5 : 0);
        }
    }

    return 0;
}
