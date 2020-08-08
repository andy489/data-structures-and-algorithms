// github.com/andy489

#include <iostream>
#include <cmath>

using namespace std;

int res = 0;

int checkRecursive(int N, int X, int start, int K) {
    if (X == 0)
        ++res;

    int r = (int) floor(pow(N, 1.0 / K));

    for (int i = start + 1; i <= r; i++) {
        int a = X - (int) pow(i, K);
        if (a >= 0) checkRecursive(N, X - (int) pow(i, K), i, K);
    }
    return res;
}

int check(int N, int K) {
    return checkRecursive(N, N, 0, K);
}

int main() {
    int N, K;
    cin >> N >> K;
    return cout << (check(N, K)), 0;
}
