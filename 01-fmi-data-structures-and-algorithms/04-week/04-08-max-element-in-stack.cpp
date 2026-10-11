// https://www.hackerrank.com/challenges/maximum-element/problem
// Find max element in a stack in O(1) time and O(1) extra space

#include <iostream>
#include <stack>

using namespace std;

struct MyStack {
    stack<int> S;
    int max = -1e9;

    [[nodiscard]] int get_max() const {
        return max;
    }

    void pop() {
        int t = S.top();
        S.pop();

        if (t > max) {
            max = 2 * max - t; // 2 * max - top
        }
    }

    void push(int x) {
        if (S.empty()) {
            max = x;
            S.push(x);
            return;
        }

        if (x > max) {
            S.push(2 * x - max); // 2 * el - max
            max = x;
        } else {
            S.push(x);
        }
    }
};

int main() {
    MyStack s;

    int n;
    cin >> n;

    int c, x;
    while (n--) {
        cin >> c;

        switch (c) {
            case 1:
                cin >> x;
                s.push(x);
                break;
            case 2:
                s.pop();
                break;

            case 3:
                cout << s.get_max() << endl;
                break;
            default:
                cout << "no such command" << endl;
        }
    }

    return 0;
}