// github.com/andy489

#include <iostream>
#include <cmath>

using namespace std;

int ans = 0;

/// time complexity O(power)
int slowPow(int x, int power) {
    int res = 1;
    for (int i = 0; i < power; ++i) {
        res *= x;
    }
    return res;
}

/// time complexity O(log2(power))
int fastPow(int x, int power) {
    if (power == 0)
        return 1;
    if (power % 2 == 0)
        return pow(x, power / 2) * pow(x, power / 2);
    return x * pow(x, power / 2) * pow(x, power / 2);
}

/*
The idea here is simple. the function generates
all the sums of distinct powers of n and counts
the ones that equal x.
*/

void generatePowerSum(int x, int n, int last) {
    if (x < 0)
        return;
    if (x == 0) {
        ++ans;
        return;
    }
    for (int i = last + 1; fastPow(i, n) <= x; ++i)
        generatePowerSum(x - fastPow(i, n), n, i);
}

int main() {
    int x, n;
    cin >> x >> n;
    generatePowerSum(x, n, 0);
    return cout << ans << '\n', 0;
}

