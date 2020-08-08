// github.com/andy489

/*
If (twice the length of the most common string character does not
exceed the length of the entire string + 1 and the string has at least two
different characters) OR (string is only one character) the answer is YES.
In all other cases, the answer is NO.
 */

#include <iostream>
#include <string>

using namespace std;

size_t *charHistogram(std::string word) {
    size_t *his = new size_t[26]();
    size_t SIZE = word.length();
    for (size_t i = 0; i < SIZE; i++) his[word[i] - 97]++;
    return his;
}

int main() {
    string word;
    cin >> word;
    int his[26];
    int SIZE = word.length(), i(0);
    for (; i < SIZE; i++)
        ++his[word[i] - 'a'];

    int maxCnt(0), cntDiffCh(0);
    for (i = 0; i < 26; ++i) {
        if (his[i] > 0) ++cntDiffCh;
        if (his[i] > maxCnt) maxCnt = his[i];
    }
    return cout << (((2 * maxCnt <= word.size() + 1 && cntDiffCh > 1) || word.size() == 1) ? "Yes" : "No"), 0;
}
