// github.com/andy489

/// Find if there are two elements with difference x in an array with n elements.

#include<iostream>
#include <cstdio>
#include<algorithm>

using namespace std;

bool binary(int *arr, int n, int x) {
    int left = 0, right = n - 1;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (x == arr[mid])
            return true;
        else if (x < arr[mid])
            right = mid - 1;
        else
            left = mid + 1;
    }
    return false;
}

int main() {
    int n, arr[1000], i(0), x;
    scanf("%d", &n);
    for (; i < n; ++i)
        scanf("%d", &arr[i]);
    scanf("%d", &x);
    sort(arr, arr + n);
    for (i = 0; i < n - 1; ++i)
        if (binary(arr, n, x + arr[i]) && x != 0)
            return cout << "YES", 0;
        else if (x == 0 && arr[i] == arr[i + 1])
            return cout << "YES", 0;
    return cout << "NO", 0;
}
