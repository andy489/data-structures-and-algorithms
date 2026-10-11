// n-th Fibonacci number (iterative)
// Time complexity : O(n) – linear

#include <iostream>

using namespace std;

unsigned long long fibonacci_iterative(unsigned n) {
    unsigned long long first = 0;
    unsigned long long second = 1;

    if (n == 1) {
        return 0;
    }

    do {
        --n;
        unsigned long long fib_n = first + second;

        first = second;
        second = fib_n;
    } while (n > 2);

    return second;
}

int main() {
    unsigned n;
    cin >> n;

    cout << n
         << "-th Fibonacci number : "
         << fibonacci_iterative(n)
         << endl;

    return 0;
}