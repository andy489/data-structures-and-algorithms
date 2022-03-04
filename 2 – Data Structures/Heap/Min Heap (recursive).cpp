#include <iostream>
#include <vector>

using namespace std;

class Min_Heap {
    vector<int> arr;

    static int parent_ind(int i) {
        return (i - 1) / 2;
    }

    static int left_child_ind(int i) {
        return 2 * i + 1;
    }

    static int right_child_ind(int i) {
        return 2 * i + 2;
    }

    bool has_left_child(int i) {
        return left_child_ind(i) < (int) arr.size();
    }

    bool has_right_child(int i) {
        return right_child_ind(i) < (int) arr.size();
    }

    void sift_up(int i) {
        if (i == 0) {
            return;
        }

        if (arr[i] < arr[parent_ind(i)]) { // >
            swap(arr[parent_ind(i)], arr[i]);
            sift_up(parent_ind(i));
        }
    }

    void sift_down(int i) {
        if (!has_left_child(i)) {
            return;
        }
        int min_child_ind = left_child_ind(i);

        if (has_right_child(i) && arr[right_child_ind(i)] < arr[left_child_ind(i)]) { // >
            min_child_ind = right_child_ind(i);
        }

        if (arr[i] > arr[min_child_ind]) { // <
            swap(arr[i], arr[min_child_ind]);
            sift_down(min_child_ind);
        }
    }

public:

    Min_Heap() {
        arr.reserve(100);
    }

    //Floyd algorithm for building heap from array in linear time
    explicit Min_Heap(vector<int> &input) {
        int SIZE = (int) input.size();

        for (int i = 0; i < SIZE; ++i) {
            this->arr.emplace_back(input[i]);
        }

        for (int i = SIZE / 2 - 1; i >= 0; --i) {
            sift_down(i);
        }
    }

    void push(int val) {
        arr.emplace_back(val);
        sift_up((int) arr.size() - 1);
    }

    void pop() {
        int SIZE = arr.size();
        if (SIZE == 0) {
            return;
        }

        swap(arr[0], arr[SIZE - 1]);
        arr.pop_back();
        sift_down(0);
    }

    int peek() {
        if (arr.empty()) {
            return -1;
        }

        return arr[0];
    }
};

int main() {
    vector<int> arr = {100, 80, 85, 90, 75, 95, 110, 105, 115, 70, 65, 120, 60};
    Min_Heap heap(arr);

    cout << heap.peek() << endl;
    heap.pop();
    cout << heap.peek() << endl;
    heap.pop();
    cout << heap.peek() << endl;
    heap.pop();

    return 0;
}