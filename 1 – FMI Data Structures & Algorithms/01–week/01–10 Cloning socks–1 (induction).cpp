// https://www.hackerrank.com/contests/practice-1-sda/challenges
// Cloning socks

#include <iostream>

using namespace std;

int myAbs(int a) {
    return a > 0 ? a : -a;
}

int main() {
    int t, cpy, norm;
    cin >> t;

    while (t--) {
        cin >> cpy >> norm; // induction for count of normal socks

        if (norm <= 0) {
            cout << "no";
        }

        if (norm == 1) {
            if (cpy == 0) {
                cout << "yes";
            } else {
                cout << "no";
            }
        }

        if (norm >= 2) {
            if (norm - cpy >= 2) {
                cout << "no";
            } else if (myAbs(cpy - norm) & 1) {
                cout << "yes";
            } else {
                cout << "no";
            }
        }

        cout << endl;
    }

    return 0;
}
