// github.com/andy489

#include <iostream>
#include <vector>

using namespace std;

struct Sector { // Creating a structure Sector to determine all darts shots
    int value;
    bool multiplierX2;

    // constructor with two arguments, one of which is default
    Sector(int value, bool multiplierX2 = false) : value(value), multiplierX2(multiplierX2) {};
};

vector<Sector> fillSectors(int N) {
    vector<Sector> shots;
    shots.reserve(100); //we reserve at least 100 positions to avoid frequent resize
    Sector a(0);
    shots.push_back(a);

    for (int i = 1; i <= 60; i++) {
        Sector a(i);
        if (i <= 20) {
            shots.push_back(a);
            if (i % 2 == 0) {
                Sector a(i, 1);
                shots.push_back(a);
            }
            if (i % 3 == 0) shots.push_back(a);
        } else if (i <= 40) {
            if (i % 2 == 0) {
                Sector a(i, 1);
                shots.push_back(a);
            }
            if (i % 3 == 0) shots.push_back(a);
        } else if (i % 3 == 0) shots.push_back(a);
    }
    Sector x(25), y(50, 1); // outer center & bullseye
    shots.push_back(x);
    shots.push_back(y);
    return shots;
}

int countWays(const std::vector<Sector> &shots, int N) {
    int count(0);

    int SIZE = shots.size();
    for (int i = 0; i < SIZE; ++i) {
        if (shots[i].value == N && shots[i].multiplierX2)
            ++count;
        for (int j = 0; j < SIZE; ++j) {
            if (shots[i].value + shots[j].value == N && shots[j].multiplierX2)
                ++count;
            for (int k = 1; k < SIZE; ++k)
                if (shots[i].value + shots[j].value + shots[k].value == N && shots[k].multiplierX2)
                    ++count;
        }
    }
    return count;
}

int main() {
    int N;
    cin >> N;
    vector<Sector> shots = fillSectors(N); // vector of all possible darts shots
    return cout << countWays(shots, N), 0;
}
