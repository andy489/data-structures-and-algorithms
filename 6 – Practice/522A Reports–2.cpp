// https://codeforces.com/problemset/problem/522/A

#include <iostream>
#include <algorithm>
#include <map>

using namespace std;

map<string, int> m;

char ascii_to_lower(char in) {
    if (in <= 'Z' && in >= 'A') {
        return (char) (in - ('Z' - 'z'));
    }

    return in;
}

int main() {
    int n;
    cin >> n;

    int depth = 0;

    string child, parent;
    while (n--) {
        cin >> child >> parent >> parent;

        transform(parent.begin(), parent.end(), parent.begin(), ascii_to_lower);
        transform(child.begin(), child.end(), child.begin(), ascii_to_lower);

        m[child] = m[parent] + 1;

        depth = max(depth, m[parent] + 1);
    }

    cout << depth + 1;

    return 0;
}
