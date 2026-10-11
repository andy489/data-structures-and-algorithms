// https://www.hackerrank.com/contests/test7-sda-soft-eng/challenges/challenge-1770/problem

#include <iostream>
#include <vector>
#include <set>
#include <unordered_map>

using namespace std;

int main() {
    int n, a, c = 0;
    cin >> n;

    unordered_map<int, int> um;
    set<pair<int, int>> set_pairs;

    for (int i = 0; i < n; ++i) {
        cin >> a;

        if (um.find(a) == um.end()) {
            set_pairs.insert({c, a});
        }

        ++um[a];
        ++c;
    }

    vector<int> non_repeated;
    vector<int> repeated;

    for (const auto &x : set_pairs) {
        if (um[x.second] > 1) {
            repeated.push_back(x.second);
        } else {
            non_repeated.push_back(x.second);
        }
    }

    int size1 = non_repeated.size();
    int size2 = repeated.size();

    for (int i = 0; i < size1; ++i) {
        cout << non_repeated[i] << ' ';
    }

    for (int i = 0; i < size2; ++i) {
        cout << repeated[i] << ' ';
    }

    return 0;
}
