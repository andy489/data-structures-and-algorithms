// https://www.hackerrank.com/contests/practice-1-sda/challenges
// Darts 501

#include <cstdio>
#include <vector>

using namespace std;

int recursive_add_move(int sum, int c_moves, bool double_move, int n,vector<vector<int>>& moves) {

    if (sum > n || c_moves > 3 || (sum == n && !double_move)) {
        return 0;
    }

    else if (sum == n) {
        return 1;
    }

    int res = 0;

    for (auto & move : moves) {
        for (int j = 0; j < move.size(); ++j) {
            res += recursive_add_move(sum + move[j], c_moves + 1, j == 1, n, moves);
        }
    }

    return res;
}

int main() {
    int n;
    scanf("%d", &n);

    vector<vector<int>> moves = {
            {0},
            {1,  2,  3},
            {2,  4,  6},
            {3,  6,  9},
            {4,  8,  12},
            {5,  10, 15},
            {6,  12, 18},
            {7,  14, 21},
            {8,  16, 24},
            {9,  18, 27},
            {10, 20, 30},
            {11, 22, 33},
            {12, 24, 36},
            {13, 26, 39},
            {14, 28, 42},
            {15, 30, 45},
            {16, 32, 48},
            {17, 34, 51},
            {18, 36, 54},
            {19, 38, 57},
            {20, 40, 60},
            {25, 50}
    };

    printf("%d", recursive_add_move(0, 0, false, n, moves));

    return 0;
}
