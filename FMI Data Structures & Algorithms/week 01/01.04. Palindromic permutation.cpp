//github.com/andy489

#include <iostream>
#include <string>

using namespace std;

bool palPerm(const string &s) {
    int h[26] = {0}; // constant memory for ascii[a...z] all elements set to 0

    int len(s.size()), i(0);

    for (; i < len; ++i)
        ++h[s[i] - 'a']; // fill histogram for the given word

    if (len & 1) { // odd
        bool flag = false;
        for (i = 0; i < 26; ++i)
            if (*(h + i) & 1) {
                if (flag)
                    return false;
                flag = true;
            }
    } else // even
        for (i = 0; i < 26; ++i)
            if (*(h + i) & 1)
                return false;
    return true;
}

int main() {
    string word;
    cin >> word;

    return cout << (palPerm(word) ? "YES" : "NO"), 0;
}
