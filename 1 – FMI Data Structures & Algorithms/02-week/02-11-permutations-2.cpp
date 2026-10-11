// https://www.hackerrank.com/contests/practice-2-sda/challenges
// Permutations

#include <cstdio>
#include <cstring>

using namespace std;

const int MAX = 150 * 1e6 + 5;
const int SIGMA_SIZE = 26;
int ASCII[SIGMA_SIZE];

char str[MAX]{};

int main() {
    int d;
    
    scanf("%d %s", &d, &str);

    int n = strlen(str);

    for (int i = 0; i < n; ++i) {
        ++ASCII[str[i] - 'a'];
    }

    scanf("%s", &str);
    int m = strlen(str);

    for (int i = 0; i < m; ++i) {
        --ASCII[str[i] - 'a'];
    }

    for (int i : ASCII) {
        if (i) {
            printf("no");
            return 0;
        }
    }

    printf("yes");
    return 0;
}
