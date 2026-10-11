// https://www.hackerrank.com/contests/sda-exam-27-01-19-/challenges/dundee-the-crocodile/problem

#include <iostream>
#include <map>

using namespace std;

int main() {
    map<string, size_t> m;

    string input;

    while (cin >> input) {
        ++m[input];
    }

    for (const auto &kvp : m) {
        if (kvp.second == 1) {
            cout << kvp.first << endl;
        }
    }

    return 0;
}
