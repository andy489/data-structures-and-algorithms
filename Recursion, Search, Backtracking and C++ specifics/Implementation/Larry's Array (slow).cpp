// // https://www.hackerrank.com/challenges/larrys-array/problem

#include <iostream>

using namespace std;

const int N = 1509;
int n;
int a[N];

void input() {
    cin >> n;
    for (int i = 1; i <= n; ++i) {
        cin >> a[i];
    }
}

void sol() {
    int K = 1;
    for (int i = 1; i <= n; ++i) {
        for (int j = i + 1; j <= n; ++j) {
            K ^= (a[i] > a[j]);
        }
    }

    cout << (K ? "YES" : "NO") << endl;
}

int main() {
    int tests;
    cin >> tests;

    while (tests--) {
        input();
        sol();
    }

    return 0;
}
