// github.com/andy489

// https://www.hackerrank.com/contests/practice-7-sda/challenges/text-contents

#include <iostream>
#include <vector>
#include <unordered_map>
#include <climits>

using namespace std;

#define BASE 257
#define MOD 18446744073709551613 // almost the limit of unsigned long long

typedef unsigned long long ull;


void precompute(vector<ull> &basePows, ull &winSize, int k) {
    basePows[0] = 1;
    int i;
    for (i = 1; i < k; i++)
        basePows[i] = (basePows[i - 1] * BASE) % MOD;
    winSize = basePows[i - 1];
}

class RollingHash {
private:

    ull winSize = BASE; // window size
    vector<ull> basePows;
    ull currHash;
    int index; // points to where each word ends at

    ull hash(string &str, int k) {
        ull result = 0;
        for (int i = 0; i < k; i++)
            result = (result + basePows[k - i - 1] * str[i]) % MOD;

        return result;
    }

public:

    unordered_map<ull, pair<int, int>> hashes;

    RollingHash(int k, string word) : index(k) {
        basePows.resize(k);
        precompute(basePows, winSize, k);
        currHash = hash(word, k);
        hashes.reserve(1000000);
        hashes[currHash].first++;
        hashes[currHash].second = 0;
    }

    void append(char newCh) {
        currHash = (currHash * BASE + newCh) % MOD;
        hashes[currHash].first++;
        hashes[currHash].second = index;
        index++;
    }

    void pop(char old) {
        currHash = (currHash - old * winSize + MOD * BASE) % MOD;
    }

};

int main() {
    int N, K;
    cin >> N >> K;
    cin.ignore();

    string input;
    getline(cin, input);

    RollingHash r(K, input.substr(0, K));
    int counter = 0;
    for (auto i = K; i < N; i++) {
        r.pop(input[counter++]);
        r.append(input[i]);
    }

    int currFrequent;
    int mostFrequent = INT_MIN;
    int indexMostFrequent = INT_MIN;
    auto it = r.hashes.begin();
    while (it != r.hashes.end()) {
        currFrequent = it->second.first;
        if (mostFrequent < currFrequent) {
            mostFrequent = currFrequent;
            indexMostFrequent = it->second.second;
        } else if (mostFrequent == currFrequent) {
            if (indexMostFrequent < it->second.second)
                indexMostFrequent = it->second.second;
        }
        ++it;
    }

    string ans;
    if (K == 1)
        ans = input[indexMostFrequent];
    else
        ans = input.substr(indexMostFrequent - K + 1, indexMostFrequent);
    return cout << ans, 0;
}
