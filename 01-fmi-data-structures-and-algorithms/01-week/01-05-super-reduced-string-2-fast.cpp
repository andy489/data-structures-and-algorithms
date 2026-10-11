// https://www.hackerrank.com/challenges/reduced-string/problem

#include <cstdio>

using namespace std;

char s[1000];

int main() {
    scanf("%s", s);

    int k = 1;

    for (int i = 1; s[i]; ++i) {
        if (s[i] == s[k - 1]) {
            --k;
        } else {
            s[k++] = s[i];
        }
    }

    s[k] = 0;

    printf("%s", k ? s : "Empty String");

    return 0;
}
