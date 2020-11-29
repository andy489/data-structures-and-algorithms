#include <cstdio>

using namespace std;

const int mxN = 1e6;

void swap(int &a, int &b){
    a^=b^=a^=b;
}

class MinHeap {
    int arr[mxN];
    int pos;

    int par(int i) {
        return (i - 1) >> 1;
    }

    int left(int i) {
        return 2 * i + 1;
    }

    int right(int i) {
        return 2 * i + 2;
    }

    bool hasLeft(int i) {
        return left(i) < pos;
    }

    bool hasRight(int i) {
        return right(i) < pos;
    }

    void siftUp(int i) {
        if (i == 0) return;
        if (arr[i] < arr[par(i)]) {
            swap(arr[par(i)], arr[i]);
            siftUp(par(i));
        }
    }

    void siftDown(int i) {
        if (!hasLeft(i)) return;
        int mini = left(i);
        if (hasRight(i) && arr[right(i)] < arr[left(i)])
            mini = right(i);
        if (arr[i] > arr[mini]) {
            swap(arr[i], arr[mini]);
            siftDown(mini);
        }
    }

public:

    MinHeap() {
        pos = 0;
    }

    void push(int val) {
        arr[pos++] = val;
        siftUp(pos - 1);
    }

    void pop() {
        if (pos == 0) return;
        swap(arr[0], arr[pos - 1]);
        pos--;
        siftDown(0);
    }

    int peek() {
        if (pos == 0) return -1;
        return arr[0];
    }
};

void queries(){
    MinHeap PQ; // init()
    int q, cmd, x;
    scanf("%d", &q);
    while (q--) {
        scanf("%d", &cmd);
        switch (cmd) {
            case 1:
                scanf("%d", &x);
                PQ.push(x);
                break;
            case 2:
                PQ.pop();
                break;
            case 3:
                printf("%d\n", PQ.peek());
                break;
            default:
                printf("catch input\n");
        }
    }
}

int main() {
    return queries(), 0;
}
