// https://www.hackerrank.com/challenges/magic-square-forming/problem

#include <iostream>
#include <vector>

using namespace std;

const int N = 3;
const int M = 9;

int main() {
    vector<vector<int> > all_magic_squares = {
            {8, 1, 6, 3, 5, 7, 4, 9, 2},
            {4, 3, 8, 9, 5, 1, 2, 7, 6},
            {2, 9, 4, 7, 5, 3, 6, 1, 8},
            {6, 7, 2, 1, 5, 9, 8, 3, 4},
            {6, 1, 8, 7, 5, 3, 2, 9, 4},
            {8, 3, 4, 1, 5, 9, 6, 7, 2},
            {4, 9, 2, 3, 5, 7, 8, 1, 6},
            {2, 7, 6, 9, 5, 1, 4, 3, 8}
    };
    
    int a[M];

    for (int &i : a) {
        cin >> i;
    }

    int best = 100;

    for (int i = 0; i < M - 1; ++i) {
        int diff = 0;

        for (int j = 0; j < M; ++j) {
            diff += abs(a[j] - all_magic_squares[i][j]);
        }

        if (diff < best) {
            best = diff;
        }
    }

    cout << best;
    return 0;
}
