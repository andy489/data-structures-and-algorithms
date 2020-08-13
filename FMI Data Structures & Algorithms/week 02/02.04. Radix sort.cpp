// github.com/andy489

#include <iostream>
#include <cmath>
#include <list>

using namespace std;

int abs(int a) {
    return a >= 0 ? a : -a;
}

void radixSort(int *array, int length) {
    int maxNumber(0), i(0);
    for (; i < length; ++i)
        if (abs(array[i]) > maxNumber)
            maxNumber = abs(array[i]);

    int maxDigits = log10(maxNumber) + 1;

    list<int> pocket[10];

    for (i = 0; i < maxDigits; ++i) {
        int m = pow(10, i + 1), p = pow(10, i);

        for (int j = 0; j < length; ++j) {
            int temp = array[j] % m, index = temp / p;
            pocket[index].push_back(array[j]);
        }

        int count = 0;
        for (int j = 0; j < 10; ++j) {
            while (!pocket[j].empty()) {
                array[count] = *(pocket[j].begin());
                pocket[j].erase(pocket[j].begin());
                count++;
            }
        }
    }
}

int main() {
    int arr[] = {22, 53, 31, 67, 16, 4};
    int *arrStart = &arr[0];

    radixSort(arrStart, 6);

    for (int i = 0; i < 6; ++i)
        cout << arr[i] << " ";
}
