// https://www.hackerrank.com/challenges/30-running-time-and-complexity/problem

#include <iostream>

using namespace std;

bool is_prime(int n) {
    if (n == 1) {
        return false;
    }

    for (int i = 2; i * i <= n; ++i) {
        if (n % i == 0) {
            return false;
        }
    }

    return true;
}

int main() {
    int n, p;
    cin >> n;

    while (n--) {
        cin >> p;
        cout << (is_prime(p) ? "Prime" : "Not prime") << endl;
    }

    return 0;
}
