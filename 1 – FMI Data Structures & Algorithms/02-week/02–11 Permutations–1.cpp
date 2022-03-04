// https://www.hackerrank.com/contests/practice-2-sda/challenges
// Permutations

#include <iostream>
#include <string>
#include <vector>

using namespace std;

const int ASCII_SYMBOLS = 256;

vector<int> make_histogram(const string &word) {
    vector<int> vec(ASCII_SYMBOLS);

    int SIZE = word.size();

    for (int i =0; i < SIZE; ++i) {
        ++vec[word[i]];
    }

    return vec;
}

bool check_perm(const string &word1, const string &word2) {
    vector<int> h1 = make_histogram(word1);
    vector<int> h2 = make_histogram(word2);

    for (int i = 0; i < ASCII_SYMBOLS; ++i) {
        if (h1[i] != h2[i]) {
            return false;
        }
    }

    return true;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    string word1, word2;
    cin >> word1 >> word2;

    cout << (check_perm(word1, word2) ? "yes" : "no");

    return 0;
}