/*
Idea: we will sort the data in lexicographical descending order
and then print the data without intervals, easy as that.
*/

#include <iostream>
#include <cmath>

using namespace std;

int get_len(int a) { // statically casting log10(a) to get the length of a
    return int(log10(a)) + 1;
}

int getMin(int a, int b) {
    return a < b ? a : b;
}

//utility function to simulate lexicographical comparison
bool compare_unsigned(int a, int b) {
    int len_a = get_len(a);
    int len_b = get_len(b);

    int minLength = getMin(len_a, len_b);

    for (int i = 0; i < minLength; ++i) {
        int digit_a = (int) (a / pow(10, len_a - 1));
        int digit_b = (int) (b / pow(10, len_b - 1));

        if (digit_a > digit_b) {
            return true;
        } else if (digit_a < digit_b) {
            return false;
        }

        a = a % int(pow(10, len_a - 1));
        b = b % int(pow(10, len_b - 1));
        
        --len_a;
        --len_b;
    }
    
    return len_a > len_b ? true : false;
}

void bubble_sort_lexicographical(int *arr, int n) {
    while (true) {
        bool swapped = false;
        
        for (int index = 0; index < n - 1; ++index) {
            if (!compare_unsigned(arr[index], arr[index + 1])) {
                swap(arr[index], arr[index + 1]);
                swapped = true;
            }
        }
        if (!swapped) {
            break;
        }
    }
}

void print_arr(int *arr, int n) {
    for (int i = 0; i < n; ++i) {
        cout << arr[i];
    }
}

int main() {
    int n;
    cin >> n;

    int *arr = new int[n];

    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }
    
    bubble_sort_lexicographical(arr, n);

    print_arr(arr, n);

    delete[] arr;

    return 0;
}
