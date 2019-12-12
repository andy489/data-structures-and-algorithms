#include <bits/stdc++.h>
using namespace std;

static const int MOD = 1000000000 + 7; // 10^9 + 7 (prime number)
static const int BASE = 257; // prime number
static const int MAX_SIZE = 100001;

long long base_powers[MAX_SIZE];
long long prefix_hash[MAX_SIZE];

void get_powers(int to) {
    base_powers[0] = 1;
    for (int i = 1; i <= to; i++) {
        base_powers[i] = (base_powers[i - 1] * BASE) % MOD;
    }
}

void get_prefix_hashes(string text) {
    for (int i = 0; i < text.size(); i++) {
        prefix_hash[i + 1] = (prefix_hash[i] + text[i] * base_powers[i]) % MOD;
    }
}

long long get_hash(string word) {
    long long result = 0;

    for (int i = 0; i < word.size(); i++) {
        result = (result + word[i] * base_powers[i]) % MOD;
    }

    return result;
}

int rabin_karp(string text, string word) {
    get_powers(text.size());
    get_prefix_hashes(text);

    long long word_hash = get_hash(word);
    long long cur_hash = prefix_hash[word.size()];

    int occurrences = (cur_hash == word_hash);

    for (int i = word.size() + 1; i <= text.size(); i++) {
        cur_hash = (prefix_hash[i] + MOD - prefix_hash[i - word.size()]) % MOD;
        occurrences += (cur_hash == ((word_hash * base_powers[i - word.size()]) % MOD));
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

    cout << rabin_karp(text, word) << endl;

    return 0;
}
