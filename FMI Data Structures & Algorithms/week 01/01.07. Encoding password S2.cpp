// github.com/andy489

#include <cstdio>
#include <vector>
#include <string.h>

using namespace std;

const int mxN = 1e7 + 5;

char input[mxN];

int main() {
    scanf(" %s", input);

    int n = strlen(input), i(1);

    vector<pair<char, int>> counts;
    counts.push_back({input[0], 1});

    for (; i < n; ++i)
        if (input[i - 1] != input[i])
            counts.push_back({input[i], 1});
        else
            ++counts.back().second;

    for (const pair<char, int> &count : counts)
        printf("%d%c", count.second, count.first);

    return printf("\n"), 0;
}
