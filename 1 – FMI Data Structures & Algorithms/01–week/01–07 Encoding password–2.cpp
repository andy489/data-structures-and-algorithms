// https://www.hackerrank.com/contests/practice-1-sda/challenges
// Encoding Password

#include <cstdio>
#include <vector>
#include <cstring>

using namespace std;

const int mxN = 1e7 + 5;

char input[mxN];

int main() {
    scanf("%s", input);

    const int N = strlen(input);

    vector<pair<char, int>> counts;
    counts.emplace_back(input[0], 1);

    for (int i = 1; i < N; ++i)
        if (input[i - 1] != input[i]) {
            counts.emplace_back(input[i], 1);
        } else {
            ++counts.back().second;
        }

    for (const pair<char, int> &count : counts) {
        printf("%d%c", count.second, count.first);
    }

    return 0;
}

