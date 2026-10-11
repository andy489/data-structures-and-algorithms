#include <iostream>

using namespace std;

const int mxN = 1e6;

void swap(int &a, int &b) {
    a ^= b ^= a ^= b;
}

class Min_Heap {
    int arr[mxN]{};
    int pos;

    static int par(int i) {
        return (i - 1) >> 1;
    }

    static int left(int i) {
        return 2 * i + 1;
    }

    static int right(int i) {
        return 2 * i + 2;
    }

    [[nodiscard]] bool has_left(int i) const {
        return left(i) < pos;
    }

    [[nodiscard]] bool has_right(int i) const {
        return right(i) < pos;
    }

    void sift_up(int i) {
        if (i == 0) {
            return;
        }

        if (arr[i] < arr[par(i)]) {
            swap(arr[par(i)], arr[i]);
            sift_up(par(i));
        }
    }

    void sift_down(int i) {
        if (!has_left(i)) {
            return;
        }
        int mini = left(i);

        if (has_right(i) && arr[right(i)] < arr[left(i)]) {
            mini = right(i);
        }

        if (arr[i] > arr[mini]) {
            swap(arr[i], arr[mini]);
            sift_down(mini);
        }
    }

public:

    Min_Heap() {
        pos = 0;
    }

    void push(int val) {
        arr[pos++] = val;
        sift_up(pos - 1);
    }

    void pop() {
        if (pos == 0) {
            return;
        }

        swap(arr[0], arr[pos - 1]);
        --pos;
        sift_down(0);
    }

    int peek() {
        if (pos == 0) {
            return -1;
        }

        return arr[0];
    }
};

void queries() {
    Min_Heap PQ;

    int q;
    cin >> q;

    int cmd, x;
    while (q--) {
        cin >> cmd;

        switch (cmd) {
            case 1:
                cin >> x;
                PQ.push(x);
                break;
            case 2:
                PQ.pop();
                break;
            case 3:
                cout << PQ.peek() << endl;
                break;
            default:
                cout << "catch input" << endl;
        }
    }
}

int main() {
    queries();
    return 0;
}
