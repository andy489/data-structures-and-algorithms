// github.com/andy489

/*
Idea: we will the data in lexicographical descending order
and then print the data without intervals, easy as that.
*/

#include <iostream>
#include <cmath>
using namespace std;

int getLength(int a) { // statically casting log10(a) to get length a
    return int(log10(a)) + 1;
}

int getMin(int a, int b) {
    return a < b ? a : b;
}

//utility function to simulate lexicographical comparison
bool unsignedCmp(int a, int b) {
    int len_a = getLength(a), len_b = getLength(b), i(0);
    int minLength = getMin(len_a, len_b);
    for (; i < minLength; ++i) {
        int digit_a = (int) (a / pow(10, len_a - 1)),
        digit_b = (int) (b / pow(10, len_b - 1));
        if (digit_a > digit_b) {
            return true;
        } else if (digit_a < digit_b) {
            return false;
        }
        a = a % int(pow(10, len_a - 1));
        b = b % int(pow(10, len_b - 1));
        len_a--;
        len_b--;
    }
    return len_a > len_b ? true : false;
}

void bubbleSortLexicographical(int *arr, int arrLen) {
    while (true) {
        bool swapped = false;
        for (int index = 0; index < arrLen - 1; ++index) {
            if (!unsignedCmp(arr[index], arr[index + 1])) {
                std::swap(arr[index], arr[index + 1]);
                swapped = true;
            }
        }
        if (!swapped) break;
    }
}

void printArr(int *arr, int n) {
    for (int i = 0; i < n; i++)
        cout << arr[i];
}

int main() { //input data
    int n;
    cin >> n;
    //dynamically created array to store the data
    int *arr = new int[n];
    //collect the data from the input
    for (int i = 0; i < n; ++i)
        cin >> arr[i];
    //sort the data in lexicographical descending order
    bubbleSortLexicographical(arr, n);
    //print the data without intervals
    printArr(arr, n);
    //release the data
    delete[] arr;
    return 0;
}
