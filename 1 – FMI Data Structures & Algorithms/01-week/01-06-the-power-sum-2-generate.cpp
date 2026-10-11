// https://www.hackerrank.com/challenges/the-power-sum/problem

#include <iostream>

using namespace std;

int ans = 0;

int fast_pow(int x, int power) {
    if (power == 0) {
        return 1;
    }

    int p = fast_pow(x, power / 2);

    if (power & 1) {
        return x * p * p;

    }

    return p * p;
}

/*
The idea here is simple. the function generates
all the sums of distinct powers of n and counts
the ones that equal x.
*/

void gen_pow_sum(int x, int n, int last) {
    if (x < 0) {
        return;
    }

    if (x == 0) {
        ++ans;
        return;
    }

    for (int i = last + 1; fast_pow(i, n) <= x; ++i) {
        gen_pow_sum(x - fast_pow(i, n), n, i);
    }
}

int main() {
    int x, n;
    cin >> x >> n;

    gen_pow_sum(x, n, 0);

    cout << ans << endl;
    
    return 0;
}
