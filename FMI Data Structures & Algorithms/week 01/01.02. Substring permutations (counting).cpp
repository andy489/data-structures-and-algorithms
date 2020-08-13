// github.com/andy489

/*
The idea is to create a char histogram for every of the two given words
and after that to print the minimum usage of
any char in both of the words (if that minimum is greater than 0)
in lexicographical order. Time and memory complexity is
O(m+n), where m and n are the lengths of the given words.
*/

#include <iostream>
#include <string>

using namespace std;

int main() {
    string f, s;
    cin >> f >> s;

    int h1[26] = {0}, h2[26] = {0};

    for (auto it = f.begin(); it != f.end(); ++it)
        ++h1[*it - 'a'];
    for (auto it = s.begin(); it != s.end(); ++it)
        ++h2[*it - 'a'];
    int i = 0, j, m;
    for (; i < 26; ++i)
        if (m = min(h1[i], h2[i]))
            for (j = 0; j < m; ++j)
                cout << char(97 + i);
    return 0;
}
