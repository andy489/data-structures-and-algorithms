// github.com/andy489

#include <iostream>
#include <vector>

using namespace std;

int main() {
    int res;
    cin >> res;
    vector<int> p; // points
    p.reserve(100);
    for (int i = 0; i <= 20; ++i)
        p.push_back(i); // zero plus points from single sector	
    for (int i = 1; i <= 20; ++i)
        p.push_back(3 * i); // points from triple sector	
    p.push_back(25); // outer circle
    for (int i = 1; i <= 20; i++)
        p.push_back(2 * i); // points from double circle

    p.push_back(50); // inner circle (bullseye)
    //cout << points[42]; from here starts the double sector shots

    int cnt(0);
    int SIZE = p.size();

    for (int i = 0; i < SIZE; ++i) {
        if (p[i] == res && i >= 42) 
            ++cnt;
        for (int j = 0; j < SIZE; ++j) {
            if (p[i] + p[j] == res && j >= 42) 
                ++cnt;
            for (int m = 0; m < SIZE; ++m) {
                if (p[i] + p[j] + p[m] == res && m >= 42)
                    ++cnt;
            }
        }
    }

    return cout << cnt, 0;
}
