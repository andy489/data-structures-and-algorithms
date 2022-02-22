// https://www.hackerrank.com/challenges/candies/problem

#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n, i;
    cin >> n;

    vector<int> a(n), candy(n);

    for (i = 0; i < n; ++i) {
        cin >> a[i];
    }

    candy[0] = 1;

    for (i = 1; i < n; ++i) {
        candy[i] = a[i] > a[i - 1] ? candy[i - 1] + 1 : 1;
    }

    for (i = n - 2; i >= 0; --i) {
        if (a[i] > a[i + 1] && candy[i + 1] >= candy[i]) {
            candy[i] = candy[i + 1] + 1;
        }
    }

    long candies = 0;

    for (i = 0; i < n; ++i) {
        candies += candy[i];
    }

    cout << candies;
}