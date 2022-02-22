// https://www.hackerrank.com/challenges/30-2d-arrays/problem

#include <iostream>
#include <vector>

using namespace std;

vector<int> xd{0, 0, 0, -1, -2, -2, -2};
vector<int> yd{0, -1, -2, -1, 0, -1, -2};

const int DIM = 7;

int calc_hourglass(vector<vector<int>> &arr, int x, int y) {
    int curr_hourglass = 0;

    for (int i = 0; i < DIM; ++i) {
        curr_hourglass += arr[x + xd[i]][y + yd[i]];
    }

    return curr_hourglass;
}

int main() {
    vector<vector<int>> arr(DIM - 1, vector<int>(DIM - 1));
    int curr, max_hour_glass = -7 * 9;
    
    for (int i = 0; i < DIM - 1; ++i) {
        for (int j = 0; j < DIM - 1; ++j) {
            cin >> arr[i][j];
            if (i > 1 && j > 1) {
                curr = calc_hourglass(arr, i, j);
                max_hour_glass = curr > max_hour_glass ? curr : max_hour_glass;
            }
        }
    }
    cout << max_hour_glass;
    
    return 0;
}
