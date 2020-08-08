// github.com/andy489

#include <iostream>

using namespace std;
const int mxN = 2e5;

int n, m, i;
int res[mxN], aliceScores[mxN], pos[mxN];

int getPlace(int x) {
    int l = 0, r = n - 1;
    while (l < r)
        if (res[(l + r) / 2] <= x)
            r = (l + r) / 2;
        else
            l = (l + r) / 2 + 1;

    if (res[r] <= x)
        return pos[r];
    else
        return pos[r] + 1;
}

int main() {
    cin >> n;
    for (; i < n; ++i)
        cin >> res[i];
    int currPos(1);
    pos[0] = 1;
    for (i = 1; i < n; ++i)
        if (res[i] == res[i - 1])
            pos[i] = currPos;
        else
            pos[i] = ++currPos;
    cin >> m;
    for (i = 0; i < m; ++i) {
        cin >> aliceScores[i];
        cout << getPlace(aliceScores[i]) << endl;
    }
}
