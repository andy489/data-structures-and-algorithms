// https://www.hackerrank.com/contests/daa-2020-2021-winter-test2/challenges/dp-1-todo-change-the-name/problem

#include <iostream>
#include <string>
#include <vector>

using namespace std;

const int MOD = 1e9 + 7;

string str;

vector<int> dyn;

unsigned long int solve() {
    dyn[0] = dyn[1] = 1;

    const int LENGTH = str.size();

    for (int i = 1; i < LENGTH; ++i) {
        if (str[i] == str[i - 1]) {
            if (str[i] == 'u' || str[i] == 'n') {
                dyn[i + 1] = (dyn[i] + dyn[i - 1]) % MOD;
            } else {
                dyn[i + 1] = dyn[i];
            }
        } else {
            dyn[i + 1] = dyn[i];
        }
    }

    return dyn[LENGTH];
}

int main() {
    cin >> str;
    const int LENGTH = str.size();

    dyn.resize(LENGTH + 1);

    for (size_t i = 0; i < LENGTH; ++i) {
        if (str[i] == 'm' || str[i] == 'w') {
            cout << 0;
            return 0;
        }
    }

    cout << solve();

    return 0;
}
