// https://codeforces.com/contest/872/problem/B

#include <iostream>

using namespace std;

int min(int a, int b) {
    return a > b ? b : a;
}

int max(int a, int b) {
    return a > b ? a : b;
}

int main() {
    int n, k;
    cin >> n >> k;

    int mini = 1e9;
    int maxi = -1e9;

    int a, first, last;
    for (int i = 0; i < n; ++i) {
        cin >> a;

        if (!i) {
            first = a;
        }

        if (i == n - 1) {
            last = a;
        }

        mini = min(mini, a);
        maxi = max(maxi, a);
    }

    int answer;

    switch (k) {
        case 1:
            answer = mini;
            break;
        case 2:
            answer = max(first, last);
            break;
        default:
            answer = maxi;
    }

    cout<< answer;

    return 0;
}
