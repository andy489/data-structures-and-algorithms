/*
Search for the toy with lowest price and
place it in front of the array of toys.
Proceed iteratively with the second toy
searching for toy with lowest price, among
all left toys and stop when we exceed the budget.
*/

#include <iostream>

const int MAX = 1e5;

using namespace std;

void swap(int &a, int &b) {
    int tmp = a;
    a = b;
    b = tmp;
}

int main() {
    int n, k;
    cin >> n >> k;

    int toys[MAX]{};

    for (int i = 0; i < n; ++i) {
        cin >> toys[i];
    }

    int index, sum(0), j;

    for (int i = 0; i < n; ++i) {
        index = i;

        for (j = i + 1; j < n; ++j) {
            if (toys[j] < toys[index]) {
                index = j;
            }
        }

        swap(toys[index], toys[i]);
        sum += toys[i];

        if (sum > k) {
            cout << i;
            return 0;
        }
    }

    cout << n;
    return 0;
}
