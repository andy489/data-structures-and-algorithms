// https://www.hackerrank.com/contests/practice-1-sda/challenges
// Watter Supplies

#include <iostream>
#include <vector>

using namespace std;

int min(int a, int b) {
    return a > b ? b : a;
}

int main() {
    int n;
    cin >> n;

    vector<int> walls(n);

    for (int i = 0; i < n; ++i) {
        cin >> walls[i];
    }

    int max_water = 0;

    for (int i = 0; i < n; ++i) {
        for (int j = i + 1; j < n; ++j) {
            if ((j - i) * min(walls[i], walls[j]) > max_water) {
                max_water = (j - i) * min(walls[i], walls[j]);
            }
        }
    }

    cout << max_water;

    return 0;
}
