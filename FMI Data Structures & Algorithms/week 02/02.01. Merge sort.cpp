// github.com/andy489

#include <iostream>

using namespace std;

void merge(int *arr, int l, int mid, int r) {
    unique_ptr<int[]> l_arr(new int[mid - l + 1]);
    unique_ptr<int[]> r_arr(new int[r - mid]);

    memcpy(l_arr.get(), arr + l, sizeof(int) * (mid - l + 1));
    memcpy(r_arr.get(), arr + mid + 1, sizeof(int) * (r - mid));

    int l_ind = 0, r_ind = 0, i(l);

    for (; i <= r; ++i) {
        if (r_ind == r - mid || (l_ind != mid - l + 1 && l_arr[l_ind] < r_arr[r_ind]))
            arr[i] = l_arr[l_ind++];
        else
            arr[i] = r_arr[r_ind++];
    }
}

void mergeSort(int *arr, int l, int r) {
    if (l == r)
        return;
    int mid = (l + r) / 2;
    mergeSort(arr, l, mid);
    mergeSort(arr, mid + 1, r);
    merge(arr, l, mid, r);
}

int main() {
    int n, i(0);
    cin >> n;
    int *arr = new int[n];
    for (; i < n; ++i)
        cin >> arr[i];
    mergeSort(arr, 0, n - 1);
    for (i = 0; i < n; ++i)
        cout << arr[i] << ' ';
    return 0;
}
