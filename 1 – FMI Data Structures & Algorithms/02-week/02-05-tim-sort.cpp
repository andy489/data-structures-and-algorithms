#include <iostream>

using namespace std;

int min(int a, int b) {
    return a < b ? a : b;
}

void swap(int &a, int &b) {
    int tmp = a;
    a = b;
    b = tmp;
}

void insertion_sort(int *array, int n) {
    for (int i = 1; i < n; ++i) {
        for (int k = i; k > 0 && array[k] < array[k - 1]; --k) {
            swap(array[k], array[k - 1]);
        }
    }
}

void merge(int arr[], int left, int mid, int right) {
    int left_len = mid - left + 1;
    int right_len = right - mid;
    int *left_arr = new int[left_len];
    int *right_arr = new int[right_len];

    for (int i = 0; i < left_len; ++i) {
        left_arr[i] = arr[left + i];
    }
    for (int i = 0; i < right_len; ++i) {
        right_arr[i] = arr[mid + 1 + i];
    }

    int left_index = 0;
    int right_index = 0;
    int sorted_index = left;

    while (left_index < left_len && right_index < right_len) {
        if (left_arr[left_index] <= right_arr[right_index]) {
            arr[sorted_index] = left_arr[left_index];
            left_index++;
        } else {
            arr[sorted_index] = right_arr[right_index];
            right_index++;
        }
        sorted_index++;
    }

    while (left_index < left_len) {
        arr[sorted_index] = left_arr[left_index];
        sorted_index++;
        left_index++;
    }

    while (right_index < right_len) {
        arr[sorted_index] = right_arr[right_index];
        sorted_index++;
        right_index++;
    }

    delete[] left_arr;
    delete[] right_arr;
}

const int RUN = 32;

// Tim sort without galloping (bin search)
void tim_sort(int *arr, int n) {
    for (int i = 0; i < n; i += RUN) {
        insertion_sort(arr + i, min(32, (n - i)));
    }

    for (int size = RUN; size < n; size = 2 * size) {
        for (int left = 0; left < n; left += 2 * size) {
            int mid = left + size - 1;
            int right = min((left + 2 * size - 1), (n - 1));

            merge(arr, left, mid, right);
        }
    }
}

int main() {
    int arr[] = {9, 8, 4};

    int *arr_start = &arr[0];

    int SIZE = (int) sizeof arr / sizeof arr[0];

    tim_sort(arr_start, SIZE);

    for (int i = 0; i < SIZE; ++i) {
        if (i != SIZE - 1) {
            cout << arr[i] << ", ";
        } else {
            cout << arr[i];
        }
    }

    cout << endl;
}
