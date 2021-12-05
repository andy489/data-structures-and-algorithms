#include <cstdio>
#include <string>

using namespace std;

#define ALPHABET_SIZE 26

bool palPerm(const string &s) {
    int h[26] = {0}; // constant memory for ascii[a...z] all elements set to 0

    int len(s.size()), i(0);

    for (; i < len; ++i)
        ++h[s[i] - 'a']; // fill histogram for the given word

    if (len & 1) { // odd
        bool flag = false;
        for (i = 0; i < ALPHABET_SIZE; ++i)
            if (*(h + i) & 1) {
                if (flag)
                    return false;
                flag = true;
            }
    } else // even
        for (i = 0; i < ALPHABET_SIZE; ++i)
            if (*(h + i) & 1)
                return false;
    return true;
}

int main() {
    string word;
    scanf("%d", &word);

    return printf((palPerm(word) ? "YES" : "NO")), 0;
}
