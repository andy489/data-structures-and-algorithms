// github.com/andy489

// https://www.hackerrank.com/challenges/pairs/problem

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
typedef vector<int> vi;
#define sz(x) ((int)x.size())

int bS(vi &vec, int x) {
    int SIZE = sz(vec), ans = 1, start = 0, end = sz(vec) - 1, mid, firEnc = -1;

    while (start <= end) {
        mid = start + (end - start) / 2;
        if (vec[mid] == x)
            firEnc = mid, end = mid - 1;
        else if (vec[mid] > x) 
            end = mid - 1;
        else 
            start = mid + 1;
    }
    if (firEnc == -1) 
        return 0;
    else {
        while (firEnc + 1 < SIZE && vec[firEnc] == vec[firEnc + 1])
            ++ans, ++firEnc;
        return ans;
    }
}

int main() {
    int N, X, res(0), i(0);
    cin >> N >> X;
    vi vec(N);
    for (; i < N; ++i)
        cin >> vec[i];
    sort(vec.begin(), vec.end(), less<int>());
    int curr(vec[0]), prevRes(0);
    if (N == 0)
        cout << res;
    else {
        res += bS(vec, vec[0] + X);
        prevRes = bS(vec, vec[0] + X);
        for (i = 1; i < N; i++) {
            curr = vec[i];
            if (curr != vec[i - 1])
                prevRes = bS(vec, vec[i] + X);
            res += prevRes;
        }
    }
    return cout << res, 0;
}
