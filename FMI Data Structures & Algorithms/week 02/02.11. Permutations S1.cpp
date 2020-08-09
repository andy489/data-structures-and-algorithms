// github.com/andy489

// https://www.hackerrank.com/contests/practice-2-sda/challenges

#include <iostream>
#include <string>
#include <vector>

using namespace std;

#define ASCII_SYMBOLS 256

vector<int> his(const string &word) {
    vector<int> vec(ASCII_SYMBOLS, 0);
    int SIZE = word.size(), i(0);
    for (; i < SIZE; ++i)
        ++vec[word[i]];
    return vec;
}

bool checkPermText(const string &word1, const string &word2) {
    vector<int> h1 = his(word1), h2 = his(word2);
    int i(0);
    for (; i < ASCII_SYMBOLS; ++i)
        if (h1[i] != h2[i])
            return false;
    return true;
}

int main() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);

    int n;
    cin >> n; // no need
    string word1, word2;
    cin >> word1 >> word2;

    return cout << (checkPermText(word1, word2) ? "yes" : "no"), 0;
}
