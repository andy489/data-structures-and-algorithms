#include <iostream>
#include <algorithm>
using namespace std;

int bubbleSort(int* a, int n) {
    int i, j, swaps(0);
    for (i = 0;i < n;++i) {
        int c(0);
        for (j = 0;j < n - i - 1;++j) {
            if (a[j] > a[j + 1]) {
                swap(a[j], a[j + 1]);
                ++c;
            }
        }
        if (!c) {
            return swaps;
        }
        swaps += c;
    }
    return swaps;
}

int main() {
    int n, i;
    cin >> n;
    int* a = new int[n];
    for (i = 0;i < n;++i) {
        cin >> a[i];
    }

    int swaps = bubbleSort(a, n);
    cout << "Array is sorted in " << swaps << " swaps.\n" <<
        "First Element: " << a[0] << "\nLast Element: " << a[n - 1];
    return 0;
}
