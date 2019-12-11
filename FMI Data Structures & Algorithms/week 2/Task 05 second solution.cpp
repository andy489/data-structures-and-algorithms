#include <cstdio>
#include <cstring>

using namespace std;

const int MAXN = 150 * 1e6 + 5;

int n, m, A[26];
char S1[MAXN], S2[MAXN];

int main() {
    scanf("%*d");
    scanf(" %s", S1);
    scanf(" %s", S2);

    n = strlen(S1);
    m = strlen(S2);

    for (int i = 0; i < n; i++) {
        A[S1[i] - 'a']++;
    }

    for (int i = 0; i < m; i++) {
        A[S2[i] - 'a']--;
    }

    for (int i = 0; i < 26; i++) {
        if (A[i] != 0) {
            printf("no\n");
            return 0;
        }
    }

    printf("yes\n");

    return 0;
}
