// https://www.hackerrank.com/contests/si-practice-4/challenges/challenge-1647

#include <iostream>

using namespace std;

struct Snowman {
    int total = 0;
    Snowman *prev = nullptr;
};

int main() {
    int n;
    cin >> n;

    auto *arr = new Snowman[n + 1]; // the first one is the zero snowman

    int dupTarget, add;
    long sum = 0;

    for (int i = 1; i <= n; ++i) {
        cin >> dupTarget >> add;

        if (add == 0) {
            if (arr[dupTarget].prev) {
                arr[i] = *arr[dupTarget].prev;
            }
        } else {
            arr[i].total = arr[dupTarget].total + add;
            arr[i].prev = &arr[dupTarget];
        }
    }

    for (int i = 0; i <= n; ++i) {
        sum += arr[i].total;
    }

    cout << sum;

    return 0;
}