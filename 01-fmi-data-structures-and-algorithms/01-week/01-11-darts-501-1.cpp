// https://www.hackerrank.com/contests/practice-1-sda/challenges
// Darts 501

#include <iostream>
#include <vector>

using namespace std;

struct Sector { // Creating a structure Sector to determine all darts shots
    int value;
    bool multiplier_x2;

    // constructor with two arguments, one of which is default
    explicit Sector(int value, bool multiplierX2 = false) : value(value), multiplier_x2(multiplierX2) {};
};

vector<Sector> fill_sectors() {
    vector<Sector> shots;
    shots.reserve(100); //we reserve at least 100 positions to avoid frequent resize

    shots.emplace_back(0);

    for (int i = 1; i <= 60; ++i) {
        if (i <= 20) {
            shots.emplace_back(i);

            if (i % 2 == 0) {
                shots.emplace_back(i, 1);
            }
            if (i % 3 == 0) {
                shots.emplace_back(i);
            }
        } else if (i <= 40) {
            if (i % 2 == 0) {
                shots.emplace_back(i, 1);
            }
            if (i % 3 == 0) {
                shots.emplace_back(i);
            }
        } else if (i % 3 == 0) {
            shots.emplace_back(i);
        }
    }

    shots.emplace_back(25); // outer center
    shots.emplace_back(50, 1); // bullseye

    return shots;
}

int count_ways(const vector<Sector> &shots, int n) {
    const int SIZE = shots.size();
    int cnt = 0;

    for (int i = 0; i < SIZE; ++i) {
        if (shots[i].value == n && shots[i].multiplier_x2) {
            ++cnt;
        }

        for (int j = 0; j < SIZE; ++j) {
            if (shots[i].value + shots[j].value == n && shots[j].multiplier_x2) {
                ++cnt;
            }

            for (int k = 1; k < SIZE; ++k) {
                if (shots[i].value + shots[j].value + shots[k].value == n && shots[k].multiplier_x2) {
                    ++cnt;
                }
            }
        }
    }

    return cnt;
}

int main() {
    int n;
    cin >> n;

    vector<Sector> shots = fill_sectors(); // vector of all possible darts shots

    cout << count_ways(shots, n);

    return 0;
}
