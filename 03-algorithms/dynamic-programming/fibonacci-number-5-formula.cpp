// n-th Fibonacci number (discrete formula)
// Time complexity : O(1)

#include<iostream>
#include<cmath>

using namespace std;

unsigned long long fibonacci(int n) {
    double phi = (1 + sqrt(5)) / 2;
    return round(pow(phi, n) / sqrt(5));
}

int main() {
    unsigned n;
    cin >> n;

    cout << fibonacci(n - 1) << endl;

    return 0;
}