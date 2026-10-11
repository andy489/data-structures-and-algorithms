// https://www.hackerrank.com/challenges/down-to-zero-ii/problem

#include <iostream>
#include <vector>

using namespace std;

const int mxN = 1e6 + 5;

vector<int> down_to_zero() {
    vector<int> compute(mxN, -1);

    for (int i = 0; i < 4; ++i) {
        compute[i] = i;
    }

    for (int i = 2; i < mxN; ++i) {
        if (compute[i] == -1 || compute[i] > compute[i - 1] + 1) {
            compute[i] = compute[i - 1] + 1;
        }

        for (int j = 2; j <= i && j * i < mxN; ++j) {
            if (compute[j * i] == -1 || compute[i] + 1 < compute[j * i]) {
                compute[j * i] = compute[i] + 1;
            }
        }
    }
    
    return compute;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    vector<int> precomputed = down_to_zero();

    int q, n;
    cin >> q;
    while (q--) {
        cin >> n;
        cout << precomputed[n] << endl;
    }

    return 0;
}
