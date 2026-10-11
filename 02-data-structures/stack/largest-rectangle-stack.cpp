// https://www.hackerrank.com/challenges/largest-rectangle/problem

#include <iostream>
#include <stack>

using namespace std;

int max_histogram_area(int *h, int n) {
    int max_area = 0;

    stack<int> stack;

    int curr_area;

    int i = 0;
    while (i < n) {
        if (stack.empty() || h[i] >= h[stack.top()]) {
            stack.push(i++);
        } else {
            int t = stack.top();
            stack.pop();

            curr_area = h[t] * (stack.empty() ? i : i - stack.top() - 1);

            if (max_area < curr_area) {
                max_area = curr_area;
            }
        }
    }

    while (stack.empty() == false) {
        int t = stack.top();
        stack.pop();
        curr_area = h[t] * (stack.empty() ? i : i - stack.top() - 1);

        if (max_area < curr_area) {
            max_area = curr_area;
        }
    }

    return max_area;
}

int main() {
    int n;
    cin >> n;

    int *h = new int[n];

    for (int i = 0; i < n; ++i) {
        cin >> h[i];
    }

    cout << max_histogram_area(h, n);

    delete[] h;
}
