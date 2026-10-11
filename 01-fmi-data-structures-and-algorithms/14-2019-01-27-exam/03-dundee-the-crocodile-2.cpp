// https://www.hackerrank.com/contests/sda-exam-27-01-19-/challenges/dundee-the-crocodile/problem

#include <iostream>
#include <set>

using namespace std;

int main() {
    multiset<string> ms;

    string input;
    while (cin >> input) {
        ms.insert(input);
    }

    auto it = ms.begin();
    while (it != ms.end()) {
        int count = ms.count(*it);
        
        if (count == 1) {
            cout << *it << endl;
        }
        ++it;
    }

    return 0;
}
