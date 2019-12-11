#include <cstdio>
#include <utility>
#include <vector>
#include <string.h>

using namespace std;

const int MAXN = 1e7 + 5;

char input[MAXN];

int main() {
    scanf(" %s", input);

    int n = strlen(input);

    vector<pair<char, int>> counts;
    counts.push_back({input[0], 1});

    for (int i = 1; i < n; i++) {
        if (input[i - 1] != input[i]) {
            counts.push_back({input[i], 1});
        } else {
            counts.back().second++;
        }
    }

    for (const pair<char, int> &count : counts) {
        printf("%d%c", count.second, count.first);
    }

    printf("\n");

    return 0;
}
