// github.com/andy489

// https://www.hackerrank.com/contests/sda-exam-27-01-19-/challenges/dundee-the-crocodile

#include<iostream>
#include <map>

using namespace std;

int main() {
    map<string, size_t> m;
    string w;
    while (cin >> w)
        ++m[w];
    for (const auto &kvp:m)
        if (kvp.second == 1)
            cout << kvp.first << '\n';
    return 0;
}
