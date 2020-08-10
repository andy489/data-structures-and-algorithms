// github.com/andy489

#include <iostream>

using namespace std;

int myAbs(int a) {
    return a > 0 ? a : -a;
}

int main() {
    int T, cpy, norm, i(0);
    cin >> T;

    for (; i < T; ++i) {
        cin >> cpy >> norm; // induction for count of normal socks
        if (norm <= 0)
            cout << "no\n";
        if (norm == 1)
            if (cpy == 0)
                cout << "yes\n";
            else
                cout << "no\n";
        if (norm >= 2)
            if (norm - cpy >= 2)
                cout << "no\n";
            else if (myAbs(cpy - norm) & 1)
                cout << "yes\n";
            else
                cout << "no\n";
    }
    return 0;
}
