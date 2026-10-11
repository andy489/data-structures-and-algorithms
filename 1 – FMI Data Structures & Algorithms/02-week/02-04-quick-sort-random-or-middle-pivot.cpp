#include <iostream>
#include <vector>

using namespace std;

int partition(vector<int> &arr, int start, int end) {
    int piv_index = start + rand() % ((end - start) + 1); // random pivot
    // int piv_index = start + (end - start) / 2; // middle pivot

    swap(arr[piv_index], arr[end]);

    int pivot = arr[end];
    piv_index = start;

    for (int i = start; i < end; ++i) {
        if (arr[i] <= pivot) {
            swap(arr[i], arr[piv_index++]);
        }
    }

    swap(arr[piv_index], arr[end]);

    return piv_index;
}

void quick_sort(vector<int> &arr, int start, int end) {
    if (start >= end) {
        return;
    }

    int pivot = partition(arr, start, end);

    quick_sort(arr, start, pivot - 1);
    quick_sort(arr, pivot + 1, end);
}

int main() {
    srand(time(nullptr));

    vector<int> arr = {9, 8, 4};
    int SIZE = arr.size();

    quick_sort(arr, 0, SIZE - 1);

    for (int e : arr) {
        cout << e << ' ';
    }

    return 0;
}
