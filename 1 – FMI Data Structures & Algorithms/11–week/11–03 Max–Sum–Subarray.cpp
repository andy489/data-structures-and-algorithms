// https://www.hackerrank.com/contests/101hack33/challenges/max-sum-subarray/problem

#include <iostream>

using namespace std;

const int MIN = -1e10;

int main() {
    int n;
    cin >> n;


    int best_sum = 0;
    int curr_sum = 0;

    int x;
    while (n--) {
        cin >> x;
        x = x == 0 ? -MIN : x;

        curr_sum = max(0, curr_sum + x);
        best_sum = max(curr_sum, best_sum);
    }

    cout << best_sum;

    return 0;
}
