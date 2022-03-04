// https://www.hackerrank.com/challenges/bigger-is-greater/problem
// 2nd solution (build-in func)

#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int t;
    cin >> t;

    string w;
    while (t--) {
        cin >> w;
        if (next_permutation(w.begin(), w.end())) {
            cout << w << endl;
        } else {
            cout << "no answer" << endl;
        }
    }
}