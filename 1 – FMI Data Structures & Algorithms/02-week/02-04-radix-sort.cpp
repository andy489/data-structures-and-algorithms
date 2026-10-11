#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

int abs(int a) {
    return a >= 0 ? a : -a;
}

void radix_sort(int *arr, int n) {
    int max_num = 0;

    for (int i = 0; i < n; ++i) {
        if (abs(arr[i]) > max_num) {
            max_num = abs(arr[i]);
        }
    }

    int max_digits = (int) log10(max_num) + 1;

    vector<int> pocket[10];

    for (int i = 0; i < max_digits; ++i) {
        int m = pow(10, i + 1);
        int p = pow(10, i);

        for (int j = 0; j < n; ++j) {
            int temp = arr[j] % m;
            int index = temp / p;
            pocket[index].push_back(arr[j]);
        }

        int cnt = 0;

        for (auto &j : pocket) {
            while (!j.empty()) {
                arr[cnt] = *(j.begin());
                j.erase(j.begin());
                ++cnt;
            }
        }
    }
}

int main() {
    int arr[] = {9, 8, 4};
    int SIZE = sizeof arr / sizeof arr[0];
    int *arr_start = &arr[0];

    radix_sort(arr_start, SIZE);

    for (int i = 0; i < SIZE; ++i) {
        cout << arr[i] << " ";
    }
}
