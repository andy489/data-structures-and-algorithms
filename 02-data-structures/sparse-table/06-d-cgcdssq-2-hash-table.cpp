// https://codeforces.com/contest/475/problem/D

#include <iostream>
#include <unordered_map>

using namespace std;

typedef long long ll;
#define f first
#define s second

int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    unordered_map<int, ll> temp, perm, answers;

    int n;
    cin >> n;

    int x;
    for (int i = 0; i < n; ++i) {
        cin >> x;
        
        temp.clear();
        ++temp[x];

        for (const auto &j: perm) {
            temp[gcd(x, j.f)] += j.s;
        }

        swap(temp, perm);

        for (const auto &j: perm) {
            answers[j.f] += j.s;
        }
    }

    int q;
    cin >> q;
    while (q--) {
        cin >> x;
        cout << (answers.count(x) ? answers[x] : 0) << endl;
    }
}
