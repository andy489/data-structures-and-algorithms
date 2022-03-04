// https://www.hackerrank.com/contests/practice-1-sda/challenges
// Darts 501

#include <iostream>
#include <vector>

using namespace std;

int main() {
    int res;
    cin >> res;

    vector<int> p; // points

    p.reserve(100);

    for (int i = 0; i <= 20; ++i) {
        p.push_back(i); // zero plus points from single sector
    }
    for (int i = 1; i <= 20; ++i) {
        p.push_back(3 * i); // points from triple sector
    }

    p.push_back(25); // outer circle

    for (int i = 1; i <= 20; i++) {
        p.push_back(2 * i); // points from double circle
    }
    
    p.push_back(50); // inner circle (bullseye)

    // from 42 starts the double sector shots
    const int DOUBLE_SECTOR_PTS = 42;

    int cnt = 0;
    int SIZE = p.size();

    for (int i = 0; i < SIZE; ++i) {
        if (p[i] == res && i >= DOUBLE_SECTOR_PTS) {
            ++cnt;
        }
        for (int j = 0; j < SIZE; ++j) {
            if (p[i] + p[j] == res && j >= DOUBLE_SECTOR_PTS) {
                ++cnt;
            }
            for (int m = 0; m < SIZE; ++m) {
                if (p[i] + p[j] + p[m] == res && m >= DOUBLE_SECTOR_PTS) {
                    ++cnt;
                }
            }
        }
    }

    cout << cnt;

    return 0;
}

