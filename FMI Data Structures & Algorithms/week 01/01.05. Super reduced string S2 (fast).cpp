// github.com/andy489

#include <stdio.h>

using namespace std;

char s[1000];

int main() {
    scanf("%s", s);

    int k = 1;
    for (int i = 1; s[i]; ++i) {
        if (s[i] == s[k - 1]) 
            --k;
        else 
            s[k++] = s[i];
    }

    s[k] = 0;
    if (k == 0) 
        printf("Empty String\n");
    else 
        printf("%s\n", s);

    return 0;
}
