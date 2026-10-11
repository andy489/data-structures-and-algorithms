#include <iostream>
#include <vector>

using namespace std;
typedef vector<int> vi;

int partition(vi &arr, int start, int end) {
    int piv_index = (start + end + 1) / 2;
    // int piv_index = (start + end) / 2;

    swap(arr[piv_index], arr[end]);
    int pivot = arr[end];

    piv_index = start;

    for (int i = start; i < end; ++i) {
        if (arr[i] < pivot) {
            swap(arr[i], arr[piv_index++]);
        }
    }

    swap(arr[piv_index], arr[end]);

    for (int e : arr) {
        cout << e << ' ';
    }

    cout << endl;

    return piv_index;
}

void quick_sort(vi &arr, int start, int end) {
    if (start >= end) {
        return;
    }

    int pivot = partition(arr, start, end);

    quick_sort(arr, start, pivot - 1);
    quick_sort(arr, pivot + 1, end);
}

int main() {
    int n;
    cin >> n;
    vi arr(n);

    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }

    quick_sort(arr, 0, n - 1);
}
