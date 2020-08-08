// github.com/andy489

#include <iostream>

#define min(a, b) (((a) < (b)) ? (a) : (b))

void swap(int &a, int &b) {
    int tmp = a;
    a = b;
    b = tmp;
}

void insertionSort(int *array, int length) {
    for (int i = 1; i < length; i++) {
        for (int k = i; k > 0 && array[k] < array[k - 1]; k--) {
            swap(array[k], array[k - 1]);
        }
    }
}

void merge(int arr[], int left, int mid, int right) {
    int leftLen = mid - left + 1;
    int rightLen = right - mid;
    int *leftArr = new int[leftLen];
    int *rightArr = new int[rightLen];

    for (int i = 0; i < leftLen; i++)
        leftArr[i] = arr[left + i];
    for (int i = 0; i < rightLen; i++)
        rightArr[i] = arr[mid + 1 + i];

    int leftIndex = 0;
    int rightIndex = 0;
    int sortedIndex = left;

    while (leftIndex < leftLen && rightIndex < rightLen) {
        if (leftArr[leftIndex] <= rightArr[rightIndex]) {
            arr[sortedIndex] = leftArr[leftIndex];
            leftIndex++;
        } else {
            arr[sortedIndex] = rightArr[rightIndex];
            rightIndex++;
        }
        sortedIndex++;
    }

    while (leftIndex < leftLen) {
        arr[sortedIndex] = leftArr[leftIndex];
        sortedIndex++;
        leftIndex++;
    }

    while (rightIndex < rightLen) {
        arr[sortedIndex] = rightArr[rightIndex];
        sortedIndex++;
        rightIndex++;
    }

    delete[] leftArr;
    delete[] rightArr;
}

const int RUN = 32;

// Tim sort without galloping (binary search)
void timSort(int *array, int length) {
    for (int i = 0; i < length; i += RUN)
        insertionSort(array + i, min(32, (length - i)));

    for (int size = RUN; size < length; size = 2 * size) {
        for (int left = 0; left < length; left += 2 * size) {
            int mid = left + size - 1;
            int right = min((left + 2 * size - 1), (length - 1));
            merge(array, left, mid, right);
        }
    }
}

int main() {
    int arr[] = {2, 5, 3, 6, 1, 8, 4, 7, 9};
    int *arrStart = &arr[0];

    int SIZE = (int) sizeof(arr) / sizeof(arr[0]);

    timSort(arrStart, SIZE);

    for (int i = 0; i < SIZE; i++) {
        if (i != SIZE - 1)
            std::cout << arr[i] << ", ";
        else
            std::cout << arr[i];
    }
    std::cout << "\n";
}
