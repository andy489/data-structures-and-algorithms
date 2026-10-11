/*
The idea is to create a char histogram for every of the two given words
and after that to print the minimum usage of
any char in both of the words (if that minimum is greater than 0)
in lexicographical order. Time and memory complexity is
O(m + n), where m and n are the lengths of the given words.
*/

#include <iostream>
#include <string>

using namespace std;

int main() {
    string f, s;
    cin >> f >> s;

    int h1[26] = {0};
    int h2[26] = {0};

    for (char &it : f) {
        ++h1[it - 'a'];
    }

    for (char &it : s) {
        ++h2[it - 'a'];
    }

    for (int i = 0; i < 26; ++i) {
        int m = min(h1[i], h2[i]);

        if (m) { // true if minimum is not 0
            for (int j = 0; j < m; ++j) {
                cout << char(97 + i);
            }
        }
    }

    return 0;
}
