// github.com/andy489

/// Find the first occurrence of x in sorted array with n elements.

#include <iostream>
#include <algorithm>

using namespace std;

int leftMostOccurrence(int *arr, int n, int x) {
    int left = 0, right = n - 1, result = -1;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (x == arr[mid])
            result = mid, right = mid - 1;
        else if (x < arr[mid])
            right = mid - 1;
        else
            left = mid + 1;
    }
    return result;
}

int main() {
    int n, arr[1000], i(0),x;
    scanf("%d", &n);
    for (; i < n; ++i)
        scanf("%d", &arr[i]);
    cin >> x;
    sort(arr, arr + n);
    return cout << leftMostOccurrence(arr, n, x), 0;
}
