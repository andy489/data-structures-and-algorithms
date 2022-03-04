// n-th Fibonacci number (Recursive, no memoization)
// Time complexity : O(1.6^n) – exponential

#include <iostream>

using namespace std;

static unsigned long long overlapping_recur_cnt;

unsigned long long fibonacci_recursive(unsigned n) {
    ++overlapping_recur_cnt;

    if (n == 1) {
        return 0;
    }
    if (n == 2) {
        return 1;
    }

    return fibonacci_recursive(n - 1) + fibonacci_recursive(n - 2);
}

int main() {
    unsigned n;
    cin >> n;

    unsigned long long fibonacci_number = fibonacci_recursive(n);

    cout << "Recursive calls: "
         << overlapping_recur_cnt
         << endl
         << n
         << "-th Fibonacci number : "
         << fibonacci_number
         << endl;

    return 0;
}