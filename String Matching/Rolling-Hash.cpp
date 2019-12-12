#include <bits/stdc++.h>
using namespace std;

static const int MOD = 1000000000 + 7; // 10^9 + 7 (prime number)
static const int BASE = 257; // prime number
static const int MAX_SIZE = 100001;

long long base_powers[MAX_SIZE];

void get_powers(int to) {
    base_powers[0] = 1;
    for (int i = 1; i <= to; i++) {
        base_powers[i] = (base_powers[i - 1] * BASE) % MOD;
    }
}
 
long long get_hash(string word) {
    long long result = 0;

    for (int i = 0; i < word.size(); i++) {
        result = (result + word[i] * base_powers[i]) % MOD;
    }

    return result;
}

int rolling_hash(string text, string word) {
    get_powers(word.size());

    long long word_hash = get_hash(word);
    long long cur_hash = get_hash(text.substr(0, word.size()));

    int occurrences = (cur_hash == word_hash);

    for (int i = word.size(); i < text.size(); i++) {
        cur_hash -= (text[i - word.size()] * base_powers[word.size() - 1]) % MOD;
        cur_hash = ((cur_hash * BASE) % MOD + text[i]) % MOD;

        occurrences += (cur_hash == word_hash);
    }

    return occurrences;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    string text;
    string word;

    cin >> text;
    cin >> word;

    cout << rolling_hash(text, word) << "\n";

    return 0;
}
