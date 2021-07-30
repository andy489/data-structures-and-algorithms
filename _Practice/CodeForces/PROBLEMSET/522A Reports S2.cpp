// github.com/andy489

// https://codeforces.com/problemset/problem/522/A

#include <iostream>
#include <map>

#define q string

using namespace std;

int n, k = 0;
q s, z;
map<q, int> m;

q l(q s) {
    for (int j = 0; j < s.size(); ++j)
        s[j] = tolower(s[j]);
    return s;
}

int main() {
    cin >> n;
    while (n--) {
        cin >> s >> z >> z;
        s = l(s);
        z = l(z);
        m[s] = m[z] + 1;
        k = max(k, m[z] + 1);
    }
    cout << k + 1;
    return 0;
}
