// https://www.hackerrank.com/challenges/valid-bst/problem

#include <iostream>

using namespace std;

int test_preorder(int* arr, int n) {
    int j;
    int i = -1;

    while (++i < n - 1) {
        j = i + 1;

        while (arr[j] < arr[i] && j < n) {
            j++;
        }

        while (j < n) {
            if (arr[j] < arr[i]) {
                return 0;
            }

            ++j;
        };
    }
    return 1;
}

int main() {
    int cases, *arr;
    cin >> cases;

    while (cases--) {
        int n;
        cin >> n;
        arr = (int *) malloc(sizeof(int) * n);

        int i = -1;

        while (++i < n) {
            cin >> *(arr + i);
        }

        cout << (test_preorder(arr, n) ? "YES" : "NO") << endl;
    }

    return 0;
}