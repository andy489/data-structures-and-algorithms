// n-th Fibonacci number (recursive with memoization)
// Time complexity : O(n) - linear

#include <iostream>

using namespace std;

static unsigned long long recur_cnt;
static unsigned long long *fib_numbers;

unsigned long long fibonacci_recursive(unsigned n) {
    if (fib_numbers[n]) {
        return fib_numbers[n];
    }

    ++recur_cnt;

    if (n == 1) {
        return 0;
    }
    if (n == 2) {
        return 1;
    }

    unsigned long long result = fibonacci_recursive(n - 1) + fibonacci_recursive(n - 2);

    fib_numbers[n] = result;

    return result;
}

int main() {
    unsigned n;
    cin >> n;

    fib_numbers = new unsigned long long[n + 1]{};

    unsigned long long fibonacci_number = fibonacci_recursive(n);

    cout << "Recursive calls: "
         << recur_cnt
         << endl
         << n
         << "-th Fibonacci number : "
         << fibonacci_number
         << endl;

    return 0;
}