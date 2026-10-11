// https://www.hackerrank.com/challenges/extra-long-factorials/problem

#include <vector>
#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;

    vector<int> b;
    b.push_back(1);

    for (size_t i = 2; i <= n; ++i) {
        for (int & it : b) {
            it *= i;
        }

        for (size_t j = 0; j < b.size(); ++j) {
            if (b[j] < 10) {
                continue;
            }

            if (j == b.size() - 1) {
                b.push_back(0);
            }

            b[j + 1] += b[j] / 10;
            b[j] %= 10;
        }
    }


    for (auto it = b.rbegin(); it != b.rend(); ++it) {
        cout << *it;
    }

    return 0;
}