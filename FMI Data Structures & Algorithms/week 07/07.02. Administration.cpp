// github.com/andy489

// https://www.hackerrank.com/contests/test7-sda-soft-eng/challenges/challenge-1770/problem

#include <iostream>
#include <vector>
#include <unordered_map>
#include <set>

using namespace std;

int main() {
    unordered_map<int, int> um;
    set<pair<int, int>> setPairs;

    int n, i(0), a, c(0);
    cin >> n;

    for (; i < n; ++i) {
        cin >> a;
        if (um.find(a) == um.end())
            setPairs.insert({c, a});
        ++um[a];
        ++c;
    }

    vector<int> nonRepeated, repeated;

    for (const auto &x : setPairs) {
        if (um[x.second] > 1)
            repeated.push_back(x.second);
        else
            nonRepeated.push_back(x.second);
    }

    int size1 = nonRepeated.size(), size2 = repeated.size();

    for (i = 0; i < size1; ++i)
        cout << nonRepeated[i] << ' ';

    for (i = 0; i < size2; ++i)
        cout << repeated[i] << ' ';

    return 0;
}
