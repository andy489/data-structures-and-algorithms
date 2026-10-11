#include <iostream>

using namespace std;

int merge(int *, int *, int, int, int);

long long merge_sort(int *arr, int *temp, int left, int right) {
    long long inv_cnt = 0;
    int mid;

    if (right > left) {
        mid = (right + left) / 2;
        /* Inversion count will be sum of inversions in left part,
        right part and number of inversions in merging */

        inv_cnt = merge_sort(arr, temp, left, mid);
        inv_cnt += merge_sort(arr, temp, mid + 1, right);

        // merging the two parts
        inv_cnt += merge(arr, temp, left, mid + 1, right);
    }

    return inv_cnt;
}

long long merge_sort(int *arr, int n) {
    int *temp = new int[n];

    long long inv = merge_sort(arr, temp, 0, n - 1);

    delete[] temp;

    return inv;
}

// Merges two sorted arrays and returning inversion count in the arrays
int merge(int *arr, int *temp, int left, int mid, int right) {
    int i, j, k;
    int inv_cnt = 0;

    i = left; // i is index for left subarray
    j = mid; // j is index for right subarray
    k = left; // k is index for resultant merged subarray

    while ((i <= mid - 1) && (j <= right)) {
        if (arr[i] <= arr[j]) {
            temp[k++] = arr[i++];
        } else {
            temp[k++] = arr[j++];
            inv_cnt = inv_cnt + (mid - i);
        }
    }

    // copy remaining elements
    while (i <= mid - 1) {
        temp[k++] = arr[i++];
    }
    while (j <= right) {
        temp[k++] = arr[j++];
    }
    // copy back the merged elements to original array
    for (i = left; i <= right; ++i) {
        arr[i] = temp[i];
    }

    return inv_cnt;
}

int main() {
    int Q;
    cin >> Q;

    while (Q--) {
        int n;
        cin >> n;

        int *soldiers = new int[n];

        for (int i = 0; i < n; ++i) {
            cin >> soldiers[i];
        }

        cout << merge_sort(soldiers, n) << endl;

        delete[] soldiers;
    }

    return 0;
}
