// github.com/andy489

/*
We search for the toy with lowest price and
place it in front of the array of toys.
We proceed iteratively with the second toy
searching for toy with lowest price, among
all left toys and stop when we exceed the budget
*/

#include <iostream>

#define mxN (int)1e5

using namespace std;

void swap(int &a, int &b) {
    int tmp = a;
    a = b;
    b = tmp;
}

int main() {
    int N, K;
    cin >> N >> K;
    int toys[mxN], i(0);
    for (; i < N; ++i)
        cin >> toys[i];

    int index, sum(0), j;

    for (i = 0; i < N; ++i) {
        index = i;
        for (j = i + 1; j < N; ++j)
            if (toys[j] < toys[index])
                index = j;
        swap(toys[index], toys[i]);
        sum += toys[i];
        if (sum > K)
            return cout << i, 0;
    }
    return cout << i, 0;
}
