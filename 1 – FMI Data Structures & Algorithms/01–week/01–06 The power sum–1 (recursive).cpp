// https://www.hackerrank.com/challenges/the-power-sum/problem

#include <iostream>
#include <cmath>

using namespace std;

int res = 0;

int check_rec(int n, int x, int start, int k) {
    if (x == 0) {
        ++res;
    }

    int r = (int) floor(pow(n, 1.0 / k));

    for (int i = start + 1; i <= r; ++i) {
        int a = x - pow(i, k);
        
        if (a >= 0) {
            check_rec(n, x - pow(i, k), i, k);
        }
    }
    
    return res;
}

int check(int n, int k) {
    return check_rec(n, n, 0, k);
}

int main() {
    int n, k;
    cin >> n >> k;

    cout << check(n, k);
    return 0;
}
