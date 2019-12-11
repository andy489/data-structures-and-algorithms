#include <cstdio>
#include <vector>

using namespace std;

vector<vector<int>> moves = {
    {0},
    {1,2,3},
    {2,4,6},
    {3,6,9},
    {4,8,12},
    {5,10,15},
    {6,12,18},
    {7,14,21},
    {8,16,24},
    {9,18,27},
    {10,20,30},
    {11,22,33},
    {12,24,36},
    {13,26,39},
    {14,28,42},
    {15,30,45},
    {16,32,48},
    {17,34,51},
    {18,36,54},
    {19,38,57},
    {20,40,60},
    {25,50}
};

int n;

int iterate(int sum, int c_moves, bool double_move) {
    if (sum > n || c_moves > 3 || (sum == n && !double_move)) {
        return 0;
    } else if (sum == n) {
        return 1;
    }

    int res = 0;

    for (int i = 0; i < moves.size(); i++) {
        for (int j = 0; j < moves[i].size(); j++) {
            res += iterate(sum + moves[i][j], c_moves + 1, j == 1);
        }
    }

    return res;
}

int main() {
    scanf("%d", &n);
    printf("%d\n", iterate(0, 0, false));
    return 0;
}
