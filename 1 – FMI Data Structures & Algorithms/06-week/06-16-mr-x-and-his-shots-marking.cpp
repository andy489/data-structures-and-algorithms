// https://www.hackerrank.com/challenges/x-and-his-shots/problem

#include <iostream>

using namespace std;

const int FIELD = 1e5;

int main() {
    int n, m;
    cin >> n >> m;

    int *opening = new int[FIELD];
    int *closing = new int[FIELD];

    int a, b;
    while (n--) {
        cin >> a >> b;
        ++opening[a];
        ++closing[++b];
    }

    for (int i = 0; i < FIELD - 1; ++i) {
        opening[i + 1] += opening[i];
        closing[i + 1] += closing[i];
    }

    int overlapping = 0;

    while (m--) {
        cin >> a >> b;
        overlapping += opening[b] - closing[a];
    }

    cout << overlapping;
}
